package lotto.view;

import java.util.List;

import lotto.domain.Lotto;

public class OutputView {
    private static final String OUTPUT_LOTTO_COUNT = "%d개를 구매했습니다.";
    public void printLottoCount(int count) {
        System.out.printf(OUTPUT_LOTTO_COUNT + "\n", count);
    }

    public void printLottoNumbers(List<Lotto> lottos) {
        for (Lotto lotto : lottos) {
            System.out.println(lotto.getNumbers());
        }
        System.out.println();
    }
}
