package aoc.week_one.day_six;

import aoc.FileReader;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main implements FileReader<List<Group>> {
    public static void main(String[] args) {
        List<Group> input = new Main().readFile(new File("src/aoc/week_one/day_six/input.txt"));

        int i = 0;
        for (Group group : input) {
            i += group.getSum();
        }

        System.out.println("6-1");
        System.out.println(i);
        System.out.println();


        int j = 0;
        for (Group group : input) {
            j += group.getEveryoneAnswered().size();
        }

        System.out.println("6-2");
        System.out.println(j);
        System.out.println();
    }

    @Override
    public List<Group> readFile(File file) {
        List<Group> output = new ArrayList<>();
        try {
            Scanner myReader = new Scanner(file);
            Group group = new Group();
            while (myReader.hasNextLine()) {
                String s = myReader.nextLine();
                if (s.equals("")) {
                    output.add(group);
                    group = new Group();
                } else {
                    Person person = new Person();
                    for (char c : s.toCharArray()) {
                        person.answer(c);
                    }
                    group.addGroupMember(person);
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
