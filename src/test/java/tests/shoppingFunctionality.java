package tests;

import mainTestComponents.BaseTest;
import mainTestComponents.deriveValues;
import mainTestComponents.gettersAndSetters;
import mainTestComponents.retry;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;
import pageObjects.*;

public class shoppingFunctionality extends BaseTest {

    public landingPage lp;
    public signInPage sign;
    public shoppingPageAfterSignIn shoppingAfter;
    public deriveValues values;

    public shoppingFunctionality() throws Exception {
        gettersAndSetters gobj= new gettersAndSetters();

        this.values = gobj.mainT();
    }


    @Test
    public void addProductAfterSignIn() {
        sign = new signInPage(driver);
        sign.signInForShopping(values.getValidEmail(), values.getValidPassword());
        lp = new landingPage(driver);
        lp.textBox(values.getKey());
        shoppingAfter = new shoppingPageAfterSignIn(driver);
        shoppingAfter.setSearchButton();
        shoppingAfter.clickOnProduct(values.getProductNeeded());
        shoppingAfter.setAddToCartButton();
        String addToCartText = shoppingAfter.setAddToCartText();
        Assert.assertTrue(addToCartText.equalsIgnoreCase(values.getCartMessage()));
    }

    @Test
    public void addProductWithoutSignIn() {
        lp = new landingPage(driver);
        lp.textBox(values.getKey());
        shoppingAfter = new shoppingPageAfterSignIn(driver);
        shoppingAfter.setSearchButton();
        shoppingAfter.clickOnProduct(values.getProductNeeded());
        shoppingAfter.setAddToCartButton();
        String addToCartText = shoppingAfter.setAddToCartText();
        Assert.assertTrue(addToCartText.equalsIgnoreCase(values.getCartMessage()));
    }

    @Test(retryAnalyzer = retry.class)
    public void editQuantity()
    {
        sign = new signInPage(driver);
        sign.signInForShopping(values.getValidEmail(), values.getValidPassword());
        lp = new landingPage(driver);
        lp.textBox(values.getKey());
        shoppingAfter = new shoppingPageAfterSignIn(driver);
        shoppingAfter.setSearchButton();
        shoppingAfter.clickOnProduct(values.getProductNeeded());
        shoppingAfter.setQuantity(values.getVisibleText());
        String numberOfItems = shoppingAfter.dropdown();
        System.out.println(numberOfItems);
        Assert.assertTrue(numberOfItems.equalsIgnoreCase(values.getQuantity()));
     }

    @Test
    public void removeProductsFromCart()
    {
        lp = new landingPage(driver);
        lp.textBox(values.getKey());
        shoppingAfter = new shoppingPageAfterSignIn(driver);
        shoppingAfter.setSearchButton();
        shoppingAfter.clickOnProduct(values.getProductNeeded());
        shoppingAfter.setAddToCartButton();
        shoppingAfter.setCartIcon();
        shoppingAfter.removeItem();
        String deleteText = shoppingAfter.itemRemovedText();
        Assert.assertTrue(deleteText.equalsIgnoreCase(values.getItemRemovedText()));
    }


    @Test(retryAnalyzer = retry.class)
    public void buyNowButton(){
        productDetailsPage details = new productDetailsPage(driver);
        details.productClick(values.getProductRequired(),values.getProductSearch() );
        shoppingAfter = new shoppingPageAfterSignIn(driver);
        shoppingAfter.setBuyNowButton();
        String signInText =  shoppingAfter.signInText();
        Assert.assertTrue(signInText.equalsIgnoreCase(values.getSignIn()));
    }

    @Test
    public void invalidText()
    {
        lp = new landingPage(driver);
        lp.textBox(values.getInvalidText());
        shoppingAfter = new shoppingPageAfterSignIn(driver);
        shoppingAfter.setSearchButton();
        String result =  shoppingAfter.verifyResultText();
        System.out.println(result);
        Assert.assertTrue(result.equalsIgnoreCase(values.getResultText()));
    }

    @Test
    public void charText()
    {
        lp = new landingPage(driver);
        lp.textBox(values.getCharText());
        shoppingAfter = new shoppingPageAfterSignIn(driver);
        shoppingAfter.setSearchButton();
        String noResults = shoppingAfter.noResultText();
        Assert.assertTrue(noResults.equalsIgnoreCase(values.getNoResultText()));
    }

    @Test
    public void sortFunctionality() throws InterruptedException {
        lp = new landingPage(driver);
        lp.textBox(values.getKey());
        shoppingAfter = new shoppingPageAfterSignIn(driver);
        shoppingAfter.setSearchButton();
        String sortText =  shoppingAfter.sortFunction();
        Assert.assertTrue(sortText.equalsIgnoreCase(values.getSortText()));
    }

    @Test
    public void filterFunctionality()
    {
        lp = new landingPage(driver);
        lp.textBox(values.getKey());
        shoppingAfter = new shoppingPageAfterSignIn(driver);
        shoppingAfter.setSearchButton();
        shoppingAfter.filterFunction();
    }

    @Test
    public void filterElements()
    {
        lp = new landingPage(driver);
        lp.textBox(values.getKey());
        shoppingAfter = new shoppingPageAfterSignIn(driver);
        shoppingAfter.setSearchButton();
        shoppingAfter.checkFilterOptions();
    }

    @Test
    public void searchResult()
    {
        lp = new landingPage(driver);
        lp.textBox(values.getKey());
        shoppingAfter = new shoppingPageAfterSignIn(driver);
        shoppingAfter.setSearchButton();
        String searchText = shoppingAfter.verifyResultText();
        Assert.assertTrue(searchText.equalsIgnoreCase(values.getTextAfterValidSearch()));
    }

    @Test(retryAnalyzer = retry.class)
    public void navigation()
    {
        shoppingAfter = new shoppingPageAfterSignIn(driver);
        shoppingAfter.verifyInnerButton();
        String dealsText = shoppingAfter.checkLinkFunctionality();
        Assert.assertTrue(dealsText.equalsIgnoreCase(values.getDeals()));
    }

}








