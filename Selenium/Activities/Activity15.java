package activities;

import dev.failsafe.internal.util.Assert;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Activity15 {

    public static void main(String[] args) {

        WebDriverManager.firefoxdriver().setup();
        WebDriver driver = new FirefoxDriver();

        driver.get("https://training-support.net/selenium/dynamic-attributes");
        String pageTitle = driver.getTitle();
        System.out.println(pageTitle);

        driver.findElement(By.xpath("//input[starts-with(@class, 'username-')]")).sendKeys("admin");
        driver.findElement(By.xpath("//input[starts-with(@class, 'password-')]")).sendKeys("password");

        driver.findElement(By.xpath("//button[@type='submit']")).click();

        String successMessage = driver.findElement(By.id("action-confirmation")).getText();
        Assert.isTrue(successMessage.equals("Welcome Back, admin"), "", null);

        driver.close();
    }
}
