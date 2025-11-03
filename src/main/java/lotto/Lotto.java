package lotto;

import static lotto.InputValidator.ERROR_MESSAGE_DUPLICATE_NUMBER;
import static lotto.InputValidator.ERROR_MESSAGE_INVALID_LOTTO_COUNT;
import static lotto.InputValidator.ERROR_MESSAGE_OUT_OF_RANGE;
import static lotto.InputValidator.LOTTO_MAX_NUMBER;
import static lotto.InputValidator.LOTTO_MIN_NUMBER;

import java.util.HashSet;
import java.util.List;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    public List<Integer> getNumbers() {
        return this.numbers;
    }

    private void validate(List<Integer> numbers) {
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
