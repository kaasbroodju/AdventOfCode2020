package aoc.week_one.day_six;

import java.util.*;

public class Group {
    private List<Person> groupMembers = new ArrayList<>();

    public boolean addGroupMember(Person groupMember) {
        return groupMembers.add(groupMember);
    }

    public int getSum() {
        Set<Character> output = new HashSet<>();
        for (Person person : groupMembers) {
            output.addAll(person.getAnswers());
        }
        return output.size();
    }

    public Map<Character, Integer> getResult() {
        Map<Character, Integer> result = new HashMap<>();
        for (Person groupMember : groupMembers) {
            for (Character answer : groupMember.getAnswers()) {
                if (result.containsKey(answer)) {
                    result.put(answer, result.get(answer) + 1);
                } else {
                    result.put(answer, 1);
                }
            }
        }
        return result;
    }

    public Set<Character> getEveryoneAnswered() {
        Map<Character, Integer> answers = getResult();
        Set<Character> result = new HashSet<>();
        for (Character character : answers.keySet()) {
            if (answers.get(character) == groupMembers.size()) result.add(character);
        }
        return result;
    }

    @Override
    public String toString() {
        return "Group{" +
                "groupMembers=" + groupMembers +
                '}';
    }
}
