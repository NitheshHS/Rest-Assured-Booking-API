package cucumberTests.runners;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

//Runner class used to map feature file and step definitions and also used to generate reports
@CucumberOptions(
        features = {
                //"src/test/java/cucumberTests/features"
                "src/test/java/cucumberTests/features/SwagLabLogin.feature"
        },//feature file path
        glue = {"cucumberTests.stepDefinition","cucumberTests.stepDefinition.HookClass"},//package name
        dryRun = false,
        monochrome = true,
        plugin = {"pretty",
        "html:Report.html"},
        tags = "@SmokeTest or @Regression"
)
public class CucumberRunner extends AbstractTestNGCucumberTests {
}
