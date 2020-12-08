package aoc.week_one.day_five;

import java.util.Arrays;

public class Seat implements Comparable<Seat> {
    private final String code;
    private final int id;

    public Seat(String code) {
        this.code = code;
        this.id = calculateId(this.code);
    }

    private int calculateId(String code) {
        return calculatePosition(0, 127, code.substring(0, 7).toCharArray()) * 8 + calculatePosition(0, 7, code.substring(7, 10).toCharArray());
    }

    private int calculatePosition(int min, int max, char[] chars) {
        if (min == max) return min;
        char aChar = chars[0];
        if (aChar == 'F' || aChar == 'L') {
            if (chars.length == 1) return min;
            return calculatePosition(min, ((max+min)/2), Arrays.copyOfRange(chars, 1, chars.length));
        } else if (aChar == 'B' || aChar == 'R') {
            if (chars.length == 1) return max;
            return calculatePosition(((max+min)/2)+1, max, Arrays.copyOfRange(chars, 1, chars.length));
        } else {
            return -1;
        }
    }

    public String getCode() {
        return code;
    }

    public int getId() {
        return id;
    }

    @Override
    public int compareTo(Seat o) {
        if (this.id < o.getId()) {
            return -1;
        } else if (this.id > o.getId()) {
            return 1;
        } else {
            return 0;
        }
    }

    @Override
    public String toString() {
        return "Seat{" +
                "code='" + code + '\'' +
                ", id=" + id +
                '}';
    }
}
