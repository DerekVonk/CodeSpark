package googleResponse;

public class DominantColors
{
    private Colors[] colors;

    public Colors[] getColors ()
    {
        return colors;
    }

    public void setColors (Colors[] colors)
    {
        this.colors = colors;
    }

    @Override
    public String toString()
    {
        return "ClassPojo [colors = "+colors+"]";
    }
}
