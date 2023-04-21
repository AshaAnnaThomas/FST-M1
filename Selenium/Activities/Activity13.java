package activities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class Activity13 {

    public static void main(String[] args) {

        WebDriverManager.firefoxdriver().setup();
        WebDriver driver = new FirefoxDriver();

        driver.get("https://training-support.net/selenium/tables");
        String pageTitle = driver.getTitle();
        System.out.println(pageTitle);

        //number of rows in a table: number of tr elements inside the tbody
        //number of columns in a table: number of th elements inside tr inside thead
        //Number of Columns in a table (alt): Number of <td> Elements inside the first <tr> inside <tbody>

        List<WebElement> rows = driver.findElements(By.xpath("//table[contains(@class, 'striped')]/tbody/tr"));
        System.out.println("number of rows: " + rows.size());

        List<WebElement> columns = driver.findElements(By.xpath("//table[contains(@class, 'striped')]/tbody/tr[1]/td"));
        System.out.println("number of columns: " + columns.size());

        List<WebElement> thirdRow = driver.findElements(By.xpath("//table[contains(@class, 'striped')]/tbody/tr[3]/td"));
        for (WebElement ele : thirdRow) {

            System.out.println(ele.getText());

        }

        WebElement secondRowSecCol = driver.findElement(By.xpath("//table[contains(@class, 'striped')]/tbody/tr[2]/td[2]"));
        System.out.println(secondRowSecCol.getText());

        driver.close();


    }
}
