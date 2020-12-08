package aoc.week_two.day_eight;

public abstract class Instruction {
    protected int value;

    public Instruction(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    public abstract void execute(BootSequence bootSequence);
}
