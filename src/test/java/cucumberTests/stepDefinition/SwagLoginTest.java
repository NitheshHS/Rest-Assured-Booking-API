package cucumberTests.stepDefinition;

import com.fasterxml.jackson.databind.deser.Deserializers;
import cucumberTests.util.Base;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;

import java.util.List;

public class SwagLoginTest {
    Base base;
    public SwagLoginTest(Base base){
       this.base = base;
    }

//    @Given("launch browser")
//    public void launch_browser() {
//        driver = new ChromeDriver();
//    }

    @When("enter swag lab login page url {string}")
    public void enter_swag_lab_login_page_url(String url) {
        base.driver.get(url);
    }

    @When("login page is displayed enter username {string} and password {string} and click on login button")
    public void login_page_is_displayed_enter_username_and_password_and_click_on_login_button(String username, String password) {
        base.driver.findElement(By.id("user-name")).sendKeys(username);
        base.driver.findElement(By.id("password")).sendKeys(password);
        base.driver.findElement(By.id("login-button")).click();
    }

    @Then("verify home page url is {string}")
    public void verify_home_page_url_is(String expectedUrl) {
        String actualHomePageUrl = base.driver.getCurrentUrl();
        Assert.assertEquals(actualHomePageUrl, expectedUrl, "Home page url doesn't match");
        base.driver.close();
    }

    @When("login page is displayed enter username and password and click on login")
    public void login_page_is_displayed_enter_username_and_password_and_click_on_login(io.cucumber.datatable.DataTable dataTable) {
        List<List<String>> userData = dataTable.asLists(String.class);
        String username = userData.get(0).get(0);//(0,0)->standard_user
        String password = userData.get(0).get(1);//(0,1)->secret_sauce
        base.driver.findElement(By.id("user-name")).sendKeys(username);
        base.driver.findElement(By.id("password")).sendKeys(password);
        base.driver.findElement(By.id("login-button")).click();
    }
}
