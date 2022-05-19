import java.util.*;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.Cookie;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class CookieTest {
    WebDriver driver;
    @BeforeMethod
    public void Start(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();

    }
    @Test
    public void saveCookie(){
        driver.get("http://demo.guru99.com/test/cookie/selenium_aut.php");
        driver.findElement(By.name("username")).sendKeys("tatsnnn");
        driver.findElement(By.name("password")).sendKeys("tbc123");
        driver.findElement(By.name("submit")).click();


        Set<Cookie> cookie = driver.manage().getCookies();
        Cookie seleniumCookie = driver.manage().getCookieNamed("Selenium");

        for(Cookie ck:cookie) {
            driver.manage().deleteCookie(seleniumCookie);
        }
    }
    @AfterMethod
    public void quit(){
        driver.quit();
    }
}
