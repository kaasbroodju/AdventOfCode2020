package aoc.week_one.day_four;

public enum HeightUnits {
    METRIC(150, 193),
    IMPERIAL(59, 76);

    private final int min;
    private final int max;
    HeightUnits(int min, int max) {
        this.min = min;
        this.max = max;
    }

    public boolean isValid(int value) {
        return value >= min && value <= max;
    }
}
