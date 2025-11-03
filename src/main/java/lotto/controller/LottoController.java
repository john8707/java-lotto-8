package lotto.controller;

import java.util.List;
import java.util.Map;
import java.util.Arrays;
import java.util.HashMap;

import lotto.domain.PurchaseAmount;
import lotto.domain.Rank;
import lotto.domain.Lotto;
import lotto.domain.WinningLotto;
import lotto.domain.MatchResult;
import lotto.service.LottoService;
import lotto.view.InputView;
import lotto.view.OutputView;

public class LottoController {
    private final InputView inputView;
    private final OutputView outputView;
    private final LottoService lottoService;

    public LottoController() {
        this.inputView = new InputView();
        this.outputView = new OutputView();
        this.lottoService = new LottoService();
    }

    public void run() {
        PurchaseAmount purchaseAmount = getPurchaseAmount();
        outputView.printLottoCount(purchaseAmount.getLottoCount());

        List<Lotto> lottos = lottoService.generateLottoNumbers(purchaseAmount.getLottoCount());
        outputView.printLottoNumbers(lottos);

        WinningLotto winningLotto = getWinningLotto();
        List<MatchResult> matchResults = lottoService.getMatchResults(lottos, winningLotto);

        List<Rank> ranks = lottoService.getRanksFromResults(matchResults);
        Map<Rank, Integer> rankCount = aggregateRanks(ranks);

        outputView.printRankStatistics(rankCount);
        double roi = lottoService.calculateROI(rankCount, purchaseAmount.getTotalSpent());
        outputView.printROI(roi);
    }

    private PurchaseAmount getPurchaseAmount() {
        String input = inputView.readPurchasePrice();
        int price = Integer.parseInt(input);
        return new PurchaseAmount(price);
    }

    private WinningLotto getWinningLotto() {
        String inputWinningNumbers = inputView.readWinningNumbers();
        String inputBonusNumber = inputView.readBonusNumber();

        List<Integer> winningNumbers = Arrays.stream(inputWinningNumbers.split(","))
                .map(String::trim)
                .map(Integer::parseInt)
                .toList();

        int bonusNumber = Integer.parseInt(inputBonusNumber);
        return new WinningLotto(winningNumbers, bonusNumber);
    }

    private Map<Rank, Integer> aggregateRanks(List<Rank> ranks) {
        Map<Rank, Integer> rankCountMap = new HashMap<>();
        for (Rank rank : ranks) {
            rankCountMap.put(rank, rankCountMap.getOrDefault(rank, 0) + 1);
        }
        return rankCountMap;
    }
}
