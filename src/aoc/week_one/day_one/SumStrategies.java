package aoc.week_one.day_one;

public enum SumStrategies {
    SQUARE(new SquareSumStrategy()),
    CUBE(new CubeSumStrategy());

    private SumStrategy strategy;
    SumStrategies(SumStrategy strategy) {
        this.strategy = strategy;
    }

    public SumStrategy getStrategy() {
        return strategy;
    }
}
