package main;

import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
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
        // remove starting zero's
        while (bits.charAt(0) == '0') {
            bits = bits.substring(1);
        }

        // remove trailing zero's
        while (bits.charAt(bits.length() - 1) == '0') {
            bits = bits.substring(0, bits.length() - 1);
        }

        String result = "";

        int ones = 0;
        int zeros = 0;
        for (String s : bits.split("")) {
            if (s.equalsIgnoreCase("1")) ones++;
            if (s.equalsIgnoreCase("0")) zeros++;
        }

//        int frequency = bits.length() % zeros;
        final int frequency = zeros - ones > 0 ? zeros - ones : ones - zeros;

        List<String> characters = Arrays.stream(bits.split("")).collect(Collectors.toList());

        int size = characters.size();
        int limit = size / frequency + Math.min(size % frequency, 1);
        List<String> collectedChars = Stream.iterate(characters, l -> l.subList(frequency, l.size()))
                .limit(limit)
                .map(l -> l.get(0))
                .collect(Collectors.toList());

        int count = 0;
        int tu = 0;
        for (int i = 0; i < collectedChars.size(); ) {
            String current = collectedChars.get(i);
            
            i = i - count;

            if (tu == 1 && current.equals("1")) {
                result += ".";
            } else if (tu == 3 && current.equals("1")) {
                result += "-";
            } else if (tu == 7 && current.equals("0")) {
                result += "   ";
//            } else if (tu == 1 && current.equals("0")) {
//                result += "";
            } else if (tu == 3 && current.equals("0")) {
                result += " ";
            }

        }

        return result;
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