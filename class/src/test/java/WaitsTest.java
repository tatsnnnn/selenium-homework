import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;


public class WaitsTest {

    @Test
    public void someMethod(){
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("https://demoqa.com/progress-bar");
        driver.manage().window().maximize();


        driver.findElement(By.xpath("//*[text()='Start']")).click();
        driver.manage().timeouts().implicitlyWait(500,
                TimeUnit.SECONDS);
    }


}
