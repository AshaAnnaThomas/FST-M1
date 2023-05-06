package activities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Activity9 {

    WebDriver driver;

    @BeforeTest
    public void setUp() {
        WebDriverManager.firefoxdriver().setup();
        driver = new FirefoxDriver();

        driver.get("https://www.training-support.net/selenium/javascript-alerts");

        Reporter.log("Opened the page");

    }

    @BeforeMethod
    public void switchToDefault() {
        driver.switchTo().defaultContent();

    }

    @Test
    public void simpleAlertTest() {
        driver.findElement(By.id("simple")).click();
        Reporter.log("Simple alert is open now");
        Alert alert = driver.switchTo().alert();
        String text = alert.getText();
        System.out.println(text);

        Assert.assertEquals(text, "This is a JavaScript Alert!");

        alert.accept();
        Reporter.log("Alert accepted");

    }

    @Test
    public void confirmAlertTest() {
        driver.findElement(By.id("confirm")).click();

        Alert alert = driver.switchTo().alert();
        String text = alert.getText();
        System.out.println(text);
        Assert.assertEquals(text, "This is a JavaScript Confirmation!");

        alert.accept();
    }


    @Test
    public void promptAlertTest() {
        driver.findElement(By.id("prompt")).click();

        Alert alert = driver.switchTo().alert();
        String text = alert.getText();
        System.out.println(text);

        Assert.assertEquals(text, "This is a JavaScript Prompt!");

        alert.sendKeys("This is a sample text");
        alert.accept();

    }


    @AfterTest
    public void tearDown() {
        driver.close();
    }

}
