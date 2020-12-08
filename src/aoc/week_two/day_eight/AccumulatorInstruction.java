package aoc.week_two.day_eight;

public class AccumulatorInstruction extends Instruction {
    public AccumulatorInstruction(int value) {
        super(value);
    }

    @Override
    public void execute(BootSequence bootSequence) {
        bootSequence.setAccumulator(bootSequence.getAccumulator() + value);
    }

    @Override
    public String toString() {
        return "acc " + (value > 0 ? "+" : "") + value;
    }
}
