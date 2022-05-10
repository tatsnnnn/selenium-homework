import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;


public class Exceptions {
    WebDriver driver;

    @BeforeMethod
    public void dackeba() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    @Test
    public void davaleba1() {
        driver.get(" https://jqueryui.com/datepicker/ ");
        try {
            driver.switchTo().frame(driver.findElement(By.className("demo-frame")));
            WebElement datepicker = driver.findElement(By.xpath("//*[@id=\"datepicker\"]"));
            datepicker.click();
            WebElement winatve = driver.findElement(By.xpath("//*[@id=\"ui-datepicker-div\"]/div/a[1]"));
            winatve.click();
            List<WebElement> bolodge = driver.findElements(By.xpath("//table[@class='ui-datepicker-calendar']/tbody/tr[last()]/td"));

            for (int i = bolodge.size() - 1; i >= 0; i--) {
                if (bolodge.get(i).isEnabled()) {
                    bolodge.get(i).click();
                    System.out.println("dges aris :" + bolodge.get(i).getText());
                    break;
                }
            }
        } catch(NoSuchFrameException q){
                    System.out.println("avoid NoSuchFrameException ");
                    System.out.println(q.getMessage());
                }
            }

            @Test
    public void davaleba2(){
        driver.get("https://demoqa.com/alerts ");
        WebElement clickme = driver.findElement(By.xpath("//*[@id=\"timerAlertButton\"]"));
        clickme.click();
        try{
            driver.switchTo().alert().accept();
        }catch(NoAlertPresentException q){
            System.out.println("NoAlertPresentException");
        }
        try{
            new WebDriverWait(driver,1).until(ExpectedConditions.alertIsPresent());
        } catch (TimeoutException q){
            System.out.println("TimeOutException");
        }
        try{
            driver.get("https://demoqa.com/alerts");
            clickme.click();
        } catch(StaleElementReferenceException q){
            System.out.println("StaleElementReferenceException");
        }


    }

    @AfterMethod
    public void quit(){
        driver.quit();
    }


}
