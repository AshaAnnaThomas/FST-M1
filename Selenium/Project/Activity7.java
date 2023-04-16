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

public class Activity7 {

    WebDriver driver;

    @BeforeMethod
    public void setUp() {

        WebDriverManager.firefoxdriver().setup();
        driver = new FirefoxDriver();
        driver.get("https://alchemy.hguy.co/lms");
    }

    @Test
    public void verifyAllCoursesTest() {

        driver.findElement(By.linkText("All Courses")).click();
        String pageTitle = driver.getTitle();

        Assert.assertEquals(pageTitle, "All Courses – Alchemy LMS");

        List<WebElement> links = driver.findElements(By.cssSelector(".entry-title"));

        Assert.assertEquals(links.size(), 3);

        Assert.assertEquals(links.get(0).getText(), "Social Media Marketing");
        Assert.assertEquals(links.get(1).getText(), "Email Marketing Strategies");
        Assert.assertEquals(links.get(2).getText(), "Content Marketing");
    }

    @AfterMethod
    public void tearDown() {

        driver.close();
    }
}
