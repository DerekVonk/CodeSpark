package googleResponse;

public class LabelAnnotations
{
    private String description;

    private String score;

    private String mid;

    public String getDescription ()
    {
        return description;
    }

    public void setDescription (String description)
    {
        this.description = description;
    }

    public String getScore ()
    {
        return score;
    }

    public void setScore (String score)
    {
        this.score = score;
    }

    public String getMid ()
    {
        return mid;
    }

    public void setMid (String mid)
    {
        this.mid = mid;
    }

    @Override
    public String toString()
    {
        return "ClassPojo [description = "+description+", score = "+score+", mid = "+mid+"]";
    }
}