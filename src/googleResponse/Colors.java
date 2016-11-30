package googleResponse;

public class Colors
{
    private String percent;

    private String hex;

    private Color color;

    private String score;

    private String rgb;

    private String pixelFraction;

    private String percentRounded;

    public String getPercent ()
    {
        return percent;
    }

    public void setPercent (String percent)
    {
        this.percent = percent;
    }

    public String getHex ()
    {
        return hex;
    }

    public void setHex (String hex)
    {
        this.hex = hex;
    }

    public Color getColor ()
    {
        return color;
    }

    public void setColor (Color color)
    {
        this.color = color;
    }

    public String getScore ()
    {
        return score;
    }

    public void setScore (String score)
    {
        this.score = score;
    }

    public String getRgb ()
    {
        return rgb;
    }

    public void setRgb (String rgb)
    {
        this.rgb = rgb;
    }

    public String getPixelFraction ()
    {
        return pixelFraction;
    }

    public void setPixelFraction (String pixelFraction)
    {
        this.pixelFraction = pixelFraction;
    }

    public String getPercentRounded ()
    {
        return percentRounded;
    }

    public void setPercentRounded (String percentRounded)
    {
        this.percentRounded = percentRounded;
    }

    @Override
    public String toString()
    {
        return "ClassPojo [percent = "+percent+", hex = "+hex+", color = "+color+", score = "+score+", rgb = "+rgb+", pixelFraction = "+pixelFraction+", percentRounded = "+percentRounded+"]";
    }
}