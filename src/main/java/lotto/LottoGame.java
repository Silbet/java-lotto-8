package lotto;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class LottoGame {
    private final Lotto winningLotto;
    private final int bonusNumber;

    public LottoGame(Lotto lotto, int bonusNumber) {
        this.winningLotto = lotto;
        this.bonusNumber = bonusNumber;
    }

    List<Integer> matchNumber(Lotto lotto) {
        Set<Integer> lottoNumber = new HashSet<>(lotto.getNumbers());
        Set<Integer> winningNumber = new HashSet<>(winningLotto.getNumbers());
        lottoNumber.retainAll(winningNumber);
        return new ArrayList<>(lottoNumber);
    }

    boolean matchBonusNumber(Lotto lotto) {
        List<Integer> numbers = lotto.getNumbers();
        return numbers.contains(bonusNumber);
    }
}
