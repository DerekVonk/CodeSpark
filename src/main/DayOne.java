package main;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Queue;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class DayOne {

    int[] integers;
    public int sum;

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
        // using Java 8 streams.
        List<Integer> intList = Arrays.stream(integers).boxed().collect(Collectors.toList());

        for (int start = 0; start < integers.length; start++) {

            for (int i = 0; i < integers.length; i++) {


                int result = integers[(i + start) % integers.length];
                int a = 0;
            }

        }

        return sum;
    }
}
