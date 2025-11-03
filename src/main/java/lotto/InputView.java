package lotto;

import camp.nextstep.edu.missionutils.Console;
import java.util.List;

public class InputView {
    public static int inputPurchaseMoney() {
        String input = Console.readLine();
        InputValidator.validatePurchaseMoney(input);
        return Parser.parsePurchaseMoney(input);
    }

    public static List<Integer> inputWinningNumbers() {
        String input = Console.readLine();
        InputValidator.validateWinningNumbers(input);
        return Parser.parseWinningNumbers(input);
    }

    public static int inputBonusNumbers(List<Integer> winningNumbers) {
        String input = Console.readLine();
        InputValidator.validateBonusNumbers(input, winningNumbers);
        return Parser.parseBonusNumber(input);
    }
}
