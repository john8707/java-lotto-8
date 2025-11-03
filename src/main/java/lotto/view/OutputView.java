package lotto.view;

import java.util.List;
import java.util.Map;

import lotto.domain.Lotto;
import lotto.domain.Rank;

public class OutputView {
    private static final String OUTPUT_LOTTO_COUNT = "%d개를 구매했습니다.";
    private static final String OUTPUT_RANK_STATISTICS = "당첨 통계\n---";
    private static final String OUTPUT_RANK_LINE = "%d개 일치%s (%,d원) - %d개";
    private static final String OUTPUT_BONUS_REQUIRED = ", 보너스 볼 일치";

    public void printLottoCount(int count) {
        System.out.printf(OUTPUT_LOTTO_COUNT + "\n", count);
    }

    public void printLottoNumbers(List<Lotto> lottos) {
        for (Lotto lotto : lottos) {
            System.out.println(lotto.getNumbers());
        }
        System.out.println();
    }

    public void printRankStatistics(Map<Rank, Integer> rankCount) {
        System.out.println(OUTPUT_RANK_STATISTICS);
        List<Rank> rankDisplayOrder = List.of(
            Rank.FIFTH,
            Rank.FOURTH,
            Rank.THIRD,
            Rank.SECOND,
            Rank.FIRST
        );
        
        for (Rank rank : rankDisplayOrder) {
            String bonusInfo = getBonusInfo(rank.getRequireBonusMatch());
            int count = rankCount.getOrDefault(rank, 0);
            System.out.printf(OUTPUT_RANK_LINE + "\n",
                    rank.getMatchCount(),
                    bonusInfo,
                    rank.getPrizeMoney(),
                    count);
        }
    }

    private String getBonusInfo(boolean requireBonusMatch) {
       if (requireBonusMatch) {
           return OUTPUT_BONUS_REQUIRED;
       }
        return "";
    }
}
