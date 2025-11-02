package lotto;

import java.util.ArrayList;
import java.util.List;

public class LottoManager {
    private static final int LOTTO_PRICE = 1000;

    private int countPurchaseLottos(int money) {
        return money / LOTTO_PRICE;
    }

    List<Lotto> issueLottos(int count) {
        List<Lotto> Lottos = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            Lottos.add(LottoGenerator.generate());
        }
        return Lottos;
    }
}
