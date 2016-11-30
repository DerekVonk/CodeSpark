package googleResponse;

public class AnnotateImageRequest {

    private ImagePropertiesAnnotation imagePropertiesAnnotation;

    private SafeSearchAnnotation safeSearchAnnotation;

    private TextAnnotations[] textAnnotations;

    private LabelAnnotations[] labelAnnotations;

    public ImagePropertiesAnnotation getImagePropertiesAnnotation ()
    {
        return imagePropertiesAnnotation;
    }

    public void setImagePropertiesAnnotation (ImagePropertiesAnnotation imagePropertiesAnnotation)
    {
        this.imagePropertiesAnnotation = imagePropertiesAnnotation;
    }

    public SafeSearchAnnotation getSafeSearchAnnotation ()
    {
        return safeSearchAnnotation;
    }

    public void setSafeSearchAnnotation (SafeSearchAnnotation safeSearchAnnotation)
    {
        this.safeSearchAnnotation = safeSearchAnnotation;
    }

    public TextAnnotations[] getTextAnnotations ()
    {
        return textAnnotations;
    }

    public void setTextAnnotations (TextAnnotations[] textAnnotations)
    {
        this.textAnnotations = textAnnotations;
    }

    public LabelAnnotations[] getLabelAnnotations ()
    {
        return labelAnnotations;
    }

    public void setLabelAnnotations (LabelAnnotations[] labelAnnotations)
    {
        this.labelAnnotations = labelAnnotations;
    }

    @Override
    public String toString()
    {
        return "ClassPojo [imagePropertiesAnnotation = "+imagePropertiesAnnotation+", safeSearchAnnotation = "+safeSearchAnnotation+", textAnnotations = "+textAnnotations+", labelAnnotations = "+labelAnnotations+"]";
    }
}