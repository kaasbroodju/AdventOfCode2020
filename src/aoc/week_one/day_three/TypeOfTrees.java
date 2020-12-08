package aoc.week_one.day_three;

public enum TypeOfTrees {
    OPEN('.'),
    TREE('#'),
    AVAILABLE('O'),
    NOT_AVAILABLE('X')
    ;

    private char symbol;

    TypeOfTrees(char c) {
        this.symbol = c;
    }

    public char getSymbol() {
        return symbol;
    }
}
