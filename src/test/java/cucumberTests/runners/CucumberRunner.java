package cucumberTests.runners;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

//Runner class used to map feature file and step definitions and also used to generate reports
@CucumberOptions(
        features = {"src/test/java/cucumberTests/features"},
        glue = {"cucumberTests.stepDefinition"}
)
public class CucumberRunner extends AbstractTestNGCucumberTests {
}
