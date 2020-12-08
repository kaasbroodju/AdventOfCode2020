package aoc.week_one.day_three;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class DayThree {
    public Forest whichTreeHasToBeChopped(Forest forest, FlightRoute flightRoute) {
        int x = 0;
        int y = 0;

        while (y < forest.getTrees().size()-1) {
            x += flightRoute.getStepX();
            y += flightRoute.getStepY();
            if (x >= forest.getTrees().get(y).size()) x -= forest.getTrees().get(y).size();
            TypeOfTrees anEnum = forest.getTree(y, x);

            if (anEnum == TypeOfTrees.OPEN) {
                forest.setTree(y, x, TypeOfTrees.AVAILABLE);
            } else if (anEnum == TypeOfTrees.TREE) {
                forest.setTree(y, x, TypeOfTrees.NOT_AVAILABLE);
            }
        }
        
        return forest;
    }

    public Long howManyTreesToChop(Forest forest, FlightRoute flightRoute) {
        long output = 0;

        for (List<TypeOfTrees> rows : whichTreeHasToBeChopped(forest, flightRoute).getTrees()) {
            for (TypeOfTrees tree : rows) {
                if (tree == TypeOfTrees.NOT_AVAILABLE) output++;
            }
        }

        return output;
    }
}
