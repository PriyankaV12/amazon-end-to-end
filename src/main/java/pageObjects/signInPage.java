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

    @FindBy(css = "span[class='nav-action-inner']")
    WebElement signInButton;

    @FindBy(id = "ap_email")
    WebElement userEmail;

    @FindBy(id = "continue")
    WebElement continueButton;

    @FindBy(id = "ap_password")
    WebElement userPassword;

    @FindBy(id = "auth-signin-button")
    WebElement finalSignIn;

    @FindBy(id = "nav-link-accountList-nav-line-1")
    WebElement userText;

    @FindBy(css = "#nav-item-signout")
    WebElement signOutButton;

    @FindBy(css = "h4[class='a-alert-heading']")
    WebElement errorMessage;

    @FindBy(id = "createAccountSubmit")
    WebElement createAccount;

    @FindBy(css = ".a-spacing-small:first-of-type")
    WebElement createAccountText;

    @FindBy(css = ".a-alert-content")
    WebElement emailError;

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
