package aoc.week_one.day_four;

public class PassportIdValidator implements PassportFieldValidationStrategy {
    private final char[] valids = new char[]{'0','1','2','3','4','5','6','7','8','9'};
    private final int exactLength = 9;

    @Override
    public boolean isValid(String s) {
        if (s.length() == exactLength) {
            return s.chars().allMatch(value1 -> new String(valids).chars().anyMatch(value2 -> value1 == value2));
        } else {
            return false;
        }
    }
}
