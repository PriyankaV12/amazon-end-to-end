package pageObjects;

import mainComponents.components;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class signInPage extends components {

    WebDriver driver;
    public landingPage lp;

    public signInPage(WebDriver driver)
    {
        super(driver);
        this.driver= driver;
        PageFactory.initElements(driver, this);
    }

    //driver.findElement(By.xpath("//a[@class='nav-action-button'][1]")).click();
 //   @FindBy(xpath = "//a[@class='nav-action-button'][1]")
    @FindBy(css = "span[class='nav-action-inner']")
    WebElement signInButton;

    //driver.findElement(By.id("ap_email")).sendKeys("pythontesting3134@gmail.com");
    @FindBy(id = "ap_email")
    WebElement userEmail;

    //driver.findElement(By.id("continue")).click();
    @FindBy(id = "continue")
    WebElement continueButton;

    // driver.findElement(By.id("ap_password")).sendKeys("Atesting2#");
    @FindBy(id = "ap_password")
    WebElement userPassword;

    //driver.findElement(By.id("auth-signin-button")).click();
    @FindBy(id = "auth-signin-button")
    WebElement finalSignIn;

    //String text = driver.findElement(By.id("nav-link-accountList-nav-line-1")).getText();
    @FindBy(id = "nav-link-accountList-nav-line-1")
    WebElement userText;

    //driver.findElement(By.cssSelector("#nav-item-signout")).click();
    @FindBy(css = "#nav-item-signout")
    WebElement signOutButton;

    //  String errorMessage = driver.findElement(By.cssSelector(".a-alert-heading")).getText();
    @FindBy(css = "h4[class='a-alert-heading']")
  //  @FindBy(xpath = "//*[@id='auth-warning-message-box']/div/h4")
    WebElement errorMessage;

    //driver.findElement(By.id("createAccountSubmit")).click();
    @FindBy(id = "createAccountSubmit")
    WebElement createAccount;

    // String createAccount = driver.findElement(By.cssSelector(".a-spacing-small:first-of-type")).getText();
    @FindBy(css = ".a-spacing-small:first-of-type")
    WebElement createAccountText;

    //String enterEmail = driver.findElement(By.cssSelector(".a-alert-content")).getText();
    @FindBy(css = ".a-alert-content")
    WebElement emailError;

    //String enterPassword = driver.findElement(By.cssSelector(".a-box-inner.a-alert-container")).getText();
    @FindBy(css = ".a-box-inner.a-alert-container")
    WebElement passwordError;

    By error = (By.cssSelector("h4[class='a-alert-heading']"));

    public void signIn()
    {
        signInButton.click();
    }

    public void setUserEmail(String userKeys)
    {
        userEmail.sendKeys(userKeys);
    }

    public void setContinueButton()
    {
        continueButton.click();
    }
    public void setUserPassword(String passKeys)
    {
        userPassword.sendKeys(passKeys);
    }

    public void setFinalSignIn()
    {
        finalSignIn.click();
    }

    public void getUserText()
    {
       String text = userText.getText();
       System.out.println(text);
    }
    public void setSignOutButton()
    {
        signOutButton.click();
    }

    public void getErrorMessage()
    {
        waitsVisibility(error);
        String message = errorMessage.getText();
        System.out.println(message);
    }

    public void setCreateAccount()
    {
        createAccount.click();
    }

    public void getCreateAccountText()
    {
       String accountText = createAccountText.getText();
       System.out.println(accountText);
    }

    public void getEmailError()
    {
       String emailText = emailError.getText();
       System.out.println(emailText);
    }

    public void getPasswordError()
    {
        String passText = passwordError.getText();
        System.out.println(passText);
    }

    public void signInForShopping(String userKeys, String passKeys)
    {
        lp = new landingPage(driver);
        lp.signInHover();
        signInButton.click();
        userEmail.sendKeys(userKeys);
        continueButton.click();
        userPassword.sendKeys(passKeys);
        finalSignIn.click();
    }
}
