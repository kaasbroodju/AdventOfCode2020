package aoc.week_two.day_eight;

import java.util.ArrayList;
import java.util.List;

public class DayEight {
    public long accumulatorLoopValue(BootSequence bootSequence) {
        List<Integer> integers = new ArrayList<>();
        while (bootSequence.hasNext()) {
            integers.add(bootSequence.getReadIndex());
            bootSequence.executeInstruction();
            if (integers.contains(bootSequence.getReadIndex())) break;

        }
        return bootSequence.getAccumulator();
    }

    public Long getLoopIndex(BootSequence bootSequence) {
        for (int i = bootSequence.getInstructions().size()-1; i > 0; i--) {
            swapIndex(bootSequence.getInstructions(), i);
            if (simulateRun(bootSequence)) return bootSequence.getAccumulator();
            bootSequence.setReadIndex(0);
            bootSequence.setAccumulator(0);
            swapIndex(bootSequence.getInstructions(), i);
        }
        return -1l;
    }

    private boolean simulateRun(BootSequence bootSequence) {
        System.out.println(bootSequence.getInstructions());
        System.out.println("start simulation");
        List<Integer> integers = new ArrayList<>();
        while (bootSequence.hasNext()) {
            integers.add(bootSequence.getReadIndex());
            bootSequence.executeInstruction();
            if (integers.contains(bootSequence.getReadIndex())) {
                System.out.println("end simulation");
                return false;
            }
        }
        System.out.println("end simulation");
        return true;
    }

    private List<Instruction> swapIndex(List<Instruction> instructions, int i) {
        Instruction instruction = instructions.get(i);
        if (instruction instanceof NoOperationInstruction) {
            instructions.set(i, new JumpInstruction(instruction.getValue()));
        } else if (instruction instanceof JumpInstruction) {
            instructions.set(i, new NoOperationInstruction(instruction.getValue()));
        }
        return instructions;
    }
}
