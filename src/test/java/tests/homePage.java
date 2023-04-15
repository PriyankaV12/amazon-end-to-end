package tests;

import mainTestComponents.BaseTest;
import mainTestComponents.deriveValues;
import mainTestComponents.gettersAndSetters;
import org.testng.Assert;
import org.testng.annotations.Test;
import pageObjects.landingPage;




public class homePage extends BaseTest {

    public deriveValues values;
    public  landingPage lp;

    public homePage() throws Exception {
//        this.values= mainT();
        gettersAndSetters gobj= new gettersAndSetters();

        this.values = gobj.mainT();
    }

    @Test
    public void homePageSignIn() {

        lp = new landingPage(driver);
        lp.signInHover();
        lp.signIn();

    }

    @Test
    public void validText()
    {
        landingPage lp = new landingPage(driver);
        lp.textBox(values.getItem());
    }

    @Test
    public void footerSection() throws InterruptedException
    {
        landingPage lp = new landingPage(driver);
        int count = lp.footerLinkCount();
        System.out.println(count);
        lp.firstColumnTitles();
        lp.secondColumnTitles();
        lp.setCopyrightSection();
    }

    @Test
    public void hovering()
    {
        landingPage lp = new landingPage(driver);
        lp.languageHover();
        lp.amazonLogo();
        lp.setSecureSignIn();
    }

    @Test
    public void productLinks()
    {
        landingPage lp = new landingPage(driver);
        int topRatedProductLinks = lp.topRatedProductLinks();
        Assert.assertEquals(topRatedProductLinks, values.getExpectedlinkCount());

    }

    @Test
    public void productsContainerDisplay()
    {
        landingPage lp = new landingPage(driver);
        boolean specificationText = lp.getPageBanner();
        Assert.assertTrue(specificationText, values.getPresent());
    }

    @Test
    public void categorizedProducts()
    {
        landingPage lp = new landingPage(driver);
        boolean display =  lp.verifyProductDisplay();
        Assert.assertTrue(display, values.getPresent());
    }



}

