package lotto;

import java.util.ArrayList;
import java.util.List;

public class LottoManager {
    private static final int LOTTO_PRICE = 1000;

    public static int getLottoPrice() {
        return LOTTO_PRICE;
    }

    public void run() {
        // 금액 입력 받기 : InputView -> int money
        // 로또 구매하기(금액+발행) : purchaseLottos()만들기. (countPuchasLottos, issueLottos)
        // 구매 로또 출력하기 : OutputView
        // 번호들 입력받아 로또게임 생성하기. : InputView -> LottoGame()
        // 로또 결과 확인하기. : List<LottoRank> checkLottoResult()만들기. (반복문으로 matchNumber, matchBonusNumber, rank)
        // 당첨 내역 출력 : OutputView
        // 수익률 계산 : calculateEarnings()만들기.
        // 수익률 출력 : OutputView
    }

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
