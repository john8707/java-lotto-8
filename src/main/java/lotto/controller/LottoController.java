package lotto.controller;

import lotto.view.InputView;
import lotto.view.OutputView;

import java.util.List;

import lotto.domain.PurchaseAmount;
import lotto.domain.Lotto;
import lotto.service.LottoService;

public class LottoController {
    private final InputView inputView;
    private final OutputView outputView;
    private final LottoService lottoService;
    
    public LottoController() {
        this.inputView = new InputView();
        this.outputView = new OutputView();
        this.lottoService = new LottoService();
    }

    public void run() {
        PurchaseAmount purchaseAmount = getPurchaseAmount();
        outputView.printLottoCount(purchaseAmount.getLottoCount());

        List<Lotto> lottos = lottoService.generateLottoNumbers(purchaseAmount.getLottoCount());
        outputView.printLottoNumbers(lottos);
    }

    private PurchaseAmount getPurchaseAmount() {
        String input = inputView.readPurchaseAmount();
        int amount = Integer.parseInt(input);
        return new PurchaseAmount(amount);
    }
}
