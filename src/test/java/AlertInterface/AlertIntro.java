package AlertInterface;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import utils.BrowserUtils;

import java.time.Duration;

public class AlertIntro {
    @Test
    public void alertAcceptAndGetText(){
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
        driver.navigate().to("https://the-internet.herokuapp.com/javascript_alerts");
        WebElement alertButton = driver.findElement(By.xpath("//button[contains(@onclick,'jsAlert')]"));
        alertButton.click();
        Alert alert = driver.switchTo().alert();
        String actualJSAlertText = alert.getText();
        //Assert.assertEquals(actualJSAlertText,"I am a JS Alert");
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertEquals(actualJSAlertText,"I am a JS Alerts","There is a comparison problem");
        alert.accept();
        Assert.assertEquals(BrowserUtils.getText(driver.findElement(By.cssSelector("#result"))),"You successfully clicked an alert");
        softAssert.assertAll();
    }
    @Test
    public void alertDismiss() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
        driver.navigate().to("https://the-internet.herokuapp.com/javascript_alerts");
        WebElement confirmButton = driver.findElement(By.xpath("//button[contains(@onclick,'jsConfirm')]"));
        confirmButton.click();
        Assert.assertEquals(driver.switchTo().alert().getText(),"I am a JS Confirm");
        driver.switchTo().alert().dismiss();
        Assert.assertEquals(BrowserUtils.getText(driver.findElement(By.cssSelector("#result"))),"You clicked: Cancel");
    }
    @Test
    public void sendKeys() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
        driver.navigate().to("https://the-internet.herokuapp.com/javascript_alerts");
        WebElement jsPrompt = driver.findElement(By.xpath("//button[.='Click for JS Prompt']"));
        jsPrompt.click();
        Alert alert = driver.switchTo().alert();
        Thread.sleep(2000);
        alert.sendKeys("I love UI automation");
        Thread.sleep(2000);
        alert.accept();
        Assert.assertEquals(BrowserUtils.getText(driver.findElement(By.cssSelector("#result"))),"You entered: I love UI automation");
    }
}
