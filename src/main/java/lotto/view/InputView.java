package lotto.view;

import camp.nextstep.edu.missionutils.Console;

public class InputView {
    private static final String INPUT_PURCHASE_AMOUNT = "구입금액을 입력해 주세요.";

    private String readInput(String message) {
        System.out.println(message);
        return Console.readLine();
    }

    public String readPurchaseAmount() {
        String input = readInput(INPUT_PURCHASE_AMOUNT);
        System.out.println();
        return input;
    }
}
