package googleResponse;

public class Vertices
{
    private String y;

    private String x;

    public String getY ()
    {
        return y;
    }

    public void setY (String y)
    {
        this.y = y;
    }

    public String getX ()
    {
        return x;
    }

    public void setX (String x)
    {
        this.x = x;
    }

    @Override
    public String toString()
    {
        return "ClassPojo [y = "+y+", x = "+x+"]";
    }
}
