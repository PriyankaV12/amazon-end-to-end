package mainTestComponents;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import pageObjects.landingPage;
import org.apache.commons.io.FileUtils;
import pageObjects.signInPage;

import java.io.*;
import java.time.Duration;


public class BaseTest  extends gettersAndSetters{

    public landingPage lp;
    public WebDriver driver;
    public deriveValues values=mainT();
    public deriveValues secrets=mainS();
    public signInPage sign;


    public BaseTest() throws Exception {

    }

    public WebDriver initializeDriver() throws IOException {

        String browserName = values.getBrowser();
        if (browserName.equalsIgnoreCase(values.getRequiredBrowser()))
        {
            ChromeOptions options = new ChromeOptions();
            options.addArguments("--remote-allow-origins=*");
            System.setProperty(values.getDriverKey(), values.getDriverValue());
            driver= new ChromeDriver(options);

        }
        else if ((browserName.equalsIgnoreCase("Firefox")))
        {
            System.setProperty(values.getDriverKey(), values.getDriverValue());
            driver = new FirefoxDriver();
        }
        else if (browserName.equalsIgnoreCase("Microsoft Edge"))
         {
            System.setProperty(values.getDriverKey(), values.getDriverValue());
            driver = new EdgeDriver();
         }


        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        return driver;
    }

    public String getScreenshot(String testCaseName, WebDriver driver) throws IOException {
        File source = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);

//        String filePathToSave =System.getProperty("user.dir") +"/" + testCaseName + ".png";
        String filePathToSave = "/job/amazon-framework-project/ws/";
        File file = new File(filePathToSave);
        FileUtils.copyFile(source, file);
        return filePathToSave;
    }

    @BeforeMethod
    public landingPage launchApplication() throws IOException {
        driver = initializeDriver();
        lp = new landingPage(driver);
        lp.getUrl(values.getUrl());
        return lp;
    }

    @AfterMethod
    public void closing()
    {
        driver.close();
    }



}




