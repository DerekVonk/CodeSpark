package utility;

import java.util.ArrayList;
import java.util.List;

public class WordParser {

    private static String DELIMITER = "\n";

    /**
     * @param description string to be parsed
     * @return List of Strings representing each delimiter seperated word from description
     */
    public static List<String> parseToWordArray(String description) {
        List<String> words = new ArrayList<>();

        String[] split = description.split(DELIMITER);

        for (String s : split) {
            words.add(s);
        }

        return words;
    }
}
