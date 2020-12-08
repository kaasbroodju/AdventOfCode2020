package aoc.week_one.day_six;

import java.util.HashSet;
import java.util.Set;

public class Person {
    private Set<Character> answers = new HashSet<>();

    public void answer(char aChar) {
        answers.add(aChar);
    }

    public Set<Character> getAnswers() {
        return answers;
    }

    @Override
    public String toString() {
        return "Person{" +
                "answers=" + answers +
                '}';
    }
}
