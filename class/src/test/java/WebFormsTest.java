import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

public class WebFormsTest {
    @Test
    public void testBrowser(){
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("http://webdriveruniversity.com/Dropdown-Checkboxes-RadioButtons/index.html ");
        driver.manage().window().maximize();

        Select objSelect =new Select(driver.findElement(By.id("dropdowm-menu-1")));
        objSelect.selectByVisibleText("C#");
        Select objSelect2 =new Select(driver.findElement(By.id("dropdowm-menu-2")));
        objSelect2.selectByVisibleText("TestNG");
        Select objSelect3 =new Select(driver.findElement(By.id("dropdowm-menu-3")));
        objSelect3.selectByVisibleText("CSS");


        driver.findElement(By.xpath("//*[@id=\"checkboxes\"]/label[1]")).click();
        driver.findElement(By.xpath("//*[@id=\"checkboxes\"]/label[2]")).click();
        driver.findElement(By.xpath("//*[@id=\"checkboxes\"]/label[4]")).click();

        driver.findElement(By.xpath("//*[@id=\"radio-buttons\"]/input[3]")).click();




    }


}
