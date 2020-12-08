package aoc.week_one.day_two;

public interface ValidationStrategy {
    boolean isValid(String[] strings);
    boolean validate(int min, int max, char target, char[] chars);
}
