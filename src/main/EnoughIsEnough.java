package main;

import java.util.*;

public class EnoughIsEnough {

    public static void main(String[] args) {

        deleteNth(new int[] { 1, 2, 3, 1, 1, 2, 1, 2, 3, 3, 2, 4, 5, 3, 1 }, 3);

        System.out.println("");
    }

    public static int[] deleteNth(int[] elements, int maxOccurrences) {

        // gave up on this one... Need to understand the streams more...

        if (maxOccurrences < 1) return new int[0];

        final HashMap<Integer,Integer> map = new HashMap<>();
        final List<Integer> list = new ArrayList<>();

        for (final Integer i : elements) {
            final Integer v = map.put(i, map.getOrDefault(i, 0) + 1);
            if (v == null || v < maxOccurrences) list.add(i);
        }

        return list.stream().mapToInt(i->i).toArray();
    }

}
