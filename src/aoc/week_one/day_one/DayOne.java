package aoc.week_one.day_one;

import java.util.List;

public class DayOne {
    public Integer getSum(List<Integer> list, int target, SumStrategies strategy) {
        return strategy.getStrategy().sum(list, target);
    }
}
