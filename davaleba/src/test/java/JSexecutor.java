import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;

import javax.swing.*;
import java.util.List;

public class JSexecutor {
    WebDriver driver;
    String url1, url2;
    JavascriptExecutor js;
    Actions action;
    public JSexecutor(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        js = (JavascriptExecutor) driver;
        action = new Actions(driver);
        url1 = "http://webdriveruniversity.com/To-Do-List/index.html ";
        url2 = "http://webdriveruniversity.com/Scrolling/index.html ";
        driver.manage().window().maximize();
    }
    @Test
    public void task1(){
        driver.get(url1);
        WebElement practiseButton = driver.findElement(By.xpath("//*[@id=\"container\"]/ul/li[text()=' Practice magic']"));
        action.moveToElement(practiseButton).perform();
        js.executeScript("arguments[0].remove();", practiseButton);

    }

    @Test
    public void task2(){
        driver.get(url2);
        WebElement box = driver.findElement(By.id("zone2-entries"));
        js.executeScript("arguments[0].scrollIntoView();",box );
        String text = js.executeScript("return document.getElementById('zone2-entries').innerHTML").toString();
        System.out.println("WText is : " + text);

    }

    @AfterClass
    public void afterClass(){
        driver.quit();
    }

}
