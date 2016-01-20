package hminhas.minesweeper;

/**
 * Created by Hassan on 09/10/2015.
 */
public enum squares {
    ZERO("0"), ONE("1"), TWO("2"), THREE("3"), FOUR("4"), FIVE("5"), SIX("6"), SEVEN("7"), EIGHT("8"), MINE("x");

    private final String value;

    private squares(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}