package lotto.view;

import camp.nextstep.edu.missionutils.Console;

public class InputView {
    private static final String INPUT_PURCHASE_PRICE = "구입금액을 입력해 주세요.";
    private static final String INPUT_WINNING_NUMBERS = "당첨 번호를 입력해 주세요.";
    private static final String INPUT_BONUS_NUMBER = "보너스 번호를 입력해 주세요.";

    private String readInput(String message) {
        System.out.println(message);
        return Console.readLine();
    }

    public String readPurchasePrice() {
        String input = readInput(INPUT_PURCHASE_PRICE);
        System.out.println();
        return input;
    }

    public String readWinningNumbers() {
        String input = readInput(INPUT_WINNING_NUMBERS);
        System.out.println();
        return input;
    }

    public String readBonusNumber() {
        String input = readInput(INPUT_BONUS_NUMBER);
        System.out.println();
        return input;
    }
}
