package main;

import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class MorseCodeDecoder {

    public static void main(String[] args) {

        System.out.println("hello!");
        String decode = decode(".... . -.--   .--- ..- -.. .");
        System.out.println();

        String code = decodeBits("1100110011001100000011000000111111001100111111001111110000000000000011001111110011111100111111000000110011001111110000001111110011001100000011");
    }


    public static String decodeBits(String bits) {
        bits = removeStartingZeros(bits);
        bits = removeTrailingZeros(bits);
        StringBuilder result = new StringBuilder();

//        int ones = 0;
//        int zeros = 0;
//        for (String s : bits.split("")) {
//            if (s.equalsIgnoreCase("1")) ones++;
//            if (s.equalsIgnoreCase("0")) zeros++;
//        }
//
//        final int frequency = zeros - ones > 0 ? zeros - ones : ones - zeros;

        int count = 1;
        ListIterator<String> characters = Arrays.stream(bits.split("")).collect(Collectors.toList()).listIterator();

        characters.next();
        while(characters.hasNext()) {
//            int nextIndex = characters.nextIndex();
            if (characters.previous().equals(characters.next())) {
                count++;
            } else {
                result.append(decodeCharacter(characters.next(), count));
                count = 0;
            }
            characters.remove();
            characters.next();
        }

//        int size = characters.size();
//        int limit = size / frequency + Math.min(size % frequency, 1);
//        List<String> collectedChars = Stream.iterate(characters, l -> l.subList(frequency, l.size()))
//                .limit(limit)
//                .map(l -> l.get(0))
//                .collect(Collectors.toList());


        return result.toString();
    }

    private static String decodeCharacter(String bit, int count) {

        if (count % 7 == 0) {
            return "   "; // pause between words
        }

        if (bit.equals("1")) {
            if (count % 3 == 0) {
                return "-"; // dash
            } else {
                return "."; // dot
            }

        } else {
            if (count % 3 == 0) {
                return " "; // pause between characters
            } else {
                return ""; // pause between dots and dashes
            }
        }

    }

    public static String removeTrailingZeros(String bits) {
        // remove trailing zero's
        while (bits.charAt(bits.length() - 1) == '0') {
            bits = bits.substring(0, bits.length() - 1);
        }
        return bits;
    }

    public static String removeStartingZeros(String bits) {
        // remove starting zero's
        while (bits.charAt(0) == '0') {
            bits = bits.substring(1);
        }
        return bits;
    }

    public static String decode(String morseCode) {

        String result = "aa";
        String test = String.valueOf(result.charAt(1));

        for(String word : morseCode.trim().split("   ")) {
            for(String letter : word.split("\\s+")) {
//                result += MorseCode.get(letter);
            }
            result += ' ';
        }
        return result.trim();
    }
}