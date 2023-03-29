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

public class FramePractice {
    @Test
    public void iFramePractice(){
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
        driver.navigate().to("https://the-internet.herokuapp.com/iframe");
        String actualHeader = driver.findElement(By.tagName("h3")).getText().trim();
        Assert.assertEquals(actualHeader,"An iFrame containing the TinyMCE WYSIWYG Editor");
        driver.switchTo().frame("mce_0_ifr");
        WebElement comment = driver.findElement(By.cssSelector("#tinymce"));
        comment.clear();
        comment.sendKeys("I love Selenium");
        //driver.switchTo().parentFrame();
        BrowserUtils.switchByTitle(driver,"The Internet");
        WebElement link = driver.findElement(By.xpath("//a[.='Elemental Selenium']"));
        BrowserUtils.clickWithJS(driver,link);
        BrowserUtils.switchByTitle(driver,"Element Selenium");
        String actualHeader1 = driver.findElement(By.tagName("h1")).getText().trim();
        Assert.assertEquals(actualHeader1,"Elemental Selenium");
    }
}
