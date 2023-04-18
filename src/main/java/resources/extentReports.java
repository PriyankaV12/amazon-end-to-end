package resources;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;


public class extentReports {

    public static ExtentReports reports()
    {

        String path = System.getProperty("user.dir");
        ExtentSparkReporter reporter = new ExtentSparkReporter(path);

        //set configurations of report
        reporter.config().setReportName("Amazon Landing page Testing");
        reporter.config().setDocumentTitle("Landing page");
//        reporter.config().setAutoCreateRelativePathMedia(true);

        ExtentReports extent = new ExtentReports();
        extent.attachReporter(reporter);
        extent.setSystemInfo("Testing", "Amazon Website");
        return extent;




    }
}
