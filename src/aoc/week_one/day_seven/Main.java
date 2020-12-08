package aoc.week_one.day_seven;

import aoc.FileReader;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class Main implements FileReader<List<Bag>> {
    public static void main(String[] args) {
        List<Bag> bags = new Main().readFile(new File("src/aoc/week_one/day_seven/input.txt"));

        Bag targetOne = null;
        Bag targetTwo = null;
        for (Bag bag : bags) {
            if (bag.getName().equals("shiny gold")) {
                targetOne = bag;
            }
            if (bag.getName().equals("huts pot")) {
                targetTwo = bag;
            }
        }

        DaySeven daySeven = new DaySeven();

        System.out.println("7-1");
        System.out.println(daySeven.canDirectlyFitIn(bags, targetOne).size());
        System.out.println();

//        System.out.println(daySeven.test(targetTwo));

        System.out.println("7-2");
        System.out.println(targetOne.getSize());
        System.out.println();
    }

    @Override
    public List<Bag> readFile(File file) {
        List<Bag> bags = new ArrayList<>();
        Map<Bag, Map<String, Integer>> input = new HashMap<>();
        try {
            Scanner myReader = new Scanner(file);
            while (myReader.hasNextLine()) {
                String[] s = myReader.nextLine().split(" bags contain ");
                Map<String, Integer> innerMap = new HashMap<>();
                Bag bag = new Bag(s[0]);
                if (!s[1].startsWith("no")) {
                    String[] temp = s[1].split(", ");
                    for (String s1 : temp) {
                        String[] s2 = s1.substring(0, s1.indexOf(" bag")).split(" ");
                        String name = "";
                        for (int i = 1; i < s2.length; i++) {
                            name += s2[i] + " ";
                        }
                        innerMap.put(name.stripTrailing(), Integer.valueOf(s2[0]));
                    }
                }
                input.put(bag, innerMap);
            }
            myReader.close();
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }

        for (Bag bag : input.keySet()) {
            Map<Bag, Integer> innerMap = new HashMap<>();
            for (String s : input.get(bag).keySet()) {
                for (Bag innerBag : input.keySet()) {
                    if (innerBag.getName().equals(s)) {
                        innerMap.put(innerBag, input.get(bag).get(s));
                        break;
                    }
                }
            }
            bag.setCanFit(innerMap);
            bags.add(bag);
        }

        return bags;
    }
}
