package liveProject;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.util.List;

import static examples.ActionsBase.doSwipe;

public class Activity3 {

    WebDriverWait wait;
    AndroidDriver driver;

    @BeforeClass
    public void setUp() throws MalformedURLException {

        //desired capabilites
        UiAutomator2Options options = new UiAutomator2Options().
                setPlatformName("android").
                setAutomationName("UiAutomator2").
                setAppPackage("com.android.chrome").
                setAppActivity("com.google.android.apps.chrome.Main").
                noReset();
        //appium server url
        URL serverURL = new URL("http://localhost:4723/wd/hub");

        driver = new AndroidDriver(serverURL, options);
        wait = new WebDriverWait(driver, Duration.ofSeconds(20));

        driver.get("https://www.training-support.net/selenium");
    }

    @Test
    public void swipeTest() {

        //Get the dimensions of the screen
        Dimension dimension = driver.manage().window().getSize();
        //Wait for the page to load
        wait.until(ExpectedConditions.presenceOfElementLocated(AppiumBy.xpath("//android.view.View")));
        //scroll
        Point start = new Point((int) (dimension.width*0.5), (int) (dimension.height*0.9));
        Point end = new Point((int)(dimension.width*0.5), (int)(dimension.height*0.6));

        doSwipe(driver, start, end, 100);

        //android.view.View[@content-desc="To-Do List  Elements get added at run time"]//android.view.View[@content-desc="To-Do List  Elements get added at run time"]
        wait.until(ExpectedConditions.elementToBeClickable(
                AppiumBy.xpath("//android.widget.TextView[contains(@text, 'To-Do List')]"))
        ).click();


        wait.until(ExpectedConditions.elementToBeClickable(
                AppiumBy.xpath("//android.widget.EditText[@resource-id='taskInput']"))
        );

        WebElement addTaskInput = driver.findElement(AppiumBy.xpath("//android.widget.EditText[@resource-id='taskInput']"));
        WebElement addTaskButton = driver.findElement(AppiumBy.xpath("//android.widget.Button[@text='Add Task']"));

        addTaskInput.sendKeys("Add tasks to list");
        addTaskButton.click();
        addTaskInput.sendKeys("Get number of tasks");
        addTaskButton.click();
        addTaskInput.sendKeys("Clear the list");
        addTaskButton.click();

        List<WebElement> options = driver.findElements(AppiumBy.xpath("//android.view.View[@resource-id='tasksList']/android.view.View"));
        Assert.assertEquals(options.size(), 4);

        driver.findElement(AppiumBy.xpath("//android.widget.TextView[@text='Add tasks to list']")).click();
        driver.findElement(AppiumBy.xpath("//android.widget.TextView[@text='Get number of tasks']")).click();
        driver.findElement(AppiumBy.xpath("//android.widget.TextView[@text='Clear the list']")).click();


        //clear the list
        driver.findElement(AppiumBy.xpath("//android.widget.TextView[contains(@text, 'Clear List')]")).click();


        options = driver.findElements(AppiumBy.xpath("//android.view.View[@resource-id='tasksList']/android.view.View"));
        Assert.assertEquals(options.size(), 0);
    }

    @AfterClass
    public void tearDown(){
        driver.quit();
    }

}
