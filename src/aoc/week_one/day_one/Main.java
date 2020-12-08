package aoc.week_one.day_one;

import aoc.FileReader;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main implements FileReader<List<Integer>> {
    public static void main(String[] args) {
        List<Integer> input = new Main().readFile(new File("src/aoc/week_one/day_one/input.txt"));

        DayOne dayOne = new DayOne();

        System.out.println("1-1");
        System.out.println(dayOne.getSum(input, 2020, SumStrategies.SQUARE));
        System.out.println();

        System.out.println("1-2");
        System.out.println(dayOne.getSum(input, 2020, SumStrategies.CUBE));
        System.out.println();
    }

    @Override
    public List<Integer> readFile(File file) {
        List<Integer> output = new ArrayList<>();
        try {
            Scanner myReader = new Scanner(file);
            while (myReader.hasNextLine()) {
                output.add(Integer.valueOf(myReader.nextLine()));
            }
            myReader.close();
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }

        return output;
    }
}
