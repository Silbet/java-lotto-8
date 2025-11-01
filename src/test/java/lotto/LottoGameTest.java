package lotto;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import org.junit.jupiter.api.Test;

public class LottoGameTest {
    Lotto winningLotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
    LottoGame lottoGame = new LottoGame(winningLotto, 7);

    @Test
    void 로또와_당첨번호의_교집합을_반환한다() {
        Lotto lotto = new Lotto(List.of(4, 5, 6, 7, 8, 9));

        List<Integer> numbers = lottoGame.matchNumber(lotto);
        assertThat(numbers).contains(4, 5, 6);
    }

    @Test
    void 로또와_당첨번호가_공집합이면_빈리스트를_반환한다() {
        Lotto lotto = new Lotto(List.of(7, 8, 9, 10, 11, 12));

        List<Integer> numbers = lottoGame.matchNumber(lotto);
        assertThat(numbers).isEmpty();
    }

    @Test
    void 로또에_보너스숫자가_있으면_참을_반환한다() {
        Lotto lotto = new Lotto(List.of(4, 5, 6, 7, 8, 9));

        boolean bonus = lottoGame.matchBonusNumber(lotto);
        assertThat(bonus).isTrue();
    }
}
