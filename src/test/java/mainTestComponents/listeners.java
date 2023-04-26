package mainTestComponents;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import resources.extentReports;
import java.io.IOException;

public class listeners extends BaseTest implements ITestListener
{
    ExtentTest test;
    ExtentReports extent = extentReports.reports();     //reports method of extent reports class has been called
    // make the tests thread safe in case of parallel execution
    ThreadLocal<ExtentTest> thread = new ThreadLocal<ExtentTest>();

    public listeners() throws Exception {
    }

    @Override
    public void onTestStart(ITestResult result) {

        test = extent.createTest(result.getMethod().getMethodName());

        //to assign unique id to the tests
        thread.set(test);
        test.info(MarkupHelper.createLabel("Extent", ExtentColor.BLUE));
        test.info(String.valueOf(result.getTestClass().getRealClass()));
        test.info(result.getInstanceName());




    }

    @Override
    public void onTestSuccess(ITestResult result) {
       thread.get().log(Status.PASS, "Test Passed.");
    }

    @Override
    public void onTestFailure(ITestResult result)
    {
        thread.get().fail(result.getThrowable());

        try
        {
           driver = (WebDriver) result.getTestClass().getRealClass().getField("driver").get(result.getInstance());
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }

        // screenshot code

        String filePath = null;
        try {
            filePath = getScreenshot(result.getMethod().getMethodName(), driver);
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println(filePath);

        thread.get().addScreenCaptureFromPath(filePath, result.getMethod().getMethodName());


    }

    @Override
    public void onTestSkipped(ITestResult result) {

    }

    @Override
    public void onTestFailedButWithinSuccessPercentage(ITestResult result) {

    }

    @Override
    public void onTestFailedWithTimeout(ITestResult result) {

    }

    @Override
    public void onStart(ITestContext context) {

    }

    @Override
    public void onFinish(ITestContext context) {
        extent.flush();
    }
}
