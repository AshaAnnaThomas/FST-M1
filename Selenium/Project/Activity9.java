package SeleniumProject;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import org.openqa.selenium.JavascriptExecutor;



import java.time.Duration;
import java.util.List;

public class Activity9 {

    WebDriver driver;

    @BeforeMethod
    public void setUp() {

        WebDriverManager.firefoxdriver().setup();
        driver = new FirefoxDriver();
        driver.get("https://alchemy.hguy.co/lms");
    }

    @Test
    public void verifyCompleteLessonTest() {

        driver.findElement(By.linkText("All Courses")).click();
        String pageTitle = driver.getTitle();

        Assert.assertEquals(pageTitle, "All Courses – Alchemy LMS");

        List<WebElement> links = driver.findElements(By.cssSelector(".entry-title"));

        Assert.assertEquals(links.get(0).getText(), "Social Media Marketing");

        driver.findElement(By.cssSelector("#post-69 .attachment-course-thumb")).click();

        String newTitle = driver.getTitle();
        Assert.assertEquals(newTitle, "Social Media Marketing – Alchemy LMS");

        int myTime = 10;
        Duration durationInSeconds = Duration.ofSeconds(myTime);

        WebElement ele = driver.findElement(By.cssSelector("#ld-expand-83 .ld-item-title"));
        Actions at = new Actions(driver);

        at.moveToElement(ele).click();


        if (driver.findElement(By.cssSelector(".ld-status")).getText() =="In Progress") {
            driver.findElement(By.xpath("xpath=(//input[@value='Mark Complete'])[2]")).click();
        } else if (driver.findElement(By.cssSelector(".ld-status")).getText() =="Complete") {
            driver.findElement(By.linkText("Next Lesson"));
        }

        System.out.println(driver.getTitle());


    }

    @AfterMethod
    public void tearDown() {

        driver.close();
    }

}
