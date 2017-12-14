package main;

import utility.FileUtils;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class day9reddit extends FileUtils {

    enum State {
        OPEN, CLOSE, GARBAGE, IGNORE, OTHER;

        final Map<Character, State> transitions = new HashMap<>();

        // Rules for Finite State Machine
        static {
            State.OTHER.addTransition('{', State.OPEN);
            State.OTHER.addTransition('}', State.CLOSE);
            State.OTHER.addTransition('<', State.GARBAGE);
            State.OPEN.addTransition('}', State.CLOSE);
            State.OPEN.addTransition('<', State.GARBAGE);
            State.OPEN.addTransition(',', State.OTHER);
            State.CLOSE.addTransition('{', State.OPEN);
            State.CLOSE.addTransition('<', State.GARBAGE);
            State.CLOSE.addTransition(',', State.OTHER);
            State.GARBAGE.addTransition('!', State.IGNORE);
            State.GARBAGE.addTransition('>', State.OTHER);
            State.IGNORE.addTransition('!', State.GARBAGE);
        }

        private void addTransition(char c, State accept) {
            transitions.put(c, accept);
        }

        public State getTransition(char c) {
            return transitions.getOrDefault(c, this);
        }
    }



    public static void main(String[] args) {

        State current = State.OTHER;
        String input = null;
        try {
            input = readFileAsString("test/day9input.txt");
        } catch (IOException e) {
            e.printStackTrace();
        }

        int level = 0;
        int garbageCount = 0;
        int score = 0;

        for (int i = 0; i < input.length(); i++) {
            char c = input.charAt(i);
            if (current == State.IGNORE) c = '!';
            State next = current.getTransition(c);
            switch (next) {
                case OPEN:
                    level++;
                    break;
                case CLOSE:
                    score += level--;
                    break;
                case GARBAGE:
                    if (current == State.GARBAGE) garbageCount++;
            }
            current = next;
        }
        System.out.println("Part 1: " + score);
        System.out.println("Part 2: " + garbageCount);
    }
}