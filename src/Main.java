import googleResponse.AnnotateImageRequest;
import googleResponse.BoundingPoly;
import googleResponse.TextAnnotations;
import googleResponse.Vertices;
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

            while (allPolygons.iterator().hasNext()) {
                BoundingPoly next = allPolygons.iterator().next();

                Vertices[] vertices = next.getVertices();

                int[] yCoordinates = new int[4];
                int count = 0;
                int max = 0;
                for (Vertices vertice : vertices) {
                    int y = Integer.parseInt(vertice.getY());
                    yCoordinates[0] = y;
                    count++;
                    max = Math.max(Math.max(Math.max(yCoordinates[0], yCoordinates[1]), yCoordinates[2]), yCoordinates[3]);
                }

                System.out.println("max of vertice is: " + max);
                allPolygons.iterator().remove();

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


    public static int maxY(int a, int b, int c, int d) {

        return Math.max(Math.max(Math.max(a, b), c),d);
    }

    public static int minY(int a, int b, int c, int d) {

        return Math.min(Math.min(Math.min(a, b), c),d);
    }



}
