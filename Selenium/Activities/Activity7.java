package activities;

import dev.failsafe.internal.util.Assert;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;

public class Activity7 {

    public static void main(String[] args) {

        WebDriverManager.firefoxdriver().setup();
        WebDriver driver = new FirefoxDriver();

        driver.get("https://training-support.net/selenium/drag-drop");
        String pageTitle = driver.getTitle();
        System.out.println(pageTitle);

        WebElement ball = driver.findElement(By.id("draggable"));
        WebElement dropZone1 = driver.findElement(By.id("droppable"));
        WebElement dropZone2 = driver.findElement(By.id("dropzone2"));

        Actions actions = new Actions(driver);
        actions.clickAndHold(ball).moveToElement(dropZone1).pause(1000).release().build().perform();

        System.out.println(dropZone1.getText());

        Assert.isTrue(dropZone1.getText().contains("Dropped!"),"", null);

        actions.dragAndDrop(dropZone1, dropZone2).build().perform();
        System.out.println(dropZone2.getText());

        Assert.isTrue(dropZone2.getText().contains("Dropped!"),"",null);

        driver.close();


    }
}
