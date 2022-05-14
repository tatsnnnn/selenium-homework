import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;

import java.awt.*;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.io.File;

public class FileUploadTest { WebDriver driver;
    String url1;

    public FileUploadTest() {
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        url1="http://the-internet.herokuapp.com/upload";
        driver.manage().window().maximize();
    }

    @Test
    public void fileUpload(){
        driver.get(url1);
        WebElement add = driver.findElement(By.id("file-upload"));
        WebElement submit = driver.findElement(By.id("file-submit"));
        File filePath=new File("src/main/resources/text.txt");
        System.out.println("absolute path is: " + filePath.getAbsolutePath());
        add.sendKeys(filePath.getAbsolutePath());
        submit.click();
        try {
            WebElement checkuploadedFile= driver.findElement(By.xpath("//div[@class='example']/h3[text()='File Uploaded!']"));
            new WebDriverWait(driver, 10).until(ExpectedConditions.visibilityOf(checkuploadedFile));
            if (checkuploadedFile.isDisplayed()){
                System.out.println("aitvirta");
            }

            add.click();
        }catch (NoSuchElementException e){
            System.out.println(e.getMessage());
        }catch (StaleElementReferenceException e){
            System.out.println("exception");
            System.out.println(e.getMessage());
        }
    }


    @AfterClass
    public void afterClass(){
        driver.quit();
    }


}
