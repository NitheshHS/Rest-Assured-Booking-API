package cucumberTests.stepDefinition;

import com.google.common.net.MediaType;
import cucumberTests.util.Base;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.awt.*;
import java.time.Duration;
import java.util.Date;

/**
 * 1. Hook used for writing pre condition and post condition like browser launch, DB connect etc..
 * 2. Used to take screenshot and attach it to report
 */
/*
We can't extend hook to step definition
we can resolve this by using `cucumber pico container` dependency
 */
public class HookClass {
    Base base;
    public HookClass(Base base){
       this.base = base;
    }
    //execute before every scenario
    @Before
    public void setup(){
        base.driver = new ChromeDriver();
        base.driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

    //execute after every scenario
    @After
    public void tearDown(Scenario scenario){
        if(scenario.isFailed()){
            TakesScreenshot ts = (TakesScreenshot)base.driver;
            byte[] screenshot_bytes = ts.getScreenshotAs(OutputType.BYTES);
            String media_type = "image/png";
            String screenshot_name = scenario.getName() + new Date().getTime();
            scenario.attach(screenshot_bytes, media_type,screenshot_name);
        }
        if(base.driver!=null)
            base.driver.quit();
    }
}
