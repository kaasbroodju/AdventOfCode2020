package aoc.week_one.day_four;

import java.util.Arrays;

public class EyeColourValidator implements PassportFieldValidationStrategy {
    private final String[] valids = new String[]{"amb", "blu", "brn", "gry", "grn", "hzl", "oth"};

    @Override
    public boolean isValid(String value) {
        return Arrays.stream(valids).anyMatch(s -> value.equals(s));
    }
}
