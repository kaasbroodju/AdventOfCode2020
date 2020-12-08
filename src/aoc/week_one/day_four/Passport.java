package aoc.week_one.day_four;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Passport {
    private final String[] requiredFields = new String[]{"byr", "iyr", "eyr", "hgt", "hcl", "ecl", "pid"};
    Map<String, String> fields = new HashMap<>();

    public String addField(String key, String value) {
        return fields.put(key, value);
    }

    public boolean hasRequiredFields() {
        return fields.keySet().containsAll(Arrays.asList(requiredFields.clone()));
    }

    public Map<String, String> getFields() {
        return fields;
    }
}
