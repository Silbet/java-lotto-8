package lotto;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;

public class LottoGameTest {

    @Test
    void 당첨번호와_일치하는_숫자들이_반환된다() {
        Lotto winningLotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        Lotto lotto = new Lotto(List.of(4, 5, 6, 7, 8, 9));

        LottoGame lottoGame = new LottoGame(winningLotto);

        List<Integer> numbers = lottoGame.matchNumber(lotto);
        assertThat(numbers).contains(4, 5, 6);
    }

    @Test
    void 당첨번호와_일치하지_않으면_빈리스트가_반환된다() {
        Lotto winningLotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        Lotto lotto = new Lotto(List.of(7, 8, 9, 10, 11, 12));

        LottoGame lottoGame = new LottoGame(winningLotto);

        List<Integer> numbers = lottoGame.matchNumber(lotto);
        assertThat(numbers).isEmpty();
    }
}
