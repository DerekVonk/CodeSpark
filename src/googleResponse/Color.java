package googleResponse;

public class Color
{
    private String red;

    private String blue;

    private String green;

    public String getRed ()
    {
        return red;
    }

    public void setRed (String red)
    {
        this.red = red;
    }

    public String getBlue ()
    {
        return blue;
    }

    public void setBlue (String blue)
    {
        this.blue = blue;
    }

    public String getGreen ()
    {
        return green;
    }

    public void setGreen (String green)
    {
        this.green = green;
    }

    @Override
    public String toString()
    {
        return "ClassPojo [red = "+red+", blue = "+blue+", green = "+green+"]";
    }
}