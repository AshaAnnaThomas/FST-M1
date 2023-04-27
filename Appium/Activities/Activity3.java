package activities;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;

public class Activity3 {

    AppiumDriver driver;

    @BeforeClass
    public void setUp() throws MalformedURLException {

        //desired capabilites
        UiAutomator2Options options = new UiAutomator2Options().
                setPlatformName("android").
                setAutomationName("UiAutomator2").
                setAppPackage("com.google.android.calculator").
                setAppActivity("com.android.calculator2.Calculator").
                noReset();
        //appium server url
        URL serverURL = new URL("http://localhost:4723/wd/hub");

        driver = new AndroidDriver(serverURL, options);

    }

    @Test
    public void addTest() {
        //com.google.android.calculator:id/digit_5
        driver.findElement(AppiumBy.id("digit_5")).click();
        //com.google.android.calculator:id/op_add
        driver.findElement(AppiumBy.id("op_add")).click();
        //com.google.android.calculator:id/digit_9
        driver.findElement(AppiumBy.id("digit_9")).click();
        //com.google.android.calculator:id/eq
        driver.findElement(By.id("eq")).click();
        //com.google.android.calculator:id/result_final
        String result = driver.findElement(AppiumBy.id("result_final")).getText();
        System.out.println("5 + 9 = " + result);

        Assert.assertEquals(result, "14");
    }

    @Test
    public void subtractTest() {

        //com.google.android.calculator:id/digit_1
        driver.findElement(AppiumBy.id("digit_1")).click();
        //com.google.android.calculator:id/digit_0
        driver.findElement(AppiumBy.id("digit_0")).click();
        //com.google.android.calculator:id/op_sub
        driver.findElement(AppiumBy.id("op_sub")).click();
        //com.google.android.calculator:id/digit_5
        driver.findElement(AppiumBy.id("digit_5")).click();
        //com.google.android.calculator:id/eq
        driver.findElement(By.id("eq")).click();
        //com.google.android.calculator:id/result_final
        String result = driver.findElement(AppiumBy.id("result_final")).getText();
        System.out.println(result);

        Assert.assertEquals(result, "5");
    }

    @Test
    public void multiplyTest() {

        //com.google.android.calculator:id/digit_5
        driver.findElement(AppiumBy.id("digit_5")).click();
        //com.google.android.calculator:id/op_mul
        driver.findElement(AppiumBy.id("op_mul")).click();
        //com.google.android.calculator:id/digit_1
        driver.findElement(AppiumBy.id("digit_1")).click();
        //com.google.android.calculator:id/digit_0
        driver.findElement(AppiumBy.id("digit_0")).click();
        //com.google.android.calculator:id/digit_0
        driver.findElement(AppiumBy.id("digit_0")).click();
        //com.google.android.calculator:id/eq
        driver.findElement(By.id("eq")).click();
        //com.google.android.calculator:id/result_final
        String result = driver.findElement(AppiumBy.id("result_final")).getText();
        System.out.println(result);

        Assert.assertEquals(result, "500");

    }

    @Test
    public void divideTest() {

        //com.google.android.calculator:id/digit_5
        driver.findElement(AppiumBy.id("digit_5")).click();
        //com.google.android.calculator:id/digit_0
        driver.findElement(AppiumBy.id("digit_0")).click();
        //com.google.android.calculator:id/op_div
        driver.findElement(AppiumBy.id("op_div")).click();
        //com.google.android.calculator:id/digit_2
        driver.findElement(AppiumBy.id("digit_2")).click();
        //com.google.android.calculator:id/eq
        driver.findElement(By.id("eq")).click();
        //com.google.android.calculator:id/result_final
        String result = driver.findElement(AppiumBy.id("result_final")).getText();
        System.out.println(result);

        Assert.assertEquals(result, "25");

    }




    @AfterClass
    public void tearDown(){
        driver.quit();
    }


}
