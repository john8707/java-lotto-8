package lotto.validation;

import java.util.List;

import lotto.exception.ErrorMessage;

public class LottoValidator {
    private static final int LOTTO_NUMBER_COUNT = 6;
    private static final int MIN_LOTTO_NUMBER = 1;
    private static final int MAX_LOTTO_NUMBER = 45;

    private LottoValidator() {
    }

    public static void validateLottoNumbers(List<Integer> numbers) {
        if (numbers.size() != LOTTO_NUMBER_COUNT) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_LOTTO_NUMBER_COUNT.getMessage());
        }
        long distinctCount = numbers.stream().distinct().count();
        if (distinctCount != LOTTO_NUMBER_COUNT) {
            throw new IllegalArgumentException(ErrorMessage.DUPLICATE_LOTTO_NUMBERS.getMessage());
        }
        for (int number : numbers) {
            validateNumberInRange(number);
        }
    }

    public static void validateBonusNumber(int bonusNumber, List<Integer> winningNumbers) {
        validateNumberInRange(bonusNumber);
        if (winningNumbers.contains(bonusNumber)) {
            throw new IllegalArgumentException(ErrorMessage.DUPLICATE_BONUS_NUMBERS.getMessage());
        }
    }

    private static void validateNumberInRange(int number) {
        if (number < MIN_LOTTO_NUMBER || number > MAX_LOTTO_NUMBER) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_LOTTO_NUMBER_RANGE.getMessage());
        }
    }
}
