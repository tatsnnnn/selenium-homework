import java.util.concurrent.TimeUnit;

import com.gargoylesoftware.htmlunit.BrowserVersion;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.jetbrains.annotations.NotNull;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class CrossTest {
    WebDriver driver;

    @BeforeTest
    @Parameters("browser")
    public void setup(String browser) throws Exception {

        if (browser.equalsIgnoreCase("chrome")) {
            System.setProperty("webdriver.chrome.driver", "C:\\Users\\Tato\\OneDrive\\Desktop\\selenium-homework\\SeleniumHomeWork\\src\\main\\resources\\chromedriver.exe");
            WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver();
        } else if (browser.equalsIgnoreCase("Edge")) {

            driver = new HtmlUnitDriver(BrowserVersion.FIREFOX, true);
        } else {
            throw new Exception("Browser is not correct");
        }
    }

    @Test
    public void toDo() {
        driver.get("http://webdriveruniversity.com/To-Do-List/index.html");
        driver.manage().window().maximize();
        JavascriptExecutor js = (JavascriptExecutor) driver;
        Actions builder = new Actions(driver);
        builder.moveToElement(driver.findElement(By.xpath("//*[contains(text(),'Practice magic')]"))).perform();
        js.executeScript("arguments[0].click;", driver.findElement(By.xpath("//*[contains(text(),'Practice magic')]//i")));

    }

    @Test
    public void SCROLL() throws InterruptedException {
        driver.manage().window().maximize();
        driver.get("http://webdriveruniversity.com/Scrolling/index.html");
        JavascriptExecutor js = (JavascriptExecutor) driver;
        WebElement element = driver.findElement(By.id("zone2"));
        js.executeScript("arguments[0].scrollIntoView();", element);
    }

    @Test
    public void uPload() {
        driver.get("http://the-internet.herokuapp.com/upload ");
        driver.manage().window().maximize();
        WebElement chooseFile = driver.findElement(By.id("file-upload"));
        chooseFile.sendKeys("C:\\Users\\Tato\\OneDrive\\Desktop\\Tato.png");
        WebElement upload = driver.findElement(By.id("file-submit"));
        upload.click();

        try {
            upload.click();
        } catch (StaleElementReferenceException e) {
            System.out.println("StaleElementReferenceException");
        }
    }

    @AfterMethod
    public void quit() {
        driver.quit();
    }
}
