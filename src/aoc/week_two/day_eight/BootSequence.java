package aoc.week_two.day_eight;

import java.util.ArrayList;
import java.util.List;

public class BootSequence {
    private long accumulator = 0;
    private List<Instruction> instructions = new ArrayList<>();
    private int readIndex = 0;

    public boolean addInstruction(Instruction instruction) {
        return instructions.add(instruction);
    }

    public boolean hasNext() {
        return instructions.size() > readIndex;
    }

    public void executeInstruction() {
        System.out.println(readIndex + " " + instructions.get(readIndex));
        instructions.get(readIndex).execute(this);
        readIndex++;
    }

    public long getAccumulator() {
        return accumulator;
    }

    public BootSequence setAccumulator(long accumulator) {
        this.accumulator = accumulator;
        return this;
    }

    public int getReadIndex() {
        return readIndex;
    }

    public BootSequence setReadIndex(int readIndex) {
        this.readIndex = readIndex;
        return this;
    }

    public List<Instruction> getInstructions() {
        return instructions;
    }

    public BootSequence setInstructions(List<Instruction> instructions) {
        this.instructions = instructions;
        return this;
    }
}
