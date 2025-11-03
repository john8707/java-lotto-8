package lotto;

public class LottoController {
    private final InputView inputView;
    
    LottoController() {
        this.inputView = new InputView();
    }

    public void run() {
        String purchaseAmount = inputView.readPurchaseAmount();
    }
}
