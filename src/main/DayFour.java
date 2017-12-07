package main;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class DayFour {

    public ArrayList<Passphrase> input;

    private File file;

    public DayFour(String filename) {
        try {
            file = new File(filename);
            FileReader reader = new FileReader(file);
            BufferedReader bReader = new BufferedReader(reader);
            StringBuffer stringBuffer = new StringBuffer();
            String line;

            Passphrase passphrase;
            input = new ArrayList<>();
            while ((line = bReader.readLine()) != null) {
                passphrase = new Passphrase(line);
                if (isValidPassphrase(passphrase)) {
                    input.add(passphrase);
                    stringBuffer.append(line);
                    stringBuffer.append("\n");
                }
            }

            reader.close();
            System.out.println("\nValid lines of input file: " + input.size());
//            System.out.println(stringBuffer.toString());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * checks if the given passphrase is valid.
     *
     * @param input Passphrase, is an array of strings
     * @return return true if no word exists twice in the passphrase and no word is anagram to another
     */
    public boolean isValidPassphrase(Passphrase input) {
        String[] words = input.words;
        for (int i = 0; i < words.length; i++) {
            for (int j = i + 1; j < words.length; j++) {
                String a = words[i];
                String b = words[j];
                if (a.equals(b)) {
                    System.out.println("repeated word " + words[i] + " in passphrase: \n" + input);
                    return false;
                }

                if (isAnagram(a, b)) {
                    System.out.println("word " + a + " is an anagram to " + b);
                    return false;
                }
            }
        }
        return true;
    }


    /**
     * take character array of first String and loop through it, then finds that character in second String,
     * and deletes it by using substring method.
     * If second String doesn't contains character than method return false immediately.
     * At the end of test if second String is empty than both Strings are anagram because they
     * contain the same set of characters.
     * To improve performance, we checked length at the start
     *
     *
     * @param word first word
     * @param anagram second word
     * @return true if both words are anagram
     */
    private boolean isAnagram(String word, String anagram) {
        if(word.length() != anagram.length()){
            return false;
        }

        word = word.trim();
        anagram = anagram.trim();

        char[] chars = word.toCharArray();

        for (char c : chars) {
            int index = anagram.indexOf(c);
            if (index != -1) {
                anagram = anagram.substring(0,index) + anagram.substring(index +1, anagram.length());
            } else {
                return false;
            }
        }

        return anagram.isEmpty();
    }
}
