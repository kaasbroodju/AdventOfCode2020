package aoc.week_two.day_eight;

public class JumpInstruction extends Instruction {
    public JumpInstruction(int value) {
        super(value);
    }

    @Override
    public void execute(BootSequence bootSequence) {
        bootSequence.setReadIndex(bootSequence.getReadIndex() + value-1);
    }

    @Override
    public String toString() {
        return "jpm " + (value > 0 ? "+" : "") + value;
    }
}
