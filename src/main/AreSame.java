package main;

import java.util.Arrays;
import java.util.stream.IntStream;

// Are they the 'same'?
public class AreSame {

    public static boolean comp(int[] a, int[] b) {
        double[] aAsDoubles = IntStream.of(a)
                .mapToDouble(i -> i)
                .sorted()
                .toArray();

        double[] bAsDoubles = IntStream.of(b)
                .mapToDouble(Math::sqrt)
                .sorted()
                .toArray();

        return Arrays.equals(aAsDoubles, bAsDoubles);
    }
}
