package activities;

import com.fasterxml.jackson.annotation.JsonTypeInfo;
import dev.failsafe.internal.util.Assert;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Activity19 {
    public static void main(String[] args) {

        WebDriverManager.firefoxdriver().setup();
        WebDriver driver = new FirefoxDriver();

        driver.get("https://training-support.net/selenium/javascript-alerts");
        String pageTitle = driver.getTitle();
        System.out.println(pageTitle);

        driver.findElement(By.id("confirm")).click();

        Alert alert = driver.switchTo().alert();
        String alertText = alert.getText();
        System.out.println(alertText);

        Assert.isTrue(alertText.equals("This is a JavaScript Confirmation!"), "", null);


        alert.accept();

        driver.findElement(By.id("confirm")).click();

        alert = driver.switchTo().alert();
        alertText = alert.getText();
        System.out.println(alertText);

        Assert.isTrue(alertText.equals("This is a JavaScript Confirmation!"), "", null);


        alert.dismiss();

        driver.close();

    }
}
