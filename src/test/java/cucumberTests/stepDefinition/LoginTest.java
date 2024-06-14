package cucumberTests.stepDefinition;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.safari.SafariDriver;

import java.time.Duration;

public class LoginTest {
    WebDriver driver;

    @Given("As a user I want launch browser")
    public void as_a_user_i_want_launch_browser() {
        driver=new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
    }

    @Given("Enter the url")
    public void enter_the_url() {
        driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
    }
    @When("login page is displayed enter username and password")
    public void login_page_is_displayed_enter_username_and_password() {
        driver.findElement(By.name("username")).sendKeys("Admin");//hardcode
        driver.findElement(By.name("password")).sendKeys("admin123");//hardcode
    }
    @When("click on login button")
    public void click_on_login_button() {
        driver.findElement(By.xpath("//button[text()=' Login ']")).click();
    }
    @Then("verify Home page is displayed")
    public void verify_home_page_is_displayed() {
        System.out.println(driver.getTitle());
        driver.close();
    }

    @Given("As a user I want launch {string} browser")
    public void as_a_user_i_want_launch_browser(String browserName) {
        if(browserName.equalsIgnoreCase("chrome")){
            driver = new ChromeDriver();
        }
        else if(browserName.equalsIgnoreCase("safari")){
            driver = new SafariDriver();
        }
        else{
            throw new RuntimeException("Provide valid browser name, current browser name "+browserName);
        }
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }
    @Given("Enter the url {string}")
    public void enter_the_url(String url) {
        driver.get(url);
    }
    @When("login page is displayed enter username {string} and password {string}")
    public void login_page_is_displayed_enter_username_and_password(String username, String password) {
        driver.findElement(By.name("username")).sendKeys(username);
        driver.findElement(By.name("password")).sendKeys(password);
    }

    @Then("send number {int}")
    public void send_number(Integer number) {
        System.out.println("the number in step is "+number);
    }
}
