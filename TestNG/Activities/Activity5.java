package activities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.checkerframework.dataflow.qual.TerminatesExecution;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Activity5 {

    WebDriver driver;

    @BeforeClass
    public void setUp() {
        WebDriverManager.firefoxdriver().setup();
        driver = new FirefoxDriver();

        driver.get("https://www.training-support.net/selenium/target-practice");
    }

    @Test
    public void pageTitleTest() {
        String pageTitle = driver.getTitle();
        System.out.println(pageTitle);
        Assert.assertEquals(pageTitle, "Target Practice");
    }

    @Test (groups = { "HeaderTests"})
    public void thirdHeaderTest() {

        String headerText = driver.findElement(By.id("third-header")).getText();
        System.out.println(headerText);
        Assert.assertEquals(headerText, "Third header");

    }

    @Test (groups = { "HeaderTests"})
    public void colorFifthHeader() {

        String color = driver.findElement(By.xpath("//h5[contains(text(), 'Fifth header')]")).getCssValue("color");
        System.out.println(color);
        Assert.assertEquals(color, "rgb(33, 186, 69)");
    }

    @Test (groups = { "ButtonTests"})
    public void buttonOlive() {
        String buttonText = driver.findElement(By.cssSelector(".olive.button")).getText();
        Assert.assertEquals(buttonText, "Olive");

    }

    @Test (groups = { "ButtonTests"})
    public void buttonBrown() {
        String color = driver.findElement(By.cssSelector(".brown.button")).getCssValue("color");
        System.out.println(color);
        Assert.assertEquals(color, "rgb(255, 255, 255)");
    }



    @AfterClass
    public void tearDown() {
        driver.close();
    }

}
