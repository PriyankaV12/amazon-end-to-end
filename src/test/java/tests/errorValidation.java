package tests;

import mainTestComponents.BaseTest;
import mainTestComponents.retry;
import org.testng.Assert;
import org.testng.annotations.Test;
import pageObjects.errorVerify;

public class errorValidation extends BaseTest {

    public errorVerify ev;

    public errorValidation() throws Exception {
    }

    @Test(retryAnalyzer = retry.class)
    public void validation()
    {
        ev = new errorVerify(driver);
        String text = ev.TextVisible();
        Assert.assertTrue(text.equalsIgnoreCase(values.getDeliverText()));
    }
}
