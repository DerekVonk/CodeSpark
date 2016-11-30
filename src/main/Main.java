package main;

import googleResponse.AnnotateImageRequest;
import googleResponse.TextAnnotations;
import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;
import utility.WordParser;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class Main {

    private final String DELIMITER = "\n";

    public static void main(String[] args) {


        ObjectMapper mapper = new ObjectMapper();

        AnnotateImageRequest response = new AnnotateImageRequest();

        try {
            // Convert JSON string from file to Object
            response = mapper.readValue(new File("./src/response.json"), AnnotateImageRequest.class);
            System.out.println(response);

            TextAnnotations[] textAnnotations = response.getTextAnnotations();
            String description = textAnnotations[0].getDescription();

            List<String> allWordsInDescription = null;
                if (description.contains("\n")) {
                    allWordsInDescription = WordParser.parseToArray(description);
                }

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
