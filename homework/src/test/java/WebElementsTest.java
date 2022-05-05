import io.github.bonigarcia.wdm.WebDriverManager;

import org.testng.annotations.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;


public class WebElementsTest {
    @Test
    public void Davaleba() {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("http://the-internet.herokuapp.com/add_remove_elements/");
        driver.manage().window().maximize();

        WebElement Addelement = driver.findElement(By.xpath("//*[@id=\"content\"]/div/button"));
        for (int i = 0; i<3; i++){
            Addelement.click();
        }

        WebElement tatsnnn = driver.findElement(By.xpath("//*[@id=\"elements\"]/button[3]"));
        System.out.println(tatsnnn.getText());

        WebElement tato = driver.findElement(By.cssSelector("button. added-manually"));
        System.out.println(tato.getText());

        WebElement tarieli = 



    }




}
