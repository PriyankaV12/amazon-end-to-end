package pageObjects;

import mainComponents.components;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class shoppingPageAfterSignIn extends components {

    public signInPage sign;
    WebDriver driver;

    public shoppingPageAfterSignIn(WebDriver driver) {
        super(driver);
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(css = "#nav-search-submit-button")
    WebElement searchButton;

    @FindBy(css = ".a-size-mini.a-spacing-none.a-color-base.s-line-clamp-3")
    List<WebElement> products;

    @FindBy(css = ".a-button.a-spacing-small.a-button-primary.a-button-icon.natc-enabled")
    WebElement addToCartButton;

    @FindBy(id = "quantity")
    WebElement staticDropdown;

    @FindBy(css = ".a-size-medium-plus.a-color-base.sw-atc-text.a-text-bold")
    WebElement addToCartText;

    @FindBy(css = ".a-dropdown-prompt")
    WebElement quantityDropdown;

    @FindBy(id = "nav-cart")
    WebElement cartIcon;

    @FindBy(css = "input[data-action='delete']")
    WebElement deleteButton;

    @FindBy(xpath = "//div[@data-asin='B0BRM9BJ6N']/child::div[1]")
    WebElement itemRemoved;

    @FindBy(css = "#buy-now-button")
    WebElement buyNowButton;

    @FindBy(css = ".a-spacing-small:first-of-type")
    WebElement signIn;

    @FindBy(xpath = "//div[@class='a-section a-spacing-small a-spacing-top-small']")
    WebElement result;

    @FindBy(css = ".a-size-medium.a-color-base:first-of-type")
    WebElement resultText;

    @FindBy(id = "s-result-sort-select")
    WebElement dropdown;

    @FindBy(css = ".a-spacing-small:first-of-type")
    WebElement navigateToSignInPage;

    @FindBy(id = "sw-subtotal")
    WebElement price;

    @FindBy(linkText = "Go to Cart")
    WebElement goToCartButton;

    @FindBy(css = ".a-dropdown-prompt")
    WebElement quantityText;

    @FindBy(css = ".a-dropdown-prompt")
    WebElement numberOfItems;

    @FindBy(css = ".a-section.a-spacing-double-large")
    WebElement filter;

    @FindBy(css = ".a-size-base.a-color-base.puis-bold-weight-text")
    List<WebElement> filterOptions;

    @FindBy(css = "a[data-csa-c-content-id*='nav_cs_gb']")
    WebElement linkOnHomePage;

    @FindBy(css = ".a-size-extra-large.a-spacing-micro")
    WebElement dealsLink;

    @FindBy(css = ".a-button-inner")
    WebElement innerButton;


    By productVisibility = By.cssSelector(".a-size-mini.a-spacing-none.a-color-base.s-line-clamp-3");
    By addToCart = By.cssSelector(".a-button.a-spacing-small.a-button-primary.a-button-icon.natc-enabled");
    By text = By.cssSelector(".a-size-medium-plus.a-color-base.sw-atc-text.a-text-bold");
    By deleteMessage = By.xpath("//div[@data-asin='B0BRM9BJ6N']/child::div[1]");
    By getSignInText = By.cssSelector(".a-spacing-small:first-of-type");
    By getResult = By.cssSelector(".a-size-medium.a-color-base:first-of-type");
    By sort = By.id("s-result-sort-select");


    public void setSearchButton() {
        searchButton.click();
    }

    public void verifyInnerButton()
    {
        innerButton.click();
    }

    public String signInText() {
        waitsVisibility(getSignInText);
        return signIn.getText();
    }

    public String setAddToCartText()
    {
        waitsVisibility(text);
       return addToCartText.getText();
    }

    public String dropdown()
    {
       return quantityDropdown.getText();
    }
    public void setCartIcon() {
        cartIcon.click();
    }


    public void removeItem() {
        deleteButton.click();
    }

    public String itemRemovedText() {
        waitsVisibility(deleteMessage);
        return itemRemoved.getText();

    }
    public void setBuyNowButton() {
        buyNowButton.click();
    }

    public String verifyResultText() {
        return result.getText();
    }


    public String noResultText() {
        waitsVisibility(getResult);
        return resultText.getText();
    }


    public String sortFunction() {
        waitsVisibility(sort);
        Select select = new Select(dropdown);
        select.selectByVisibleText("Newest Arrivals");
        return select.getFirstSelectedOption().getText();
    }


    public void clickOnProduct(String item) {
        waitsVisibility(productVisibility);
        for (int i = 0; i < products.size(); i++) {
            if (products.get(i).getText().equalsIgnoreCase(item)) {
                products.get(i).click();
                break;
            }
        }

    }

    public void setAddToCartButton() {
        waitsVisibility(addToCart);
        addToCartButton.click();
    }

    public void setQuantity(String i) {
        Select select = new Select(staticDropdown);
        select.selectByVisibleText(i);
        quantityText.getText();

    }

    public void filterFunction()
    {
        filter.isDisplayed();
    }

    public void checkFilterOptions()
    {

        for (int i = 0; i < filterOptions.size(); i++)
        {
            filterOptions.get(i).isDisplayed();
        }
    }

    public String checkLinkFunctionality()
    {
        linkOnHomePage.click();
        return dealsLink.getText();
    }

}







