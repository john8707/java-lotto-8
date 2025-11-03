package lotto.domain;

import lotto.exception.ErrorMessage;

public class PurchaseAmount {
    private static final int LOTTO_PRICE = 1000;
    private final int purchasePrice;

    public PurchaseAmount(int purchasePrice) {
        if (purchasePrice <= 0 || purchasePrice % LOTTO_PRICE != 0) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_PURCHASE_AMOUNT.getMessage());
        }
        this.purchasePrice = purchasePrice;
    }

    public int getLottoCount() {
        return purchasePrice / LOTTO_PRICE;
    }

    public int getTotalSpent() {
        return purchasePrice;
    }
}
