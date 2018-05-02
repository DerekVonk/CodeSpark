package main;


import java.util.stream.Stream;

public class StrongNumber {

    private static String STRONG = "STRONG!!!!";
    private static String NOT_STRONG = "Not Strong !!";

    public static String isStrongNumber(int n) {
        int[] digits = createArrayFromNumber(n);

        int factorialSum = 0;
        for (int digit : digits) {
            factorialSum += factorial(digit);
        }

        return isStrongNumber(factorialSum, n) ? STRONG : NOT_STRONG;
    }

    private static int[] createArrayFromNumber(int n) {
        return Stream.of(String.valueOf(n).split("")).mapToInt(Integer::valueOf).toArray();
    }

    private static int factorial(int n) {
        return n == 0 ? 1 : n * factorial(n - 1);
    }

    private static boolean isStrongNumber(int factorialSum, int input) {
        return factorialSum == input;
    }
}
