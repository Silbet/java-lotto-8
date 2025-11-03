package lotto;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Supplier;

public class LottoManager {
    private static final int LOTTO_PRICE = 1000;

    public static int getLottoPrice() {
        return LOTTO_PRICE;
    }

    public void run() {
        // 로또 구매하기
        List<Lotto> lottos = purchaseLotto();

        // 당첨번호, 보너스번호 입력받아 로또게임 생성하기
        LottoGame lottogame = createLottoGame();

        // 로또 게임 진행하기
        Map<LottoRank, Integer> lottoResult = palyLottoGame(lottogame, lottos);

        // 당첨 내역 출력
        OutputView.printWinningResult(lottoResult);

        // 수익률 계산
        double earnings = calculateEarnings(lottoResult);

        // 수익률 출력
        OutputView.printEarningsRate(earnings);
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

    private List<Lotto> purchaseLotto() {
        OutputView.printPurchaseMoneyRequest();

        int money = retryUntilValid(InputView::inputPurchaseMoney);

        int count = countPurchaseLottos(money);
        OutputView.printCheckPurchaseLottoCount(count);

        List<Lotto> Lottos = issueLottos(count);
        OutputView.printLottoNumbers(Lottos);

        return Lottos;
    }

    private LottoGame createLottoGame() {
        OutputView.printWinningNumberRequest();
        Lotto winningLotto = retryUntilValid(() -> new Lotto(InputView.inputWinningNumbers()));

        OutputView.printBonusNumberRequest();
        int bonusNumber = retryUntilValid(() -> InputView.inputBonusNumbers(winningLotto.getNumbers()));

        return new LottoGame(winningLotto, bonusNumber);
    }

    private Map<LottoRank, Integer> palyLottoGame(LottoGame lottogame, List<Lotto> lottos) {
        Map<LottoRank, Integer> matchingResult = new HashMap<>();
        for (LottoRank rank : LottoRank.values()) {
            matchingResult.put(rank, 0);
        }

        for (Lotto lotto : lottos) {
            List<Integer> matchingNumber = lottogame.matchNumber(lotto);
            boolean matchingBonusNumber = lottogame.matchBonusNumber(lotto);
            LottoRank rank = LottoRankCalculator.rank(matchingNumber, matchingBonusNumber);

            matchingResult.put(rank, matchingResult.get(rank) + 1);
        }
        return matchingResult;
    }

    private double calculateEarnings(Map<LottoRank, Integer> lottoResult) {
        int totalLottoCount = 0;
        for (Integer count : lottoResult.values()) {
            totalLottoCount += count;
        }
        int totalMoney = totalLottoCount * LOTTO_PRICE;

        int earnings = LottoEarningsCalculator.calculatorTotal(lottoResult);
        return LottoEarningsCalculator.calculatorRate(totalMoney, earnings);
    }

    // 예외 발생 시 프로그램을 종료하지 않고 계속 입력을 받게 하는 인터페이스
    private <T> T retryUntilValid(Supplier<T> inputSupplier) {
        while (true) {
            try {
                return inputSupplier.get();
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }
}
