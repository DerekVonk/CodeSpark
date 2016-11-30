package googleResponse;

public class BoundingPoly
{
    private Vertices[] vertices;

    public Vertices[] getVertices ()
    {
        return vertices;
    }

    public void setVertices (Vertices[] vertices)
    {
        this.vertices = vertices;
    }

    @Override
    public String toString()
    {
        return "ClassPojo [vertices = "+vertices+"]";
    }
}