package SeleniumProject;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;

public class Activity8 {

    WebDriver driver;

    @BeforeMethod
    public void setUp() {

        WebDriverManager.firefoxdriver().setup();
        driver = new FirefoxDriver();
        driver.get("https://alchemy.hguy.co/lms");
    }

    @Test
    public void verifyContactAdminTest() {

        driver.findElement(By.linkText("Contact")).click();

        driver.findElement(By.id("wpforms-8-field_0")).sendKeys("Asha Anna Thomas");
        driver.findElement(By.id("wpforms-8-field_1")).sendKeys("ashaanna88@gmail.com");
        driver.findElement(By.id("wpforms-8-field_2")).sendKeys("Test Message for Automation");

        driver.findElement(By.name("wpforms[submit]")).click();

        String message = driver.findElement(By.id("wpforms-confirmation-8")).getText();

        Assert.assertEquals(message, "Thanks for contacting us! We will be in touch with you shortly.");

    }

    @AfterMethod
    public void tearDown() {

        driver.close();
    }

}
