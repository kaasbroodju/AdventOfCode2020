package aoc.week_one.day_five;

import aoc.FileReader;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main implements FileReader<List<Seat>> {
    public static void main(String[] args) {
        List<Seat> input = new Main().readFile(new File("src/aoc/week_one/day_five/input.txt"));

        DayFive dayFive = new DayFive();

        System.out.println("5-1");
        System.out.println(dayFive.getHighestId(input));
        System.out.println();

        System.out.println("5-2");
        System.out.println(dayFive.getMySeat(input));
        System.out.println();
    }


    @Override
    public List<Seat> readFile(File file) {
        List<Seat> output = new ArrayList<>();

        try {
            Scanner myReader = new Scanner(file);
            while (myReader.hasNextLine()) {
                output.add(new Seat(myReader.nextLine()));
            }
            myReader.close();
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }

        return output;
    }
}
