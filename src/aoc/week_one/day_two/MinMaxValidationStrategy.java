package aoc.week_one.day_two;

public class MinMaxValidationStrategy implements ValidationStrategy {
    @Override
    public boolean isValid(String[] strings) {
        return validate(
                Integer.valueOf(strings[0].split("-")[0]),
                Integer.valueOf(strings[0].split("-")[1]),
                strings[1].charAt(0),
                strings[2].toCharArray()
        );
    }

    @Override
    public boolean validate(int min, int max, char target, char[] chars) {
        int amount = 0;
        for (char c : chars) {
            if (c == target) amount += 1;
        }
        return amount >= min && amount <= max;
    }
}
