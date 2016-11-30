package googleResponse;

public class TextAnnotations
{
    private String description;

    private String locale;

    private BoundingPoly boundingPoly;

    public String getDescription ()
    {
        return description;
    }

    public void setDescription (String description)
    {
        this.description = description;
    }

    public String getLocale ()
    {
        return locale;
    }

    public void setLocale (String locale)
    {
        this.locale = locale;
    }

    public BoundingPoly getBoundingPoly ()
    {
        return boundingPoly;
    }

    public void setBoundingPoly (BoundingPoly boundingPoly)
    {
        this.boundingPoly = boundingPoly;
    }

    @Override
    public String toString()
    {
        return "ClassPojo [description = "+description+", locale = "+locale+", boundingPoly = "+boundingPoly+"]";
    }
}
