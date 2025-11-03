package lotto;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.HashMap;
import java.util.Map;
import org.junit.jupiter.api.Test;

public class LottoEarningsCalculatorTest {
    @Test
    void 당첨된_로또의_당첨금에_의해_총_수익이_계산된다() {
        Map<LottoRank, Integer> lottoResult = new HashMap<>();
        lottoResult.put(LottoRank.FIRST, 1);
        lottoResult.put(LottoRank.SECOND, 1);
        lottoResult.put(LottoRank.THIRD, 1);

        int totalEarnings = LottoEarningsCalculator.calculatorTotal(lottoResult);
        int totalPrize = LottoRank.FIRST.getPrize() + LottoRank.SECOND.getPrize() + LottoRank.THIRD.getPrize();
        assertThat(totalEarnings).isEqualTo(totalPrize);
    }

    @Test
    void 로또_구입_금액과_총_수익으로_수익률이_계산된다() {
        int money = 10000;
        int earnings = 5000;
        double earningsRate = LottoEarningsCalculator.calculatorRate(money, earnings);

        assertThat(earningsRate).isEqualTo(50);
    }
}

