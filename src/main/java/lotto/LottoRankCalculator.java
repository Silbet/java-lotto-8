package lotto;

import java.util.List;

public class LottoRankCalculator {

    public static LottoRank rank(List<Integer> matchingNumber) {
        int count = matchingNumber.size();
        return LottoRank.from(count);
    }
}
