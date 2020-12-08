package aoc.week_one.day_seven;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class Bag {
    private String name;
    private Map<Bag, Integer> canFit = new HashMap<>();

    public Bag(String name) {
        this.name = name;
    }

    public Bag setCanFit(Map<Bag, Integer> canFit) {
        this.canFit = canFit;
        return this;
    }

    public String getName() {
        return name;
    }

    public Map<Bag, Integer> getCanFit() {
        return canFit;
    }

    public Long getSize() {
        long output = 0l;
        for (Bag key : canFit.keySet()) {
            output += canFit.get(key);
            output += key.getSize() * canFit.get(key);
        }
        return output;
    }

    public boolean canFit(Bag o) {
        if (canFit.isEmpty()) return false;
        if (canFit.containsKey(o)) return true;
        return this.canFit.keySet().stream().anyMatch(bag -> bag.canFit(o));
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Bag bag = (Bag) o;
        return Objects.equals(name, bag.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }

    @Override
    public String toString() {
        String output = "";
        if (!canFit.isEmpty()) {
            for (Bag bag : canFit.keySet()) {
                output += canFit.get(bag) + " " + bag.getName() + ", ";
            }
            output = output.substring(0, output.length()-2);
            output += ".";
        } else {
            output = "no bags";
        }

        return name + " bag with " + output + " and can fit " + getSize() + " bags";
    }
}
