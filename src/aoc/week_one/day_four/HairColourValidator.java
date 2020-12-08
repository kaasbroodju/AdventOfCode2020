package aoc.week_one.day_four;

public class HairColourValidator implements PassportFieldValidationStrategy {
    private final char[] valids = new char[]{'0','1','2','3','4','5','6','7','8','9','a','b','c','d','e','f'};
    private final int exactLength = 7;
    private final String startIdentifier = "#";

    @Override
    public boolean isValid(String s) {
        if (s.startsWith(startIdentifier) && s.length() == exactLength) {
            return s.substring(startIdentifier.length()).chars().allMatch(value1 -> new String(valids).chars().anyMatch(value2 -> value1 == value2));
        } else {
            return false;
        }
    }
}
