package lotto;

public class InputValidator {
    // TODO: (Refactor) 에러 메세지 상수를 정의하는 위치에 대해
    public static final String ERROR_MESSAGE_PURCHASE_MONEY_INTEGER = "[ERROR] 구입 금액은 정수여야 합니다.";
    public static final String ERROR_MESSAGE_PURCHASE_MONEY_POSITIVE_NUMBER = "[ERROR] 구입 금액은 양수여야 합니다.";
    public static final String ERROR_MESSAGE_PURCHASE_MONEY_UNIT = String.format("[ERROR] 구입 금액은 %d원 단위여야 합니다.",
            LottoManager.getLottoPrice());

    public static void validatePurchaseMoney(String input) {
        int number;

        try {
            number = Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(ERROR_MESSAGE_PURCHASE_MONEY_INTEGER);
        }

        if (number <= 0) {
            throw new IllegalArgumentException(ERROR_MESSAGE_PURCHASE_MONEY_POSITIVE_NUMBER);
        }

        if (number % LottoManager.getLottoPrice() != 0) {
            throw new IllegalArgumentException(ERROR_MESSAGE_PURCHASE_MONEY_UNIT);
        }
    }
}
