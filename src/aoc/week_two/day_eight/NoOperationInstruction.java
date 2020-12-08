package aoc.week_two.day_eight;

public class NoOperationInstruction extends Instruction{
    public NoOperationInstruction(int value) {
        super(value);
    }

    @Override
    public void execute(BootSequence bootSequence) {

    }

    @Override
    public String toString() {
        return "nop " + (value > 0 ? "+" : "") + value;
    }
}
