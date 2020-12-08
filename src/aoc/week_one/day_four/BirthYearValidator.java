package aoc.week_one.day_four;

public class BirthYearValidator implements PassportFieldValidationStrategy{
    private final int minYear = 1920;
    private final int maxYear = 2002;

    @Override
    public boolean isValid(String s) {
        int intValue = Integer.parseInt(s);
        return intValue >= minYear && intValue <= maxYear;
    }
}
