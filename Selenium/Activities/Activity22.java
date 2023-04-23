package activities;

import dev.failsafe.internal.util.Assert;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;

public class Activity22 {

    public static void main(String[] args) {

        WebDriverManager.firefoxdriver().setup();
        WebDriver driver = new FirefoxDriver();

        driver.get("https://www.training-support.net/selenium/popups");
        String pageTitle = driver.getTitle();
        System.out.println(pageTitle);

        Actions actions = new Actions(driver);

        WebElement signinButton = driver.findElement(By.className("orange"));
        actions.moveToElement(signinButton).build().perform();

        String tooltipMsg = signinButton.getAttribute("data-tooltip");
        System.out.println(tooltipMsg);

        signinButton.click();
        driver.findElement(By.id("username")).sendKeys("admin");
        driver.findElement(By.id("password")).sendKeys("password");

        String successMessage = driver.findElement(By.id("action-confirmation")).getText();

        driver.close();

    }
}
