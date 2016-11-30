package googleResponse;

public class ImagePropertiesAnnotation
{
    private DominantColors dominantColors;

    public DominantColors getDominantColors ()
    {
        return dominantColors;
    }

    public void setDominantColors (DominantColors dominantColors)
    {
        this.dominantColors = dominantColors;
    }

    @Override
    public String toString()
    {
        return "ClassPojo [dominantColors = "+dominantColors+"]";
    }
}