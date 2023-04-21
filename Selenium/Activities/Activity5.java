package activities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;

import javax.swing.*;

public class Activity5 {

    public static void main(String[] args) {

        WebDriverManager.firefoxdriver().setup();
        WebDriver driver = new FirefoxDriver();

        driver.get("https://www.training-support.net/selenium/input-events");
        String pageTitle = driver.getTitle();
        System.out.println(pageTitle);

        Actions actions = new Actions(driver);
        actions.click().pause(500).build().perform();

        String text = driver.findElement(By.className("active")).getText();
        System.out.println(text);

        actions.doubleClick().pause(500).build().perform();
        text = driver.findElement(By.className("active")).getText();
        System.out.println(text);

        actions.contextClick().pause(500).build().perform();
        text = driver.findElement(By.className("active")).getText();
        System.out.println(text);

        driver.close();

    }
}
