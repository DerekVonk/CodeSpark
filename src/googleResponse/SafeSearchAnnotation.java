package googleResponse;

public class SafeSearchAnnotation
{
    private String medical;

    private String spoof;

    private String violence;

    private String adult;

    public String getMedical ()
    {
        return medical;
    }

    public void setMedical (String medical)
    {
        this.medical = medical;
    }

    public String getSpoof ()
    {
        return spoof;
    }

    public void setSpoof (String spoof)
    {
        this.spoof = spoof;
    }

    public String getViolence ()
    {
        return violence;
    }

    public void setViolence (String violence)
    {
        this.violence = violence;
    }

    public String getAdult ()
    {
        return adult;
    }

    public void setAdult (String adult)
    {
        this.adult = adult;
    }

    @Override
    public String toString()
    {
        return "ClassPojo [medical = "+medical+", spoof = "+spoof+", violence = "+violence+", adult = "+adult+"]";
    }
}