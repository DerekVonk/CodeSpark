package utility;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class WordParser {

    private static String DELIMITER = "\n";

    /**
     * String input is split based on the DELIMITER and adds each split piece as a String to a List.
     * The first String in the returned List is a concatenation of the entire input string stripped of the DELIMITER.
     *
     * @param description string to be parsed
     * @return List of Strings representing each delimiter seperated word from description
     */
    public static List<String> parseToWordArray(String description) {
        List<String> result = new ArrayList<>();

        String cleanDescription = removeDelimiter(description);
        result.add(cleanDescription);

        String[] split = description.split(DELIMITER);
        for (String s : split) {
            result.add(s);
        }

        return result;
    }

    /**
     * Remove all delimiters from String
     *
     * @param description string to be parsed
     * @return String result of description without the DELIMITER
     */
    public static String removeDelimiter(String description) {
        return description.replace(DELIMITER, "");
    }

}
