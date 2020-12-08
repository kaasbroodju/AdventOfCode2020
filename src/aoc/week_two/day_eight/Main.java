package aoc.week_two.day_eight;

import aoc.FileReader;
import aoc.week_one.day_two.ValidationStrategies;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main implements FileReader<BootSequence> {
    public static void main(String[] args) {
        BootSequence bootSequence = new Main().readFile(new File("src/aoc/week_two/day_eight/input.txt"));

        DayEight dayEight = new DayEight();

        System.out.println("8-1");
        System.out.println(dayEight.accumulatorLoopValue(bootSequence));
        System.out.println();

        System.out.println("8-2");
        System.out.println(dayEight.getLoopIndex(bootSequence));
        System.out.println();
    }

    @Override
    public BootSequence readFile(File file) {
        BootSequence output = new BootSequence();
        try {
            Scanner myReader = new Scanner(file);
            while (myReader.hasNextLine()) {
                String[] s = myReader.nextLine().split(" ");
                int value = Integer.valueOf(s[1]);
                System.out.println(s[0] + " " + value);
                switch (s[0]) {
                    case "jmp": {
                        output.addInstruction(new JumpInstruction(value));
                        break;
                    }
                    case "acc": {
                        output.addInstruction(new AccumulatorInstruction(value));
                        break;
                    }
                    case "nop": {
                        output.addInstruction(new NoOperationInstruction(value));
                        break;
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
