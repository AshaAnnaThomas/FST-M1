package activities;

import dev.failsafe.internal.util.Assert;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class Activity17 {

    public static void main(String[] args) {

        WebDriverManager.firefoxdriver().setup();
        WebDriver driver = new FirefoxDriver();

        driver.get("https://training-support.net/selenium/selects");
        String pageTitle = driver.getTitle();
        System.out.println(pageTitle);

        Select select = new Select(driver.findElement(By.id("single-select")));

        select.selectByVisibleText("Option 2");
        String selectedOption = driver.findElement(By.xpath("//h3[contains(.,'You have selected: Option 2')]")).getText();

        Assert.isTrue(selectedOption.equals("You have selected: Option 2"), "", null);

        select.selectByIndex(3);
        selectedOption = driver.findElement(By.xpath("//h3[contains(.,'You have selected: Option 3')]")).getText();

        Assert.isTrue(selectedOption.equals("You have selected: Option 3"),"", null);

        select.selectByValue("4");

        selectedOption = driver.findElement(By.xpath("//h3[contains(.,'You have selected: Option 4')]")).getText();

        Assert.isTrue(selectedOption.equals("You have selected: Option 4"),"", null);

        List<WebElement> options = select.getOptions();

        for (WebElement ele: options){
            System.out.println(ele.getText());
        }

        driver.close();

    }
}
