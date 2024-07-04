package cucumberTests.stepDefinition;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;

public class SwagLoginTest {
    WebDriver driver;
    @Given("launch browser")
    public void launch_browser() {
         driver=new ChromeDriver();
    }
    @When("enter swag lab login page url {string}")
    public void enter_swag_lab_login_page_url(String url) {
        driver.get(url);
    }
    @When("login page is displayed enter username {string} and password {string} and click on login button")
    public void login_page_is_displayed_enter_username_and_password_and_click_on_login_button(String username, String password) {
        driver.findElement(By.id("user-name")).sendKeys(username);
        driver.findElement(By.id("password")).sendKeys(password);
        driver.findElement(By.id("login-button")).click();
    }
    @Then("verify home page url is {string}")
    public void verify_home_page_url_is(String expectedUrl) {
        String actualHomePageUrl = driver.getCurrentUrl();
        Assert.assertEquals(actualHomePageUrl, expectedUrl, "Home page url doesn't match");
        driver.close();
    }
}
