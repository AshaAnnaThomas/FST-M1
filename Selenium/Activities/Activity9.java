package activities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Activity9 {

    public static void main(String[] args) {

        WebDriverManager.firefoxdriver().setup();
        WebDriver driver = new FirefoxDriver();

        driver.get("https://training-support.net/selenium/ajax");
        String pageTitle = driver.getTitle();
        System.out.println(pageTitle);

        driver.findElement(By.cssSelector(".violet")).click();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h1[contains(.,'HELLO!')]")));

        System.out.println(driver.findElement(By.xpath("//h1[contains(.,'HELLO!')]")).getText());

        wait.until(ExpectedConditions.textToBePresentInElementLocated(By.xpath("//h3"), "I'm late!"));

        System.out.println(driver.findElement(By.xpath("//h3")).getText());

        driver.close();

    }
}
