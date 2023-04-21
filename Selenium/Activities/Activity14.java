package activities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.List;

public class Activity14 {

    public static void main(String[] args) {

        WebDriverManager.firefoxdriver().setup();
        WebDriver driver = new FirefoxDriver();

        driver.get("https://training-support.net/selenium/tables");
        String pageTitle = driver.getTitle();
        System.out.println(pageTitle);

        //number of rows
        List<WebElement> rows = driver.findElements(By.xpath("//table[contains(@id, 'sortableTable')]/tbody/tr"));
        System.out.println("number of rows : " + rows.size());

        //number of columns
        List<WebElement> columns = driver.findElements(By.xpath("//table[contains(@id, 'sortableTable')]/tbody/tr[1]/td"));
        System.out.println("number of columns : " + columns.size());

        WebElement secondRowSecCol = driver.findElement(By.xpath("//table[contains(@id, 'sortableTable')]/tbody/tr[2]/td[2]"));
        System.out.println("second row second column is : " + secondRowSecCol.getText());

        driver.findElement(By.xpath("//table[contains(@id, 'sortableTable')]/thead/tr/th")).click();
        secondRowSecCol = driver.findElement(By.xpath("//table[contains(@id, 'sortableTable')]/tbody/tr[2]/td[2]"));
        System.out.println("second row second column after sorting is : " + secondRowSecCol.getText());

        List<WebElement> footerEle = driver.findElements(By.xpath("//table[contains(@id, 'sortableTable')]/tfoot/tr/th"));
        for ( WebElement ele : footerEle) {
            System.out.println(ele.getText());
        }

        driver.close();
    }
}
