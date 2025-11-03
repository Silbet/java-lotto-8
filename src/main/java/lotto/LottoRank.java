package lotto;

public enum LottoRank {
    FIRST(6, 2000000000, false),
    SECOND(5, 30000000, true),
    THIRD(5, 1500000, false),
    FOURTH(4, 50000, false),
    FIFTH(3, 5000, false),
    FAILURE(0, 0, false);

    private final int count;
    private final int prize;
    private final boolean bonus;


    LottoRank(int count, int prize, boolean bonus) {
        this.count = count;
        this.prize = prize;
        this.bonus = bonus;
    }

    public static LottoRank from(int count, boolean bonus) {
        if (count == SECOND.count && bonus == SECOND.bonus) {
            return SECOND;
        }

        for (LottoRank rank : values()) {
            if (count == rank.count && !rank.bonus) {
                return rank;
            }
        }
        return FAILURE;
    }

    public int getPrize() {
        return this.prize;
    }

    public String getResultText(int count) {

        if (this == SECOND) {
            return String.format("%d개 일치, 보너스 볼 일치 (%s원) - %d개", this.count, formatPrize(this.prize), count);
        }

        if (this == FAILURE) {
            return "";
        }

        // 1등, 3등, 4등, 5등인 경우
        return String.format("%d개 일치 (%s원) - %d개", this.count, formatPrize(this.prize), count);
    }

    private String formatPrize(int prize) {
        return String.format("%,d", prize);
    }
}
