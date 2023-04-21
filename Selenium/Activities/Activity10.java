package activities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Activity10 {

    public static void main(String[] args) {

        WebDriverManager.firefoxdriver().setup();
        WebDriver driver = new FirefoxDriver();

        driver.get("https://training-support.net/selenium/dynamic-controls");
        String pageTitle = driver.getTitle();
        System.out.println(pageTitle);

        boolean displayedValue = driver.findElement(By.id("dynamicCheckbox")).isDisplayed();
        System.out.println("The checkbox is displayed : " + displayedValue);

        driver.findElement(By.id("toggleCheckbox")).click();
        displayedValue = driver.findElement(By.id("dynamicCheckbox")).isDisplayed();
        System.out.println("The checkbox is displayed : " + displayedValue);

        driver.findElement(By.id("toggleCheckbox")).click();
        displayedValue = driver.findElement(By.id("dynamicCheckbox")).isDisplayed();
        System.out.println("The checkbox is displayed : " + displayedValue);

        driver.findElement(By.name("toggled")).click();

        driver.close();

    }
}
