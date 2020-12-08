package aoc.week_one.day_seven;

import java.util.*;
import java.util.stream.Collectors;

public class DaySeven {
    public Set<Bag> canDirectlyFitIn(List<Bag> bags, Bag target) {
        return bags.stream().filter(bag -> bag.canFit(target)).collect(Collectors.toSet());
    }

//    public List<Bag> canFitIn(List<Bag> bags, Bag bag) {
//        return bags.stream().filter(otherBag -> otherBag.getSize() >= bag.getSize()).collect(Collectors.toList());
//    }

    public Long test(Bag o) {
        long i = 0;
        for (Bag bag : o.getCanFit().keySet()) {
            System.out.println(bag);
            i += bag.getSize();
        }
        return i;
    }
}
