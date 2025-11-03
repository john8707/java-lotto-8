package lotto.domain;

import java.util.Collections;
import java.util.List;

import lotto.validation.LottoValidator;

public class WinningLotto {
    private final List<Integer> numbers;
    private final int bonusNumber;

    public WinningLotto(List<Integer> numbers, int bonusNumber) {
        LottoValidator.validateLottoNumbers(numbers);
        LottoValidator.validateBonusNumber(bonusNumber, numbers);
        this.numbers = numbers;
        this.bonusNumber = bonusNumber;
    }

    public List<Integer> getNumbers() {
        return Collections.unmodifiableList(numbers);
    }

    public int getBonusNumber() {
        return bonusNumber;
    }
}
