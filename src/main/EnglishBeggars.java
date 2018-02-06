package main;

import java.util.*;
import java.util.stream.Collectors;

public class EnglishBeggars {

    public static int[] beggars(int[] values, int n) {
        int[] result = new int[n];
        Queue<Integer> queue = Arrays.stream(values).boxed().collect(Collectors.toCollection(LinkedList::new));

        try {
            while (queue.size() > 0) {
                if (n == 0) break;
                for (int i = 0; i < n; i++) {
                    result[i] += queue.remove();
                }
            }
        } catch (NoSuchElementException e) {
            System.out.println("Sorry, no more offers left...");
        }

        return result;
    }
}
