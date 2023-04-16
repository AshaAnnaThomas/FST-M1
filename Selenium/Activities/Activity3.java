package activities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Activity3 {
    public static void main(String[] args) {

        /**
         * //tagName[@attribute='value']
         */

        WebDriverManager.firefoxdriver().setup();
        WebDriver driver = new FirefoxDriver();

        clickonAboutUs(driver);
        submitTheLoginForm(driver);

        driver.close();

    }

    public static void clickonAboutUs(WebDriver driver) {
        driver.get("https://www.training-support.net/");

        String title = driver.getTitle();
        System.out.println("Title of the page is :" + title);

        driver.findElement(By.xpath("//a[@id='about-link']")).click();
        String newTitle = driver.getTitle();
        System.out.println("Title of the new page is : " + newTitle);
    }


    public static void submitTheLoginForm(WebDriver driver) {

        driver.get("https://www.training-support.net/selenium/login-form");

        String title = driver.getTitle();
        System.out.println("The title of the page is : "+ title);

        driver.findElement(By.xpath("//input[@id = 'username']")).sendKeys("admin");
        driver.findElement(By.xpath("//input[@id = 'password']")).sendKeys("password");
        driver.findElement(By.xpath("//button[text()='Log in']")).click();

    }
}
