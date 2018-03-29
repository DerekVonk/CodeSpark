package main;

import java.util.Arrays;
import java.util.stream.IntStream;

// Are they the 'same'?
public class AreSame {

    public static boolean comp(int[] a, int[] b) {
        if (a == null || b == null) return false;
        return Arrays.equals(getSortedDoubles(a), getSquaredAndSortedDoubles(b));
    }

    private static double[] getSquaredAndSortedDoubles(int[] inputArray) {
        return IntStream.of(inputArray)
                    .mapToDouble(Math::sqrt)
                    .sorted()
                    .toArray();
    }

    private static double[] getSortedDoubles(int[] numbers) {
        return IntStream.of(numbers)
                    .mapToDouble(i -> i)
                    .sorted()
                    .toArray();
    }
}
