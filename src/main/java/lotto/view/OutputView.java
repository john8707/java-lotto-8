package lotto.view;

public class OutputView {
    private static final String OUTPUT_LOTTO_COUNT = "%d개를 구매했습니다.";
    public void printLottoCount(int count) {
        System.out.printf(OUTPUT_LOTTO_COUNT + "\n", count);
    }
}
