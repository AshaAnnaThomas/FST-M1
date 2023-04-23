package activities;

import dev.failsafe.internal.util.Assert;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Activity20 {

    public static void main(String[] args) {

        WebDriverManager.firefoxdriver().setup();
        WebDriver driver = new FirefoxDriver();

        driver.get("https://training-support.net/selenium/javascript-alerts");
        String pageTitle = driver.getTitle();
        System.out.println(pageTitle);

        driver.findElement(By.id("prompt")).click();

        Alert alert = driver.switchTo().alert();

        String alertText = alert.getText();
        System.out.println(alertText);

        Assert.isTrue(alertText.equals("This is a JavaScript Prompt!"), "", null);

        alert.sendKeys("Awesome!");
        alert.accept();

        driver.close();

    }
}
