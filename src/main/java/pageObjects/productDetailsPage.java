package pageObjects;

import mainComponents.components;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class productDetailsPage extends components {
    WebDriver driver;
    public landingPage lp;
    public shoppingPageAfterSignIn sp;

    public productDetailsPage(WebDriver driver)
    {
        super(driver);
        this.driver= driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(css = ".a-size-mini.a-spacing-none.a-color-base.s-line-clamp-3")
    List<WebElement> productList;

    @FindBy(id = "landingImage")
    WebElement imageDisplay;

    @FindBy(css = ".a-price.a-text-price.a-size-medium.apexPriceToPay")
    WebElement priceDisplay;

    @FindBy(css = "span[id='acrCustomerReviewText']")
    WebElement rating;

    @FindBy(id = "feature-bullets")
    WebElement productSpecifications;

    @FindBy(xpath = "(//div[@id='availability'][1])[1]")
    WebElement stockAvailability;

    @FindBy(css = ".a-size-small.aok-float-left.ac-badge-rectangle")
    WebElement sellerRating;

    @FindBy(id = "productDescription")
    WebElement productDescription;

    @FindBy(css = "div[class='cardRoot bucket _p13n-desktop-sims-fbt_fbt-desktop_fbt-card__1_smM']")
    WebElement productSuggestions;

    @FindBy(id = "mir-layout-DELIVERY_BLOCK-slot-PRIMARY_DELIVERY_MESSAGE_LARGE")
    WebElement shippingInformation;

    By products = By.cssSelector(".a-size-mini.a-spacing-none.a-color-base.s-line-clamp-3");


    public void productClick(String productName, String productSearch)
    {
        lp = new landingPage(driver);
        lp.textBox(productSearch);
        sp = new shoppingPageAfterSignIn(driver);
        sp.setSearchButton();
        waitsVisibility(products);
        for (int i = 0; i < productList.size(); i++)
        {
            if (productList.get(i).getText().equalsIgnoreCase(productName))
            {
             productList.get(i).click();
                break;
            }
        }
    }

    public boolean imageDisplay()
    {
       return imageDisplay.isDisplayed();
    }

    public String setPriceDisplay()
    {
       return priceDisplay.getText();
    }

    public boolean verifyReview()
    {
       return rating.isDisplayed();
    }

    public boolean verifyProductSpecifications()
    {
       return productSpecifications.isDisplayed();
    }

    public String verifyStock()
    {
        return stockAvailability.getText();

    }

    public boolean verifySellerRating()
    {
       return sellerRating.isDisplayed();
    }

    public boolean verifyProductDescription()
    {
      return productDescription.isDisplayed();
    }

    public boolean verifyProductSuggestions()
    {
       return productSuggestions.isDisplayed();
    }

    public boolean verifyShippingInformation()
    {
        return shippingInformation.isDisplayed();
    }
}
