package aoc.week_one.day_four;

public class HeightValidator implements PassportFieldValidationStrategy{
    @Override
    public boolean isValid(String s) {
        if (s.endsWith("cm")) {
            return HeightUnits.METRIC.isValid(Integer.parseInt(s.substring(0, s.indexOf("cm"))));
        } else if (s.endsWith("in")) {
            return HeightUnits.IMPERIAL.isValid(Integer.parseInt(s.substring(0, s.indexOf("in"))));
        } else {
            return false;
        }
    }
}
