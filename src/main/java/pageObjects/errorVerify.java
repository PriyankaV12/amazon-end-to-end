package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class errorVerify {

    WebDriver driver;

    public errorVerify(WebDriver driver)
    {
        this.driver= driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(id = "glow-ingress-line1")
    WebElement topText;


    public String TextVisible()
    {
       return topText.getText();


    }
}
