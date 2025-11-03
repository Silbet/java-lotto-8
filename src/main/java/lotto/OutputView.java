package lotto;

import java.util.List;

public class OutputView {
    public static void printPurchaseMoneyRequest() {
        System.out.println("구입금액을 입력해 주세요.");
    }

    public static void printCheckPurchaseLottoCount(int count) {
        System.out.println(String.format("\n%d개를 구매했습니다.", count));
    }

    public static void printLottoNumbers(List<Lotto> Lottos) {
        for (Lotto lotto : Lottos) {
            System.out.println(lotto.getNumbers());
        }
    }
}
