package SeleniumProject;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Activity5 {

    WebDriver driver;

    @BeforeMethod
    public void setUp() {

        WebDriverManager.firefoxdriver().setup();
        driver = new FirefoxDriver();
        driver.get("https://alchemy.hguy.co/lms");
    }

    @Test
    public void verifyMyAccountTest() {

       driver.findElement(By.linkText("My Account")).click();
       String pageTitle = driver.getTitle();
       Assert.assertEquals(pageTitle, "My Account – Alchemy LMS");
    }

    @AfterMethod
    public void tearDown() {

        driver.close();
    }
}
