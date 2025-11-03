package lotto.service;

import java.util.List;
import java.util.ArrayList;

import lotto.domain.Lotto;
import lotto.domain.WinningLotto;
import lotto.domain.WinningResult;
import lotto.domain.LottoNumberGenerator;

public class LottoService {
    private final LottoNumberGenerator lottoNumberGenerator;

    public LottoService() {
        this.lottoNumberGenerator = new LottoNumberGenerator();
    }

    public List<Lotto> generateLottoNumbers(int lottoCount) {
        List<Lotto> lottos = new ArrayList<>();
        for (int i = 0; i < lottoCount; i++) {
            lottos.add(lottoNumberGenerator.generate());
        }
        return lottos;
    }

    public List<WinningResult> calculateResults(List<Lotto> lottos, WinningLotto winningLotto) {
        List<WinningResult> results = new ArrayList<>();
        for (Lotto lotto : lottos) {
            int matchCount = lotto.countMatchingNumbers(winningLotto);
            boolean bonusMatch = lotto.getBonusMatch(winningLotto);
            WinningResult winningResult = new WinningResult(matchCount, bonusMatch);
            results.add(winningResult);
        }
        return results;
    }
}
