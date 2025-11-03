package lotto;

import java.util.List;
import java.util.Map;

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

    public static void printWinningNumberRequest() {
        System.out.println("\n당첨 번호를 입력해 주세요.");
    }


    public static void printBonusNumberRequest() {
        System.out.println("\n보너스 번호를 입력해 주세요.");
    }

    public static void printWinningResult(Map<LottoRank, Integer> winningResult) {
        System.out.println();
        System.out.println("당첨 통계");
        System.out.println("---");

        LottoRank[] ranks = LottoRank.values();
        for (int i = ranks.length - 1; i >= 0; i--) {
            LottoRank rank = ranks[i];
            if (rank == LottoRank.FAILURE) {
                continue;
            }
            int count = winningResult.getOrDefault(rank, 0);
            System.out.println(rank.getResultText(count));
        }
    }
}
