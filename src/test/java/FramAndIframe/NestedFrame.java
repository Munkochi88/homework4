package FramAndIframe;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
import utils.BrowserUtils;

import java.time.Duration;

public class NestedFrame {
    @Test
    public void nestedFramePractice() {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
        driver.navigate().to("https://the-internet.herokuapp.com/nested_frames");
        driver.switchTo().frame("frame-top");
        driver.switchTo().frame("frame-left");
        WebElement left = driver.findElement(By.xpath("//body[contains(text(),'LEFT')]"));
        Assert.assertEquals(BrowserUtils.getText(left), "LEFT");
        driver.switchTo().parentFrame();
        driver.switchTo().frame("frame-middle");
        Assert.assertEquals(BrowserUtils.getText(driver.findElement(By.xpath("//div[contains(text(),'MIDDLE')]"))),"MIDDLE");
        driver.switchTo().parentFrame();
        driver.switchTo().frame("frame-right");
        Assert.assertEquals(BrowserUtils.getText(driver.findElement(By.xpath("//body[contains(text(),'RIGHT')]"))),"RIGHT");
//        driver.switchTo().parentFrame();
//        driver.switchTo().parentFrame();
        driver.switchTo().defaultContent();
        driver.switchTo().frame("frame-bottom");
        Assert.assertEquals(BrowserUtils.getText(driver.findElement(By.xpath("//body[contains(text(),'BOTTOM')]"))),"BOTTOM");
    }
}
