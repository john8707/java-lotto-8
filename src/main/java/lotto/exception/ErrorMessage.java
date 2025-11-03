package lotto.exception;

public enum ErrorMessage {
    INVALID_LOTTO_NUMBER_COUNT("로또 번호는 6개여야 합니다."),
    DUPLICATE_LOTTO_NUMBERS("로또 번호에 중복된 숫자가 있습니다."),
    DUPLICATE_BONUS_NUMBERS("보너스 번호가 당첨 번호와 중복됩니다."),
    INVALID_LOTTO_NUMBER_RANGE("로또 번호는 1부터 45 사이의 숫자여야 합니다."),
    EMPTY_INPUT("입력이 비어있습니다."),
    INVALID_NUMBER_FORMAT("정수를 입력해야 합니다."),
    INVALID_PURCHASE_AMOUNT("구입 금액은 1000원의 배수인 양수여야 합니다.");

    private final String message;

    ErrorMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return "[ERROR] " + message;
    }
}
