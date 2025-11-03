package lotto.service;

import java.util.List;
import java.util.ArrayList;

import lotto.domain.Lotto;
import lotto.domain.WinningLotto;
import lotto.domain.MatchResult;
import lotto.domain.Rank;
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

    public List<MatchResult> getMatchResults(List<Lotto> lottos, WinningLotto winningLotto) {
        List<MatchResult> results = new ArrayList<>();
        for (Lotto lotto : lottos) {
            int matchCount = lotto.countMatchingNumbers(winningLotto.getNumbers());
            boolean bonusMatch = lotto.getBonusMatch(winningLotto.getBonusNumber());
            MatchResult matchResult = new MatchResult(matchCount, bonusMatch);
            results.add(matchResult);
        }
        return results;
    }

    public List<Rank> getRanksFromResults(List<MatchResult> results) {
        List<Rank> ranks = new ArrayList<>();
        for (MatchResult result : results) {
            Rank rank = Rank.getRank(result.getMatchCount(), result.isBonusMatch());
            ranks.add(rank);
        }
        return ranks;
    }
}
