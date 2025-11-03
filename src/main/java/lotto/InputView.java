package lotto;

import camp.nextstep.edu.missionutils.Console;

public class InputView {
    public int inputPurchaseMoney() {
        String input = Console.readLine();
        InputValidator.validatePurchaseMoney(input);
        return Parser.parsePurchaseMoney(input);
    }
}
