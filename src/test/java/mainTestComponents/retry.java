package mainTestComponents;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class retry implements IRetryAnalyzer {


    int count = 0;
    int maxTry = 1;

    @Override
    public boolean retry(ITestResult iTestResult) {
        if(count<maxTry)
        {
            count++;
            return true;   // as long as this retry method returns true, this method will retry again and again. just like while loop.
        }

        return false;
    }
}
