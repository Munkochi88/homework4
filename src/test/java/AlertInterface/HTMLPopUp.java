package AlertInterface;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
import utils.BrowserUtils;

import java.time.Duration;

public class HTMLPopUp {
    @Test
    public void htmlPupUpPractice() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
        driver.navigate().to("https://sweetalert.js.org/");
        WebElement jsPreview = driver.findElement(By.xpath("//button[contains(@onclick,'Oops, something went wrong!')]"));
        jsPreview.click();
        Thread.sleep(3000);
        Assert.assertEquals(driver.switchTo().alert().getText(),"Oops, something went wrong!");
        driver.switchTo().alert().accept();
        WebElement htmlPreview = driver.findElement(By.xpath("//button[contains(@onclick,'error')]"));
        htmlPreview.click();
        Assert.assertTrue(BrowserUtils.getText(driver.findElement(By.xpath("//div[@class='swal-modal']"))).contains("Something went wrong!"));
        WebElement okButton = driver.findElement(By.xpath("//button[@class='swal-button swal-button--confirm']"));
        okButton.click();
    }
}
