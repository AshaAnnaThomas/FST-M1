package stepDefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.cucumber.java.en_scouse.An;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class AlertTestSteps {
    WebDriver driver;
    WebDriverWait wait;

    Alert alert;

    @Given("^User is on the page$")
    public void userIsOnThePage() {
        driver = new FirefoxDriver();
        wait = new WebDriverWait(driver, Duration.ofSeconds(15));

        driver.get("https://www.training-support.net/selenium/javascript-alerts");
    }

    @When("^User clicks the Simple Alert Button$")
    public void userClicksTheSimpleAlertButton() {
        driver.findElement(By.id("simple")).click();
    }

    @When("^User clicks the Confirm Alert Button$")
    public void userClicksTheConfirmAlertButton() {
        driver.findElement(By.id("confirm")).click();
    }

    @When(("^User clicks on the Prompt Alert Button$"))
    public void userClicksOnThePromptAlertButton() {
        driver.findElement(By.id("prompt")).click();
    }

    @Then("^Alert opens$")
    public void alertOpens() {
        alert = driver.switchTo().alert();
    }

    @And("^Read the text from it and print it$")
    public void readTheTextFromItAndPrintIt() {
        String text = alert.getText();
        System.out.println(text);
    }

    @And("^Write a \"([^\"]*)\" in it$")
    public void writeACustomMessageInIt(String successMsg) {
        alert.sendKeys(successMsg);
    }

    @And("^Close the Alert$")
    public void closeTheAlert() {
        alert.accept();
    }

    @And("^Close the Alert with Cancel$")
    public void closeTheAlertWithCancel() {
        alert.dismiss();
    }

//    @And("^Read the result text$")
//    public void readTheResultText() {
//        String text = driver.findElement(By.id("result")).getText();
//    }

    @And("^close browser$")
    public void closeBrowser() {
        driver.close();
    }
}
