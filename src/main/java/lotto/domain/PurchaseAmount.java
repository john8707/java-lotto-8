package lotto.domain;

public class PurchaseAmount {
    private static final int LOTTO_PRICE = 1000;
    private final int purchasePrice;

    public PurchaseAmount(int purchasePrice) {
        this.purchasePrice = purchasePrice;
    }

    public int getLottoCount() {
        return purchasePrice / LOTTO_PRICE;
    }
}
