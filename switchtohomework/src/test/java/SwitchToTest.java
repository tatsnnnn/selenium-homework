import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;


public class SwitchToTest {
    WebDriver driver;
    @BeforeMethod
    public void dackeba() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
    }
    @Test
    public void gadasvla1(){
        driver.get("http://the-internet.herokuapp.com/iframe");
        driver.manage().window().maximize();
        driver.switchTo().frame("mce_0_ifr");
        WebElement textField = driver.findElement(By.id("tinymce"));
        textField.sendKeys("Here Goes");
        driver.findElement(By.xpath("//*[@id=\"content\"]/div/div/div[1]/div[1]/div[2]/div/div[4]/button[2]")).click();
    }
    @Test
    public void gadasvla2(){
        driver.get("https://demoqa.com/alerts");
        driver.manage().window().maximize();
        driver.findElement(By.id("alertButton")).click();
        new WebDriverWait(driver,500).until(ExpectedConditions.alertIsPresent());
        Alert alerti = driver.switchTo().alert();
        alerti.accept();
    }

}

