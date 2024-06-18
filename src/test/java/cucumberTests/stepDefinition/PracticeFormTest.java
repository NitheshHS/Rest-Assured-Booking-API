package cucumberTests.stepDefinition;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.time.Duration;

public class PracticeFormTest {
    WebDriver driver;
    @Given("I want to launch {string} browser")
    public void i_want_to_launch_browser(String browserName) {
        if(browserName.equalsIgnoreCase("chrome"))
            driver = new ChromeDriver();
        else if(browserName.equalsIgnoreCase("firefox"))
            driver = new FirefoxDriver();
        else
            System.out.println("Enter valid browser name: "+browserName);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
    }
    @Given("enter the url {string}")
    public void enter_the_url(String url) {
        driver.get(url);
    }
    @When("enter firstname {string}, lastname {string} and email {string}")
    public void enter_firstname_lastname_and_email(String firstName, String lastName, String email) {
        driver.findElement(By.id("firstName")).sendKeys(firstName);
        driver.findElement(By.id("lastName")).sendKeys(lastName);
        driver.findElement(By.id("userEmail")).sendKeys(email);
    }
    @When("click on submit")
    public void click_on_submit() {
        driver.findElement(By.id("submit")).click();
    }
    @Then("validate form saved or not")
    public void validate_form_saved_or_not() {
        System.out.println("form sent!!");
    }
}
