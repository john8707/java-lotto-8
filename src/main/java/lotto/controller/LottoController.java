package lotto.controller;

import java.util.List;
import java.util.Arrays;

import lotto.domain.PurchaseAmount;
import lotto.domain.Lotto;
import lotto.domain.WinningLotto;
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
    }

    private PurchaseAmount getPurchaseAmount() {
        String input = inputView.readPurchaseAmount();
        int amount = Integer.parseInt(input);
        return new PurchaseAmount(amount);
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
}
