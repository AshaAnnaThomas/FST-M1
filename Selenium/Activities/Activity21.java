package activities;

import dev.failsafe.internal.util.Assert;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.Set;

public class Activity21 {

    public static void main(String[] args) {

        WebDriverManager.firefoxdriver().setup();
        WebDriver driver = new FirefoxDriver();

        driver.get("https://www.training-support.net/selenium/tab-opener");
        String pageTitle = driver.getTitle();
        System.out.println(pageTitle);

        String parentHandle = driver.getWindowHandle();
        System.out.println(parentHandle);

        driver.findElement(By.id("launcher")).click();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        wait.until(ExpectedConditions.numberOfWindowsToBe(2));

        System.out.println(driver.getWindowHandles());

        Set<String> handles = driver.getWindowHandles();

        String secondWindowHandle = "";

        for (String handle : handles) {
            if (handle != parentHandle) {
                driver.switchTo().window(handle);
                secondWindowHandle = driver.getWindowHandle();
            }
        }

        String secondPageTitle = driver.getTitle();
        System.out.println(secondPageTitle);
        Assert.isTrue(secondPageTitle.equals("Newtab"), "", null);

        wait.until(ExpectedConditions.elementToBeClickable(By.id("actionButton")));

        String secondPageHeading = driver.findElement(By.className("content")).getText();
        System.out.println(secondPageHeading);

        driver.findElement(By.id("actionButton")).click();

        wait.until(ExpectedConditions.numberOfWindowsToBe(3));

        handles = driver.getWindowHandles();

        for (String handle : handles) {
            if (handle != parentHandle && handle != secondWindowHandle) {
                driver.switchTo().window(handle);
            }
        }

        String thirdPageTitle = driver.getTitle();
        System.out.println(thirdPageTitle);
        Assert.isTrue(thirdPageTitle.equals("Newtab2"), "", null);

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("content")));

        String thirdPageHeading = driver.findElement(By.className("content")).getText();
        System.out.println(thirdPageHeading);

        driver.quit();

    }
}
