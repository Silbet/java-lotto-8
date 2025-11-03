package lotto;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.Test;

public class InputValidatorTest {
    @Test
    void 구입금액이_문자면_에러가_발생한다() {
        assertThatThrownBy(() -> InputValidator.validatePurchaseMoney("천원"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(InputValidator.ERROR_MESSAGE_INTEGER);
    }

    @Test
    void 구입금액이_실수면_에러가_발생한다() {
        assertThatThrownBy(() -> InputValidator.validatePurchaseMoney("1000.1"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(InputValidator.ERROR_MESSAGE_INTEGER);
    }

    @Test
    void 구입금액이_빈_입력이면_에러가_발생한다() {
        assertThatThrownBy(() -> InputValidator.validatePurchaseMoney(""))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(InputValidator.ERROR_MESSAGE_INTEGER);
    }

    @Test
    void 구입금액이_0이면_에러가_발생한다() {
        assertThatThrownBy(() -> InputValidator.validatePurchaseMoney("0"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(InputValidator.ERROR_MESSAGE_POSITIVE_NUMBER);
    }

    @Test
    void 구입금액이_음수면_에러가_발생한다() {
        assertThatThrownBy(() -> InputValidator.validatePurchaseMoney("-1000"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(InputValidator.ERROR_MESSAGE_POSITIVE_NUMBER);
    }

    @Test
    void 구입금액_단위가_지정된_단위와_다르면_에러가_발생한다() {
        int unit = LottoManager.getLottoPrice() + 1;
        String input = Integer.toString(unit);

        assertThatThrownBy(() -> InputValidator.validatePurchaseMoney(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(InputValidator.ERROR_MESSAGE_PURCHASE_MONEY_UNIT);
    }
}
