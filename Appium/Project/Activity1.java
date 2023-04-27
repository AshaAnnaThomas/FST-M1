package liveProject;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
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

public class Activity1 {

    AndroidDriver driver;
    WebDriverWait wait;

    @BeforeClass
    public void setUp() throws MalformedURLException {

        //desired capabilites
        UiAutomator2Options options = new UiAutomator2Options().
                setPlatformName("android").
                setAutomationName("UiAutomator2").
                setAppPackage("com.google.android.apps.tasks").
                setAppActivity(".ui.TaskListsActivity").
                noReset();
        //appium server url
        URL serverURL = new URL("http://localhost:4723/wd/hub");

        driver = new AndroidDriver(serverURL, options);
        wait = new WebDriverWait(driver, Duration.ofSeconds(20));

    }

    @Test
    public void addNewTask()  throws  Exception{

        //com.google.android.apps.tasks:id/tasks_fab
        WebElement plusButton = driver.findElement(AppiumBy.id("tasks_fab"));
        plusButton.click();

        //com.google.android.apps.tasks:id/add_task_title
        WebElement addTaskEle = driver.findElement(AppiumBy.xpath("//android.widget.EditText[contains(@resource-id, 'add_task_title')]"));

        addTaskEle.sendKeys("Complete Activity with Google Tasks");
        //com.google.android.apps.tasks:id/add_task_done
        WebElement saveBttn = driver.findElement(AppiumBy.id("add_task_done"));
        saveBttn.click();

        wait.until(ExpectedConditions.presenceOfElementLocated(AppiumBy.xpath("//android.widget.ImageButton[@content-desc='Create new task']")));
        driver.findElement(AppiumBy.xpath("//android.widget.ImageButton[@content-desc='Create new task']")).click();
        Thread.sleep(1000);

        driver.findElement(AppiumBy.xpath("//android.widget.EditText[contains(@resource-id, 'add_task_title')]")).sendKeys("Complete Activity with Google Keep");
        driver.findElement(AppiumBy.id("add_task_done")).click();
        Thread.sleep(1000);

        plusButton.click();
        //driver.findElement(AppiumBy.xpath("//android.widget.EditText[contains(@resource-id, 'add_task_title')]")).sendKeys("Complete the second Activity Google Keep");
        wait.until(ExpectedConditions.presenceOfElementLocated(AppiumBy.xpath("//android.widget.EditText[@text='New task']")));

        driver.findElement(AppiumBy.xpath("//android.widget.EditText[@text='New task']")).sendKeys("Complete the second Activity Google Keep");
        driver.findElement(AppiumBy.id("add_task_done")).click();

        //com.google.android.apps.tasks:id/tasks_list
        List<WebElement> tasks = driver.findElements(AppiumBy.xpath("//android.support.v7.widget.RecyclerView[@resource-id='com.google.android.apps.tasks:id/tasks_list']/android.widget.FrameLayout"));
        Assert.assertEquals(tasks.size(), 2);

    }


    @AfterClass
    public void tearDown() {
        driver.quit();
    }
}
