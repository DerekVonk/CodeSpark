package googleResponse;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class AnnotateImageRequest {

    private TextAnnotations[] textAnnotations;

    public TextAnnotations[] getTextAnnotations() {
        return textAnnotations;
    }

    public void setTextAnnotations(TextAnnotations[] textAnnotations) {
        this.textAnnotations = textAnnotations;
    }
}