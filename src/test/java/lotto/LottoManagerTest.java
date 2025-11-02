package lotto;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import org.junit.jupiter.api.Test;

public class LottoManagerTest {
    @Test
    void 입력_개수만큼_로또가_발행된다() {
        LottoManager lottoManager = new LottoManager();
        List<Lotto> lottos = lottoManager.issueLottos(10);
        assertThat(lottos.size()).isEqualTo(10);
    }
}
