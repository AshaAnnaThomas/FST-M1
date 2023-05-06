package activities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.SkipException;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Activity2 {

    WebDriver driver;

    @BeforeClass
    public void setUp() {
        WebDriverManager.firefoxdriver().setup();
        driver = new FirefoxDriver();

        driver.get("https://www.training-support.net/selenium/target-practice");
    }

    @Test
    public void getTitle() {
        String pageTitle = driver.getTitle();
        System.out.println(pageTitle);
    }

    @Test
    public void findElement() {

        String blackText = driver.findElement(By.xpath("//button[contains(text(), 'Black')]")).getText();
        Assert.assertEquals("grey", blackText);

    }

    @Test (enabled = false)
    public void skipTest() {
        System.out.println("This test case will be skipped");
    }

    @Test
    public void skipException(){
        throw new SkipException("this method will be skipped");
    }


    @AfterClass
    public void tearDown() {
        driver.close();
    }

}
