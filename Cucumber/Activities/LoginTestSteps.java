package stepDefinitions;

import io.cucumber.java.bs.A;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class LoginTestSteps {

    WebDriver driver;
    WebDriverWait wait;

    @Given("^User is on the Login page$")
    public void userIsOnTheLoginPage() {
        driver = new FirefoxDriver();
        wait = new WebDriverWait(driver, Duration.ofSeconds(15));

        driver.get("https://www.training-support.net/selenium/login-form");
    }

    @When("^User enters Username and Password$")
    public void userEntersUsernameAndPassword() {
        driver.findElement(By.id("username")).sendKeys("admin");
        driver.findElement(By.id("password")).sendKeys("password");
        driver.findElement(By.xpath("//button[@type='submit']")).click();
    }

    @When("^User enters \"(.*)\" and \"(.*)\"$")
    public void userEntersUsernameAndPassword(String username, String password) {
        driver.findElement(By.id("username")).sendKeys(username);
        driver.findElement(By.id("password")).sendKeys(password);
        driver.findElement(By.xpath("//button[@type='submit']")).click();
    }

    @Then("^Read the page title and the confirmation message$")
    public void readThePageTitleAndTheConfirmationMessage() {
        String pageTitle = driver.getTitle();
        System.out.println("page title is :" + pageTitle);
        Assert.assertEquals(pageTitle, "Login Form");
        String successMsg = driver.findElement(By.id("action-confirmation")).getText();
        System.out.println("Login message is : " + successMsg);
        if (successMsg.contains("admin")) {
            Assert.assertEquals(successMsg, "Welcome Back, admin");
        } else {
            Assert.assertEquals(successMsg, "Invalid Credentials");
        }

    }

    @And("^Close browser$")
    public void closeBrowser() {
        driver.close();
    }
}
