package main;

import googleResponse.AnnotateImageRequest;
import googleResponse.TextAnnotations;
import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;
import utility.WordParser;

import java.io.File;
import java.io.IOException;
import java.util.List;

public class Main {

    private final String DELIMITER = "\n";

    public static void main(String[] args) {

        ObjectMapper mapper = new ObjectMapper();

        AnnotateImageRequest response;

        try {
            // Convert JSON string from file to Object
            response = mapper.readValue(new File("./src/response.json"), AnnotateImageRequest.class);

            // retrieve all textAnnotations from the
            TextAnnotations[] textAnnotations = response.getTextAnnotations();

            // retrieve the first of the textAnnotation vector. This is the object
            // that contains the full description
            String description = textAnnotations[0].getDescription();

            List<String> allWordsInDescription = null;
            // check if the description indeed contains a string with '\n' delimiters to indicate
            // that this description is indeed the one we want to parse
            if (description.contains("\n")) {
                    allWordsInDescription = WordParser.parseToWordArray(description);
            }

            // for debugging purpose
            for (String s : allWordsInDescription) {
                System.out.println("Word = " + s);
            }


        } catch (JsonGenerationException e) {
            e.printStackTrace();
        } catch (JsonMappingException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
