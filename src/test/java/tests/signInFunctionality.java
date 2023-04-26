package tests;

import mainTestComponents.*;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;
import pageObjects.landingPage;
import pageObjects.signInPage;

public class signInFunctionality extends BaseTest {



    public signInFunctionality() throws Exception {

    }


    @Test
    public void validLogin() throws InterruptedException {
        lp = new landingPage(driver);
        sign = new signInPage(driver);
        lp.signInHover();
        sign.signIn();
        sign.setUserEmail(secrets.getValidEmail());
        sign.setContinueButton();
        sign.setUserPassword(secrets.getValidPassword());
        sign.setFinalSignIn();
        sign.getUserText();
        lp.signInHover();
        sign.setSignOutButton();
    }

    @Test(retryAnalyzer = retry.class)
    public void validUsername() throws InterruptedException {
        lp = new landingPage(driver);
        sign = new signInPage(driver);
        lp.signInHover();
        sign.signIn();
        sign.setUserEmail(values.getValidEmail());
        sign.setContinueButton();
        sign.setUserPassword(values.getInValidPassword());
        sign.setFinalSignIn();
        sign.getErrorMessage();
    }

    @Test
    public void invalidUsername() {
        lp = new landingPage(driver);
        sign = new signInPage(driver);
        lp.signInHover();
        sign.signIn();
        sign.setUserEmail(values.getInValidEmail());
        sign.setContinueButton();
        sign.getErrorMessage();
    }

    @Test
    public void createNewAccount() {
        lp = new landingPage(driver);
        sign = new signInPage(driver);
        lp.signInHover();
        sign.signIn();
        sign.setCreateAccount();
        sign.getCreateAccountText();
    }

    @Test
    public void leavingUsernameBlank() {
        lp = new landingPage(driver);
        sign = new signInPage(driver);
        lp.signInHover();
        sign.signIn();
        sign.setContinueButton();
        sign.getEmailError();
    }

    @Test(retryAnalyzer = retry.class)
    public void leavingPasswordBlank() {
        lp = new landingPage(driver);
        sign = new signInPage(driver);
        lp.signInHover();
        sign.signIn();
        sign.setUserEmail(values.getValidEmail());
        sign.setContinueButton();
        sign.setFinalSignIn();
        sign.getPasswordError();

    }


}