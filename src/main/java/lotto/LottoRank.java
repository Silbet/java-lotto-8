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

    public static LottoRank from(int count) {
        for (LottoRank rank : values()) {
            if (rank.count == count && !rank.bonus) {
                return rank;
            }
        }
        return FAILURE;
    }
}
