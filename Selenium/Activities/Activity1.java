package activities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Activity1 {

    public static void main(String[] args) {

        //Set up the firefox driver
        WebDriverManager.firefoxdriver().setup();

        WebDriver driver = new FirefoxDriver();

        driver.get("https://www.training-support.net/");

        String title = driver.getTitle();
        System.out.println("The title of the page is : " + title);

        driver.findElement(By.id("about-link")).click();
        String newTitle = driver.getTitle();
        System.out.println("The title of the new page is: " + newTitle);

        driver.close();
    }
}
