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



        //driver.findElement(By.cssSelector("#ld-course-list-item-69 > div:nth-child(1) > a:nth-child(1) > span:nth-child(2)")).click();

        driver.findElement(By.cssSelector("#ld-course-list-item-69 .ld-course-title")).click();

        String socialMediaMarketingTitle = driver.getTitle();

        System.out.println(socialMediaMarketingTitle);

        Assert.assertEquals(socialMediaMarketingTitle, "Social Media Marketing – Alchemy LMS");

        driver.findElement(By.cssSelector("#ld-expand-83 .ld-item-title")).click();

        String getCurrentUrl = driver.getCurrentUrl();

        Assert.assertEquals(getCurrentUrl, "https://alchemy.hguy.co/lms/lessons/developing-strategy/");

        boolean value = false;

        System.out.println(driver.findElement(By.cssSelector(".ld-status")).getText());

        String progressReader = driver.findElement(By.cssSelector(".ld-status")).getText();



        if(progressReader.equals("IN PROGRESS")) {
            driver.findElement(By.xpath("//input[@value='Mark Complete'])[2]").click();
            value = true;
            driver.findElement(By.cssSelector(".ld-content-action:nth-child(3) .ld-text")).click();
            //driver.findElement(By.linkText("Next Lesson"));
        } else if(progressReader.equals("COMPLETE")) {
            value = true;
            driver.findElement(By.cssSelector(".ld-content-action:nth-child(3) .ld-text")).click();

        }

        System.out.println("Value of boolean value is :" + value);

        //Once Completed, it moves to Monitoring & Digital Advertising – Alchemy LMS
        Assert.assertEquals(driver.getTitle(), "Monitoring & Digital Advertising – Alchemy LMS");

        Assert.assertEquals(driver.getCurrentUrl(), "https://alchemy.hguy.co/lms/lessons/monitoring-digital-advertising/");

    }

    @AfterMethod
    public void tearDown() {

        driver.close();
    }
}
