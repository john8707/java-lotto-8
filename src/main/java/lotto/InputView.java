package lotto;

import camp.nextstep.edu.missionutils.Console;

public class InputView {
    private String readInput(String message) {
        System.out.println(message);
        return Console.readLine();
    }
}
