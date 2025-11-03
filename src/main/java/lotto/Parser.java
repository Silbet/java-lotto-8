package lotto;

import java.util.ArrayList;
import java.util.List;

public class Parser {
    public static int parsePurchaseMoney(String input) {
        return Integer.parseInt(input);
    }

    public static List<Integer> parseWinningNumbers(String input) {
        String[] splitInput = input.split(",");
        List<Integer> numbers = new ArrayList<>();

        for (String number : splitInput) {
            numbers.add(Integer.parseInt(number));
        }

        return numbers;
    }

    public static int parseBonusNumber(String input) {
        return Integer.parseInt(input);
    }
}
