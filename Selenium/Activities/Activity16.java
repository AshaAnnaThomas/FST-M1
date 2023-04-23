package activities;

import dev.failsafe.internal.util.Assert;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Activity16 {

    public static void main(String[] args) {

        WebDriverManager.firefoxdriver().setup();
        WebDriver driver = new FirefoxDriver();

        driver.get("https://training-support.net/selenium/dynamic-attributes");
        String pageTitle = driver.getTitle();
        System.out.println(pageTitle);

        driver.findElement(By.xpath("//input[contains(@class, '-username')]")).sendKeys("asha");
        driver.findElement(By.xpath("//input[contains(@class, '-password')]")).sendKeys("password");

        driver.findElement(By.xpath("//label[text()='Confirm Password']/following-sibling::input")).sendKeys("password");
        driver.findElement(By.xpath("//label[text()='Email']/following-sibling::input")).sendKeys("test@example.com");

        driver.findElement(By.xpath("//button[contains(.,'Sign Up')]")).click();

        String successMessage = driver.findElement(By.id("action-confirmation")).getText();
        Assert.isTrue(successMessage.equals("Thank you for registering, asha"), "", null);

        driver.close();
    }
}
