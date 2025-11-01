package lotto;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class LottoGame {
    private final Lotto winningLotto;

    public LottoGame(Lotto lotto) {
        this.winningLotto = lotto;
    }

    List<Integer> matchNumber(Lotto lotto) {
        Set<Integer> lottoNumber = new HashSet<>(lotto.getNumbers());
        Set<Integer> winningNumber = new HashSet<>(winningLotto.getNumbers());
        lottoNumber.retainAll(winningNumber);
        return new ArrayList<>(lottoNumber);
    }
}
