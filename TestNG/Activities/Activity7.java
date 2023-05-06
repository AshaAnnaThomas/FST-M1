package activities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class Activity7 {
    WebDriver driver;

    @BeforeClass
    public void setUp() {
        WebDriverManager.firefoxdriver().setup();
        driver = new FirefoxDriver();

        driver.get("https://www.training-support.net/selenium/login-form");
    }

    @DataProvider (name = "Authentication")
    public static Object[][] credentials() {
        return new Object[][] {
                {"admin", "password"}
        };
    }

    @Test (dataProvider = "Authentication")
    public void loginTest(String username, String password) {
        driver.findElement(By.id("username")).sendKeys(username);
        driver.findElement(By.id("password")).sendKeys(password);
        driver.findElement(By.xpath("//button[@type='submit']")).click();

        String successMsg = driver.findElement(By.id("action-confirmation")).getText();
        Assert.assertEquals(successMsg, "Welcome Back, admin");
    }



    @AfterClass
    public void tearDown() {
        driver.close();
    }

}
