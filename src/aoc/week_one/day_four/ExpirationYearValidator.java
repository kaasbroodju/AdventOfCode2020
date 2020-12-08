package aoc.week_one.day_four;

public class ExpirationYearValidator implements PassportFieldValidationStrategy{
    private final int minYear = 2020;
    private final int maxYear = 2030;

    @Override
    public boolean isValid(String s) {
        int intValue = Integer.parseInt(s);
        return intValue >= minYear && intValue <= maxYear;
    }
}
