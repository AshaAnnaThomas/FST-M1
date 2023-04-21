package activities;

import dev.failsafe.internal.util.Assert;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Activity8 {
    public static void main(String[] args) {

        WebDriverManager.firefoxdriver().setup();
        WebDriver driver = new FirefoxDriver();

        driver.get("https://www.training-support.net/selenium/dynamic-controls");
        String pageTitle = driver.getTitle();
        System.out.println(pageTitle);

        driver.findElement(By.id("toggleCheckbox")).click();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.id("dynamicCheckbox")));

        System.out.println("Dynamic Checkbox is displayed : " + driver.findElement(By.id("dynamicCheckbox")).isDisplayed());

        Assert.isTrue(driver.findElement(By.id("dynamicCheckbox")).isDisplayed()==false, "", null);

        driver.findElement(By.id("toggleCheckbox")).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("dynamicCheckbox")));

        System.out.println("Dynamic Checkbox is displayed : " + driver.findElement(By.id("dynamicCheckbox")).isDisplayed());
        Assert.isTrue(driver.findElement(By.id("dynamicCheckbox")).isDisplayed()==true, "", null);

        driver.close();
    }
}
