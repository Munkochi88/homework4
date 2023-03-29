package WaitTimes;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;
import utils.BrowserUtils;
import utils.DriverHelper;

import java.time.Duration;

public class ExplicitlyWait {
    public WebDriver driver;
    @Test
    public void validateTheText(){
        driver= DriverHelper.getDriver();
        driver.get("https://the-internet.herokuapp.com/");
        driver.findElement(By.xpath("//a[.='Dynamic Loading']")).click();
        driver.findElement(By.xpath("//a[.='Example 1: Element on page that is hidden']")).click();
        driver.findElement(By.xpath("//button[.='Start']")).click();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement text=driver.findElement(By.xpath("//div[@id='finish']"));
        text=wait.until(ExpectedConditions.visibilityOf(text));
        Assert.assertEquals(BrowserUtils.getText(text),"Hello World!");
    }
    @Test
    public void validateTheText2() {
        driver = DriverHelper.getDriver();
        driver.get("https://the-internet.herokuapp.com/");
        driver.findElement(By.linkText("Dynamic Controls")).click();
        driver.findElement(By.xpath("//input[@type='checkbox']")).click();
        driver.findElement(By.xpath("//button[.='Remove']")).click();
        WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(10));
        WebElement msg = driver.findElement(By.xpath("//p[@id='message']"));
        msg=wait.until(ExpectedConditions.visibilityOf(msg));
        Assert.assertEquals(BrowserUtils.getText(msg),"It's gone!");

    }
}
