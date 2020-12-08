package aoc.week_one.day_three;

import java.util.ArrayList;
import java.util.List;

public class Forest implements Cloneable {
    private List<List<TypeOfTrees>> trees = new ArrayList<>();

    public boolean addRowOfTrees(List<TypeOfTrees> trees) {
        return this.trees.add(trees);
    }

    public TypeOfTrees getTree(int y, int x) {
        return trees.get(y).get(x);
    }

    public TypeOfTrees setTree(int y, int x, TypeOfTrees value) {
        return trees.get(y).set(x, value);
    }

    public List<List<TypeOfTrees>> getTrees() {
        return trees;
    }

    @Override
    public Forest clone() {
        Forest result = new Forest();
        for (List<TypeOfTrees> row : this.trees) {
            List<TypeOfTrees> innerResultList = new ArrayList<>();
            for (TypeOfTrees tree : row) {
                innerResultList.add(TypeOfTrees.valueOf(tree.toString()));
            }
            result.addRowOfTrees(innerResultList);
        }
        return result;
    }

    @Override
    public String toString() {
        String output = "";
        for (List<TypeOfTrees> rowOfTrees : trees) {
            for (TypeOfTrees tree : rowOfTrees) {
                output += tree.getSymbol();
            }
            output += "\n";
        }
        return output;
    }
}
