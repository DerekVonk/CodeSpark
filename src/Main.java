import googleResponse.AnnotateImageRequest;
import googleResponse.BoundingPoly;
import googleResponse.TextAnnotations;
import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {


        ObjectMapper mapper = new ObjectMapper();

        AnnotateImageRequest response = new AnnotateImageRequest();

        try {
            // Convert JSON string from file to Object
            response = mapper.readValue(new File("/Users/Vonk/Documents/Projects/CodeSpark/src/response.json"), AnnotateImageRequest.class);
            System.out.println(response);

            TextAnnotations[] textAnnotations = response.getTextAnnotations();

            List<BoundingPoly> allPolygons = new ArrayList<>();
            for (TextAnnotations textAnnotation : textAnnotations) {
                allPolygons.add(textAnnotation.getBoundingPoly());
            }

            System.out.println(allPolygons.toString());



        } catch (JsonGenerationException e) {
            e.printStackTrace();
        } catch (JsonMappingException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}
