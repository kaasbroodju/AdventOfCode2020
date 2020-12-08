package aoc.week_one.day_two;

import java.util.List;

public class DayTwo {
    public boolean validate(String s, ValidationStrategies strategy) {
        return strategy.getStrategy().isValid(
                s.split(" ")
        );
    }
}
