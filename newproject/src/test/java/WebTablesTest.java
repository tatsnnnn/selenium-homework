import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;


public class WebTablesTest {
    WebDriver driver;

    @BeforeMethod
    public void dackeba() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }
    @Test
    public void hondasprice() {
        driver.get("https://techcanvass.com/Examples/webtable.html");
        WebElement honda = driver.findElement(By.xpath("//*[@id=\"t01\"]/tbody/tr[4]/td[3]"));
        System.out.println(honda);

    }
    @AfterMethod
    public void quit(){
        driver.quit();
    }
}
