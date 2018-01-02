package main;

import java.util.Arrays;
import java.util.Comparator;

public class HighestScoringWord {

    public static void main(String[] args) {

        String high = high("man i need a taxi up to ubud");
        String high1 = high("what time are we climbing up to the volcano");
        String take_me_to_semynak = high("take me to semynak");

        System.out.println("New Branch for New Projects!! -> README");
    }

    public static String high(String s) {
        String result = "";

        String[] split = s.split(" ");
        int highScore = 0;
        for (int i = 0; i < split.length; i++) {
            String word = split[i];

            int score = 0;
            for (int j = 0; j < word.length(); j++) {
                char c = word.charAt(j);
                score += getCharPoint(c);
            }

            if (score > highScore && i == split.length - 1) {
                return word;

            } else if (score > highScore) {
                highScore = score;
                result = word;
            }
        }

//        return result;

        // kata best solution
        return Arrays.stream(s.split(" "))
                .max(Comparator.comparingInt(
                        a -> a.chars().map(i -> - 96).sum()
                )).get();
    }

    private static int getCharPoint(char c) {
        int a = 97 - 1;
        return c - a;
    }
}
