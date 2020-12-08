package aoc.week_one.day_one;

import java.util.List;

public class CubeSumStrategy implements SumStrategy {
    @Override
    public int sum(List<Integer> list, int target) {
        for (Integer i : list) {
            for (Integer j : list) {
                for (Integer k : list) {
                    if (i + j + k== target) return i * j * k;

                }
            }
        }
        return 0;
    }
}
