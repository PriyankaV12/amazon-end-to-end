package cucumber;


import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;




@CucumberOptions(features = "/Users/priyankaverma/amazonFramework/src/test/java/cucumber",
glue = "stepDefinition",
monochrome = true,
plugin = {"html:target/cucumberFiles.html"})
public class TestRunner extends AbstractTestNGCucumberTests {

}




