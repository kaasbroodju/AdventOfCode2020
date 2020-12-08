package aoc.week_one.day_four;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

public class DayFour {
    public List<Passport> passportsWhoHaveAllTheRequiredFields(List<Passport> passports) {
        List<Passport> output = new ArrayList<>();
        for (Passport passport: passports) {
            if (passport.hasRequiredFields()) {
                output.add(passport);
            }
        }
        return output;
    }

    public List<Passport> validPassports(List<Passport> passports) {
        List<Passport> output = new ArrayList<>();

        for (Passport passport : passportsWhoHaveAllTheRequiredFields(passports)) {
            if (passport.getFields().keySet().stream().allMatch(s -> validate(s, passport.getFields().get(s)))) {
                output.add(passport);
            }
        }

        return output;
    }

    private boolean validate(String key, String value) {
        return switch (key) {
            case "byr" -> new BirthYearValidator().isValid(value);
            case "iyr" -> new IssueYearValidator().isValid(value);
            case "eyr" -> new ExpirationYearValidator().isValid(value);
            case "hgt" -> new HeightValidator().isValid(value);
            case "hcl" -> new HairColourValidator().isValid(value);
            case "ecl" -> new EyeColourValidator().isValid(value);
            case "pid" -> new PassportIdValidator().isValid(value);
            case "cid" -> true;
            default -> false;
        };
    }
}
