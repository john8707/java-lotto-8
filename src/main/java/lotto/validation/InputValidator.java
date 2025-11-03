package lotto.validation;

import lotto.exception.ErrorMessage;

public class InputValidator {
    private static final String LOTTO_DELIMITER = ",";
    private InputValidator() {
    }

    public static void validatePurchasePrice(String input) {
        validateEmptyInput(input);
        validateNumericInput(input);
    }

    public static void validateWinningNumbers(String input) {
        validateEmptyInput(input);
        String[] numbers = input.split(LOTTO_DELIMITER);
        for (String number : numbers) {
            validateNumericInput(number.trim());
            validateEmptyInput(number.trim());
        }
    }

    public static void validateBonusNumber(String input) {
        validateEmptyInput(input);
        validateNumericInput(input);
    }

    public static void validateEmptyInput(String input) {
        if (input == null || input.trim().isEmpty()) {
            throw new IllegalArgumentException(ErrorMessage.EMPTY_INPUT.getMessage());
        }
    }

    public static void validateNumericInput(String input) {
        try {
            Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_NUMBER_FORMAT.getMessage());
        }
    }
}
