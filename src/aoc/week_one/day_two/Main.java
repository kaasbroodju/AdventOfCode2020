package aoc.week_one.day_two;

import aoc.FileReader;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main implements FileReader<List<String>> {
    public static void main(String[] args) {
        List<String> input = new Main().readFile(new File("src/aoc/week_one/day_two/input.txt"));

        DayTwo dayTwo = new DayTwo();

        System.out.println("2-1");
        int i = 0;
        for (String s : input) {
            if (dayTwo.validate(s, ValidationStrategies.MIN_MAX)) i++;
        }
        System.out.println(i);
        System.out.println();

        System.out.println("2-2");
        int j = 0;
        for (String s : input) {
            if (dayTwo.validate(s, ValidationStrategies.INDEX)) j++;
        }
        System.out.println(j);
        System.out.println();
    }

    @Override
    public List<String> readFile(File file) {
        List<String> output = new ArrayList<>();
        try {
            Scanner myReader = new Scanner(file);
            while (myReader.hasNextLine()) {
                output.add(myReader.nextLine());
            }
            myReader.close();
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }

        return output;
    }
}
