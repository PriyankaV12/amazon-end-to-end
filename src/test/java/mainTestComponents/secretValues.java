package mainTestComponents;

import org.openqa.selenium.WebDriver;

public class secretValues {
    private String validEmail;
    private String validPassword;
    private String inValidEmail;
    private String inValidPassword;

    public secretValues(WebDriver driver) {
    }

    public void setValidEmail(String e)
    {
        this.validEmail = e;
    }

    public void setValidPassword(String p)
    {
        this.validPassword = p;
    }

    public void setInValidEmail(String ie)
    {
        this.inValidEmail = ie;
    }

    public void setInValidPassword(String ip)
    {
        this.inValidPassword = ip;
    }

    //getters

    public String getValidEmail()
    {
        return validEmail;
    }

    public String getValidPassword()
    {
        return validPassword;
    }

    public String getInValidEmail()
    {
        return inValidEmail;
    }

    public String getInValidPassword()
    {
        return inValidPassword;
    }
}
