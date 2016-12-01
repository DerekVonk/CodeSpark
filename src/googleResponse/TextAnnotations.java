package googleResponse;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class TextAnnotations
{
    private String description;

    private String locale;

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

    @Override
    public String toString()
    {
        return "ClassPojo TextAnnotations: [description = " + description + ", locale = " + locale + "]";
    }
}
