package pageObjects;


import mainComponents.components;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.Iterator;
import java.util.List;
import java.util.Set;

public class landingPage extends components {

    WebDriver driver;
    public Actions action;

    public landingPage(WebDriver driver) {
        super(driver);
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(id = "nav-link-accountList")
    WebElement signInTab;

    @FindBy(xpath = "//a[@class='nav-action-button'][1]")
    WebElement signInButton;

    @FindBy(linkText = "Prime")
    WebElement primeTab;

    @FindBy(id = "twotabsearchtextbox")
    WebElement textbox;

    @FindBy(tagName = "a")
    List<WebElement> count;

    @FindBy(id = "navFooter")
    WebElement footerSection;

    @FindBy(xpath = "//div[@class='navFooterLinkCol navAccessibility'][1]")
    WebElement firstColumn;

    @FindBy(xpath = "//div[@class='navFooterLinkCol navAccessibility'][2]")
    WebElement secondColumn;

    @FindBy(id = "icp-touch-link-language")
    WebElement language;

    @FindBy(id = "nav-logo-sprites")
    WebElement logo;

    @FindBy(css = ".navFooterCopyright")
    WebElement copyrightSection;

    @FindBy(linkText = "Sign in securely")
    WebElement secureSignIn;

    @FindBy(id = "gw-card-layout")
    WebElement topRatedProducts;

    @FindBy(linkText = "Shop now")
    WebElement pageLink;

    @FindBy(css = "div[data-card-metrics-id$='ameyal-product-shoveler_desktop-gateway-btf_1']")
    WebElement pageBanner;

    //driver.findElements(By.cssSelector(".a-section.as-title-block")
    @FindBy(css = ".a-section.as-title-block")
    List<WebElement> productDisplay;

    By pageText = By.cssSelector("div[data-card-metrics-id$='ameyal-product-shoveler_desktop-gateway-btf_1']");


    public void signInHover() {
        action = new Actions(this.driver);
        action.moveToElement(signInTab).build().perform();
    }

    public void signIn() {
        action = new Actions(this.driver);
        action.moveToElement(signInButton).click().perform();
        driver.navigate().back();
    }

//    public void prime() {
//        action = new Actions(this.driver);
//        action.moveToElement(primeTab).build().perform();
//
//        }

    public void getUrl(String url) {
        driver.get(url);
    }

    public void textBox(String keys) {
        textbox.sendKeys(keys);
    }

    public int footerLinkCount() {
        return footerSection.findElements(By.tagName("a")).size();


    }

    public void firstColumnTitles() throws InterruptedException {
        String parent = driver.getWindowHandle();
        List<WebElement> columnLinkCount = firstColumn.findElements(By.tagName("a"));

        for (int i = 0; i < columnLinkCount.size(); i++) {
            String keys = Keys.chord(Keys.COMMAND, Keys.ENTER);
            columnLinkCount.get(i).sendKeys(keys);
            Thread.sleep(5000);

        }

        Set<String> handles = driver.getWindowHandles();
        Iterator<String> it = handles.iterator();

        while (it.hasNext()) {
            driver.switchTo().window(it.next());
        }
        driver.switchTo().window(parent);

    }

    public void secondColumnTitles() throws InterruptedException {
        String parent = driver.getWindowHandle();
        List<WebElement> linkCount = secondColumn.findElements(By.tagName("a"));
        for (int i = 0; i < linkCount.size(); i++) {
            String keys = Keys.chord(Keys.COMMAND, Keys.ENTER);
            linkCount.get(i).sendKeys(keys);
            Thread.sleep(2000);
        }
        Set<String> secondColumnHandles = driver.getWindowHandles();
        Iterator<String> iterator = secondColumnHandles.iterator();

        while (iterator.hasNext()) {
            driver.switchTo().window(iterator.next());

        }
        driver.switchTo().window(parent);
    }

    public void languageHover() {
        action = new Actions(this.driver);
        action.moveToElement(language).build().perform();
    }

    public void amazonLogo() {
        logo.click();
    }

    public void setCopyrightSection() throws InterruptedException {
        String parent = driver.getWindowHandle();
        List<WebElement> count1 = copyrightSection.findElements(By.tagName("a"));

        for (int i = 0; i < count1.size(); i++) {
            String keys = Keys.chord(Keys.COMMAND, Keys.ENTER);
            count1.get(i).sendKeys(keys);
            Thread.sleep(2000);
        }
        Set<String> copyrightHandles = driver.getWindowHandles();
        Iterator<String> iterator1 = copyrightHandles.iterator();

        while (iterator1.hasNext()) {
            driver.switchTo().window(iterator1.next());
        }
        driver.switchTo().window(parent);

    }

    public void setSecureSignIn() {
        secureSignIn.click();
        driver.navigate().back();
    }

    public int topRatedProductLinks() {
        return topRatedProducts.findElements(By.tagName("a")).size();


    }

    public void clickOnProductLink() {
        pageLink.click();
    }

    public boolean getPageBanner() {
        waitsVisibility(pageText);
        return pageBanner.isDisplayed();
    }

    public boolean verifyProductDisplay() {
        for (int i = 0; i < productDisplay.size(); i++) {
            if (productDisplay.get(i).isDisplayed()) {
                return true;
            }
        }
        return false;
    }
}
