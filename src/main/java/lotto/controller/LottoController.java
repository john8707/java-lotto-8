package lotto.controller;

import lotto.view.InputView;
import lotto.view.OutputView;
import lotto.domain.PurchaseAmount;

public class LottoController {
    private final InputView inputView;
    private final OutputView outputView;
    
    public LottoController() {
        this.inputView = new InputView();
        this.outputView = new OutputView();
    }

    public void run() {
        PurchaseAmount purchaseAmount = getPurchaseAmount();
        outputView.printLottoCount(purchaseAmount.getLottoCount());
    }

    private PurchaseAmount getPurchaseAmount() {
        String input = inputView.readPurchaseAmount();
        int amount = Integer.parseInt(input);
        return new PurchaseAmount(amount);
    }
}
