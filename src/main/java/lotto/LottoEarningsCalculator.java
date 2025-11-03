package lotto;

import java.util.Map;

public class LottoEarningsCalculator {
    static int calculatorTotal(Map<LottoRank, Integer> lottoResult) {
        int totalEarnings = 0;

        for (Map.Entry<LottoRank, Integer> entry : lottoResult.entrySet()) {
            LottoRank rank = entry.getKey();
            int count = entry.getValue();
            totalEarnings += rank.getPrize() * count;
        }
        return totalEarnings;
    }

    // TODO: (Refactor)분모가 0이 될 가능성을 없애기 위해 default 로 바꿨다. 다른 메소드들도 이 기준을 적용한 접근 제어자를 고민해보자.
    static double calculatorRate(int money, int totalEarnings) {
        return (double) totalEarnings / money * 100;
    }
}
