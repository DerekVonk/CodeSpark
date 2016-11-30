package utility;

import java.util.ArrayList;
import java.util.List;

public class WordParser {

    private static String DELIMITER = "\n";

    public static List<String> parseToArray(String description) {
        List<String> words = new ArrayList<>();

        String[] split = description.split(DELIMITER);

        for (String s : split) {
            words.add(s);
        }

        return words;
    }


}
