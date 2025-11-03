package lotto.domain;

public enum Rank{
    FIRST(2_000_000_000L),
    SECOND(30_000_000L),
    THIRD(1_500_000L),
    FOURTH(50_000L),
    FIFTH(5_000L),
    LOSE(0L);

    private final long prizeMoney;

    Rank(long prizeMoney) {
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

    public long getPrizeMoney() {
        return prizeMoney;
    }
}
