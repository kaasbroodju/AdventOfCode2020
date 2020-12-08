package aoc.week_one.day_two;

public class ExactIndexValidationStrategy implements ValidationStrategy{
    @Override
    public boolean isValid(String[] strings) {
        int min = Integer.valueOf(strings[0].split("-")[0]);
        int max = Integer.valueOf(strings[0].split("-")[1]);

        return validate(
                1,
                1,
                strings[1].charAt(0),
                new char[]{
                        strings[2].charAt(min-1),
                        strings[2].charAt(max-1)
                }
        );
    }

    @Override
    public boolean validate(int min, int max, char target, char[] chars) {
        return new MinMaxValidationStrategy().validate(min, max, target, chars);
    }
}
