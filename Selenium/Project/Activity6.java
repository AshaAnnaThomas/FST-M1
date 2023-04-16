package SeleniumProject;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Activity6 {

    WebDriver driver;

    @BeforeMethod
    public void setUp() {

        WebDriverManager.firefoxdriver().setup();
        driver = new FirefoxDriver();
        driver.get("https://alchemy.hguy.co/lms");
    }

    @Test
    public void verifyLoginInMyAccountTest() {

        driver.findElement(By.linkText("My Account")).click();
        String pageTitle = driver.getTitle();
        Assert.assertEquals(pageTitle, "My Account – Alchemy LMS");

        driver.findElement(By.linkText("Login")).click();

        driver.findElement(By.id("user_login")).sendKeys("root");
        driver.findElement(By.id("user_pass")).sendKeys("pa$$w0rd");

        driver.findElement(By.name("wp-submit")).click();

        String textEle = driver.findElement(By.cssSelector(".ld-section-heading > h3")).getText();

        Assert.assertEquals(textEle, "Your Courses");
    }

    @AfterMethod
    public void tearDown() {

        driver.close();
    }
}
