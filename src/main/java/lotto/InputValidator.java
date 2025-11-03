package lotto;

import java.util.HashSet;
import java.util.List;

public class InputValidator {
    // TODO: (Refactor) 에러 메세지 상수를 정의하는 위치에 대해
    public static final int LOTTO_MIN_NUMBER = 1;
    public static final int LOTTO_MAX_NUMBER = 45;

    public static final String ERROR_MESSAGE_NOT_INTEGER = "[ERROR] 값이 정수여야 합니다.";
    public static final String ERROR_MESSAGE_NOT_POSITIVE_NUMBER = "[ERROR] 값이 양수여야 합니다.";
    public static final String ERROR_MESSAGE_INVALID_PURCHASE_MONEY_UNIT = String.format("[ERROR] 구입 금액은 %d원 단위여야 합니다.",
            LottoManager.getLottoPrice());
    public static final String ERROR_MESSAGE_INVALID_LOTTO_COUNT = "[ERROR] 쉼표로 구분된 값은 6개여야 합니다.";
    public static final String ERROR_MESSAGE_DUPLICATE_NUMBER = "[ERROR] 값이 중복되지 않아야 합니다.";
    public static final String ERROR_MESSAGE_OUT_OF_RANGE = String.format("[ERROR] %d 이상 %d 이하인 값이어야 합니다.",
            LOTTO_MIN_NUMBER, LOTTO_MAX_NUMBER);

    public static void validatePurchaseMoney(String input) {
        int number;

        try {
            number = Parser.parsePurchaseMoney(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(ERROR_MESSAGE_NOT_INTEGER);
        }

        if (number <= 0) {
            throw new IllegalArgumentException(ERROR_MESSAGE_NOT_POSITIVE_NUMBER);
        }

        if (number % LottoManager.getLottoPrice() != 0) {
            throw new IllegalArgumentException(ERROR_MESSAGE_INVALID_PURCHASE_MONEY_UNIT);
        }
    }

    public static void validateWinningNumbers(String input) {
        List<Integer> numbers;

        try {
            numbers = Parser.parseWinningNumbers(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(ERROR_MESSAGE_NOT_INTEGER);
        }

        if (numbers.size() != 6) {
            throw new IllegalArgumentException(ERROR_MESSAGE_INVALID_LOTTO_COUNT);
        }

        if (numbers.size() != new HashSet<>(numbers).size()) {
            throw new IllegalArgumentException(ERROR_MESSAGE_DUPLICATE_NUMBER);
        }

        if (numbers.stream().anyMatch(n -> n < LOTTO_MIN_NUMBER || n > LOTTO_MAX_NUMBER)) {
            throw new IllegalArgumentException(ERROR_MESSAGE_OUT_OF_RANGE);
        }
    }
}
