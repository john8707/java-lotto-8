package lotto.domain;

public class WinningResult {
    private final int matchCount;
    private final boolean bonusMatch;

    public WinningResult(int matchCount, boolean bonusMatch) {
        this.matchCount = matchCount;
        this.bonusMatch = bonusMatch;
    }

    public int getMatchCount() {
        return matchCount;
    }

    public boolean isBonusMatch() {
        return bonusMatch;
    }
}
