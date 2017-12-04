package main;

import java.util.ArrayList;
import java.util.Arrays;

public class DayOne {

    int[] integers;
    public int sum;
    ArrayList<Integer> listOfIntegers;

    public DayOne(String input) {
        this.processInput(input);
    }

    private void processInput(String input) {
        integers = new int[input.length()];
        for (int i = 0; i < integers.length; i++) {
            integers[i] = Integer.parseInt(Character.toString(input.charAt(i)));
        }
    }

    public int calculateSum() {
        for (int i = 0; i < integers.length; i++) {

            if (i != integers.length - 1 && integers[i] == integers[i + 1]) {
                sum += integers[i];
            } else if (i == integers.length - 1 && integers[i] == integers[0]) {
                sum += integers[i];
            }
        }
        return sum;
    }

    public int calculateSecondSum() {
        listOfIntegers = new ArrayList(Arrays.asList(integers));
        int halfway = integers.length/2;

        for (int start = 0; start < integers.length; start++) {

            for (int i = 0; i < integers.length; i++) {
                int result = integers[(i + start) % integers.length];
                int a = 0;
            }

        }

        return sum;
    }
}
