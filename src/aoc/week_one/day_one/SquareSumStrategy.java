package aoc.week_one.day_one;

import java.util.List;

public class SquareSumStrategy implements SumStrategy {
    @Override
    public int sum(List<Integer> list, int target) {
        for (Integer i : list) {
            for (Integer j : list) {
                if (i + j == target) return i * j;
            }
        }
        return 0;
    }
}
