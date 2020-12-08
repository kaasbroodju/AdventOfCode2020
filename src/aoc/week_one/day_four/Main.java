package aoc.week_one.day_four;

import aoc.FileReader;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class Main implements FileReader<List<Passport>> {
    public static void main(String[] args) {
        List<Passport> input = new Main().readFile(new File("src/aoc/week_one/day_four/input.txt"));

        DayFour dayFour = new DayFour();

        System.out.println("4-1");
        System.out.println(dayFour.passportsWhoHaveAllTheRequiredFields(input).size());
        System.out.println();

        System.out.println("4-2");
        System.out.println(dayFour.validPassports(input).size());
        System.out.println();
    }

    @Override
    public List<Passport> readFile(File file) {
        List<Passport> output = new ArrayList<>();
        try {
            Scanner myReader = new Scanner(file);
            Passport passport = new Passport();
            while (myReader.hasNextLine()) {
                String s = myReader.nextLine();
                if (s.equals("")) {
                    output.add(passport);
                    passport = new Passport();
                } else {
                    for (String keyPair : s.split(" ")) {
                        String key = keyPair.split(":")[0];
                        String value = keyPair.split(":")[1];
                        passport.addField(key, value);
                    }
                }
            }
            myReader.close();
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
        return output;
    }
}
