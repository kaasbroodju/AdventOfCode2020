package aoc.week_one.day_two;

public enum ValidationStrategies {
    MIN_MAX(new MinMaxValidationStrategy()),
    INDEX(new ExactIndexValidationStrategy());

    private ValidationStrategy strategy;

    ValidationStrategies(ValidationStrategy strategy) {
        this.strategy = strategy;
    }

    public ValidationStrategy getStrategy() {
        return strategy;
    }
}
