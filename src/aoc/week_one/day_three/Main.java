package aoc.week_one.day_three;

import aoc.FileReader;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main implements FileReader<Forest> {
    public static void main(String[] args) {
        Forest input = new Main().readFile(new File("src/aoc/week_one/day_three/input.txt"));

        DayThree dayThree = new DayThree();

        System.out.println("3-1");
        System.out.println(dayThree.howManyTreesToChop(input.clone(), new FlightRoute(3, 1)));
        System.out.println();

        System.out.println("3-2");
        System.out.println(
                dayThree.howManyTreesToChop(input.clone(), new FlightRoute(1, 1)) *
                dayThree.howManyTreesToChop(input.clone(), new FlightRoute(3, 1)) *
                dayThree.howManyTreesToChop(input.clone(), new FlightRoute(5, 1)) *
                dayThree.howManyTreesToChop(input.clone(), new FlightRoute(7, 1)) *
                dayThree.howManyTreesToChop(input.clone(), new FlightRoute(1, 2))
        );
        System.out.println();
    }

    @Override
    public Forest readFile(File file) {
        Forest output = new Forest();
        try {
            Scanner myReader = new Scanner(file);
            while (myReader.hasNextLine()) {
                List<TypeOfTrees> innerList = new ArrayList<>();
                for (char c : myReader.nextLine().toCharArray()) {
                    for (TypeOfTrees typeOfTrees : TypeOfTrees.values()) {
                        if (typeOfTrees.getSymbol() == c) {
                            innerList.add(typeOfTrees);
                            break;
                        }
                    }
                }
                output.addRowOfTrees(innerList);
            }
            myReader.close();
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }

        return output;
    }
}
