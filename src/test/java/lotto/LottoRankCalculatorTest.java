package lotto;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import org.junit.jupiter.api.Test;

public class LottoRankCalculatorTest {
    @Test
    void 당첨번호_6개가_일치하면_1등이다() {
        List<Integer> matchingNumber = List.of(1, 2, 3, 4, 5, 6);
        LottoRank lottorank = LottoRankCalculator.rank(matchingNumber, true);

        assertThat(lottorank).isEqualTo(LottoRank.FIRST);
    }

    @Test
    void 당첨번호_5개가_일치하고_보너스번호가_일치하면_2등이다() {
        List<Integer> matchingNumber = List.of(22, 23, 24, 25, 26);
        LottoRank lottorank = LottoRankCalculator.rank(matchingNumber, true);

        assertThat(lottorank).isEqualTo(LottoRank.SECOND);
    }

    @Test
    void 당첨번호_5개가_일치하고_보너스번호가_일치하지않으면_3등이다() {
        List<Integer> matchingNumber = List.of(7, 8, 9, 10, 11);
        LottoRank lottorank = LottoRankCalculator.rank(matchingNumber, false);

        assertThat(lottorank).isEqualTo(LottoRank.THIRD);
    }

    @Test
    void 당첨번호_4개가_일치하면_4등이다() {
        List<Integer> matchingNumber = List.of(12, 13, 14, 15);
        LottoRank lottorank = LottoRankCalculator.rank(matchingNumber, false);

        assertThat(lottorank).isEqualTo(LottoRank.FOURTH);
    }

    @Test
    void 당첨번호_3개가_일치하면_5등이다() {
        List<Integer> matchingNumber = List.of(16, 17, 18);
        LottoRank lottorank = LottoRankCalculator.rank(matchingNumber, false);

        assertThat(lottorank).isEqualTo(LottoRank.FIFTH);
    }

    @Test
    void 당첨번호_2개가_일치하면_꽝이다() {
        List<Integer> matchingNumber = List.of(19, 20);
        LottoRank lottorank = LottoRankCalculator.rank(matchingNumber, false);

        assertThat(lottorank).isEqualTo(LottoRank.FAILURE);
    }

    @Test
    void 당첨번호_1개가_일치하면_꽝이다() {
        List<Integer> matchingNumber = List.of(21);
        LottoRank lottorank = LottoRankCalculator.rank(matchingNumber, false);

        assertThat(lottorank).isEqualTo(LottoRank.FAILURE);
    }

    @Test
    void 당첨번호_0개가_일치하면_꽝이다() {
        List<Integer> matchingNumber = List.of();
        LottoRank lottorank = LottoRankCalculator.rank(matchingNumber, false);

        assertThat(lottorank).isEqualTo(LottoRank.FAILURE);
    }
}
