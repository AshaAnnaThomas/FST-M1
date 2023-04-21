package activities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Activity12 {

    public static void main(String[] args) {

        WebDriverManager.firefoxdriver().setup();
        WebDriver driver = new FirefoxDriver();

        driver.get("https://training-support.net/selenium/dynamic-controls");
        String pageTitle = driver.getTitle();
        System.out.println(pageTitle);

        boolean value = driver.findElement(By.id("input-text")).isEnabled();
        System.out.println("Dynamic Text box is enabled : " + value);

        driver.findElement(By.id("toggleInput")).click();
        value = driver.findElement(By.id("input-text")).isEnabled();
        System.out.println("Dynamic Text box is enabled : " + value);

        driver.close();
    }
}
