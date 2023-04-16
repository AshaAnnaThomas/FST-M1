package activities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Activity2 {

    public static void main(String[] args) {

        WebDriverManager.firefoxdriver().setup();

        WebDriver driver = new FirefoxDriver();

        driver.get("https://www.training-support.net/selenium/login-form");

        String pageTitle = driver.getTitle();
        System.out.println(pageTitle);

        driver.findElement(By.id("username")).sendKeys("admin");
        driver.findElement(By.id("password")).sendKeys("password");

        driver.findElement(By.xpath("//button[text()='Log in']")).click();

        String welcomeMsg = driver.findElement(By.id("action-confirmation")).getText();
        System.out.println("Welcome message is :" + welcomeMsg);

        driver.close();
    }
}
