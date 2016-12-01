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
            String fullDescription = textAnnotations[0].getDescription();

            // parse the fullDescription to an ArrayList of separated Entities
            List<String> allEntityAnnotations = WordParser.parseToWordArray(fullDescription);

            // send to system out
            for (String s : allEntityAnnotations) {
                System.out.println("EntityAnnotation's description = " + s);
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
