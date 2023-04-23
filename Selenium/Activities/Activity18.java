package activities;

import com.fasterxml.jackson.annotation.JsonTypeInfo;
import dev.failsafe.internal.util.Assert;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class Activity18 {
    public static void main(String[] args) {

        WebDriverManager.firefoxdriver().setup();
        WebDriver driver = new FirefoxDriver();

        driver.get("https://training-support.net/selenium/selects");
        String pageTitle = driver.getTitle();
        System.out.println(pageTitle);

        Select select = new Select(driver.findElement(By.id("multi-select")));
        select.selectByVisibleText("Javascript");


        String selectedValue = driver.findElement(By.id("multi-value")).getText();

        Assert.isTrue(selectedValue.equals("You have selected: Javascript"), "", null);

        for (int i = 4; i<7; i++) {
            select.selectByIndex(i);
        }

        selectedValue = driver.findElement(By.id("multi-value")).getText();

        Assert.isTrue(selectedValue.equals("You have selected: Ember, HTML, Information Architecture, Javascript"), "", null);

        select.selectByValue("node");
        selectedValue = driver.findElement(By.id("multi-value")).getText();

        Assert.isTrue(selectedValue.equals("You have selected: Ember, HTML, Information Architecture, Javascript, NodeJS"), "", null);

        select.deselectByIndex(4);

        List<WebElement> selectedoptions = select.getAllSelectedOptions();

        for (WebElement ele: selectedoptions) {
            System.out.println(ele.getText());
        }

        driver.close();

    }
}
