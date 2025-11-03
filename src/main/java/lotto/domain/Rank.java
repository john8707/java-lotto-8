package lotto.domain;

public enum Rank{
    FIRST(6, false, 2_000_000_000L),
    SECOND(5, true, 30_000_000L),
    THIRD(5, false, 1_500_000L),
    FOURTH(4, false, 50_000L),
    FIFTH(3, false, 5_000L),
    LOSE(0, false, 0L);

    private final int matchCount;
    private final boolean requireBonusMatch;
    private final long prizeMoney;


    Rank(int matchCount, boolean requireBonusMatch, long prizeMoney) {
        this.matchCount = matchCount;
        this.requireBonusMatch = requireBonusMatch;
        this.prizeMoney = prizeMoney;
    }

    public static Rank getRank(int matchCount, boolean bonusMatch) {
        if (matchCount == 6) {
            return FIRST;
        }
        if (matchCount == 5 && bonusMatch) {
            return SECOND;
        }
        if (matchCount == 5) {
            return THIRD;
        }
        if (matchCount == 4) {
            return FOURTH;
        }
        if (matchCount == 3) {
            return FIFTH;
        }
        return LOSE;
    }

    public int getMatchCount() {
        return matchCount;
    }

    public boolean getRequireBonusMatch() {
        return requireBonusMatch;
    }

    public long getPrizeMoney() {
        return prizeMoney;
    }
}
