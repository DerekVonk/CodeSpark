package main;

import googleResponse.AnnotateImageRequest;
import googleResponse.TextAnnotations;
import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Main {

    private final String DELIMITER = "\n";

    public static void main(String[] args) {


        ObjectMapper mapper = new ObjectMapper();

        AnnotateImageRequest response = new AnnotateImageRequest();

        try {
            // Convert JSON string from file to Object
            response = mapper.readValue(new File("/Users/Vonk/Documents/Projects/CodeSpark/src/response.json"), AnnotateImageRequest.class);
            System.out.println(response);

            TextAnnotations[] textAnnotations = response.getTextAnnotations();
            String description = textAnnotations[0].getDescription();

                if (description.contains("\n")) {
                    List<String> allWordsInDescription = parseToArray(description);

                }


        } catch (JsonGenerationException e) {
            e.printStackTrace();
        } catch (JsonMappingException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public static List<String> parseToArray(String description) {
        List<String> words = new ArrayList<>();

        String[] split = description.split(DELIMITER);

        for (String s : split) {
            words.add(s);
        }

        return words;
    }

}
