package aoc.week_one.day_four;

public class IssueYearValidator implements PassportFieldValidationStrategy {
    private final int minYear = 2010;
    private final int maxYear = 2020;

    @Override
    public boolean isValid(String s) {
        int intValue = Integer.parseInt(s);
        return intValue >= minYear && intValue <= maxYear;
    }
}
