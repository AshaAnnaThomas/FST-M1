package activities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Activity4 {

    public static void main(String[] args) {

        /**
         * //tagName[@attribute='value']
         */

        WebDriverManager.firefoxdriver().setup();
        WebDriver driver = new FirefoxDriver();

        driver.get("https://www.training-support.net/selenium/target-practice");

        String pageTitle = driver.getTitle();
        System.out.println("Page title is : " + pageTitle);

        String headerTxt = driver.findElement(By.xpath("//h3[@id='third-header']")).getText();
        System.out.println("third header is : " + headerTxt);

        String headerColor = driver.findElement(By.xpath("//h5[contains(., 'Fifth header')]")).getCssValue("color");
        System.out.println(headerColor);

        String classDetails = driver.findElement(By.xpath("//button[contains(., 'Violet')]")).getAttribute("class");
        System.out.println(classDetails);

        //xpath=//button[contains(.,'Grey')]
        String greyText = driver.findElement(By.xpath("//button[contains(.,'Grey')]")).getText();
        System.out.println(greyText);

        driver.close();
    }
}
