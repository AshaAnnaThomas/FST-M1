package activities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Activity11 {

    public static void main(String[] args) {

        WebDriverManager.firefoxdriver().setup();
        WebDriver driver = new FirefoxDriver();

        driver.get("https://training-support.net/selenium/dynamic-controls");
        String pageTitle = driver.getTitle();
        System.out.println(pageTitle);

        driver.findElement(By.name("toggled")).click();
        boolean value = driver.findElement(By.name("toggled")).isSelected();
        System.out.println("The checkbox is now selected : " + value);

        driver.findElement(By.name("toggled")).click();
        value = driver.findElement(By.name("toggled")).isSelected();
        System.out.println("The checkbox is now selected : " + value);

        driver.close();
    }
}
