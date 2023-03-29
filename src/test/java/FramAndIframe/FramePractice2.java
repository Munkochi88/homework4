package FramAndIframe;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;
import utils.BrowserUtils;

import java.time.Duration;
import java.util.List;

public class FramePractice2 {
    @Test
    public void practice2() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
        driver.navigate().to("https://skpatro.github.io/demo/iframes/");
        WebElement pavilion = driver.findElement(By.linkText("Pavilion"));
        pavilion.click();
        BrowserUtils.switchByTitle(driver,"Home - qavalidation");
        WebElement selenium = driver.findElement(By.xpath("//ul[@id='primary-menu']//span[.='Selenium']"));
        Actions actions = new Actions(driver);
        actions.moveToElement(selenium).perform();
        WebElement seleniumJava = driver.findElement(By.xpath("//ul[@id='primary-menu']//span[.='Selenium-Java']"));
        actions.click(seleniumJava).perform();
        String actualHeader = BrowserUtils.getText(driver.findElement(By.tagName("h1")));
        Assert.assertEquals(actualHeader,"Selenium-Java Tutorial – Basic to Advance");
        List<WebElement> allOptions = driver.findElements(By.xpath("//ul[@class='ht_toc_list']//li"));
        for (WebElement option : allOptions){
            System.out.println(BrowserUtils.getText(option));
        }
        BrowserUtils.switchByTitle(driver,"iframes");
        driver.switchTo().frame("Frame1");
        WebElement category1 = driver.findElement(By.linkText("Category1"));
        category1.click();
        BrowserUtils.switchByTitle(driver,"SeleniumTesting Archives - qavalidation");
        String actualHeader1 = BrowserUtils.getText(driver.findElement(By.tagName("h1")));
        Assert.assertEquals(actualHeader1,"Category Archives: SeleniumTesting");
        System.out.println("------------------------------------");
        Thread.sleep(1000);
        List<WebElement> allHeader = driver.findElements(By.tagName("h3"));
        for (WebElement header : allHeader){
            System.out.println(BrowserUtils.getText(header));
        }
        BrowserUtils.switchByTitle(driver,"iframes");
        driver.switchTo().frame("Frame2");
        Thread.sleep(2000);
        WebElement category3 = driver.findElement(By.xpath("//a[.='Category3']"));
        category3.click();
        BrowserUtils.switchByTitle(driver,"SoftwareTesting Archives - qavalidation");
        String hdr = BrowserUtils.getText(driver.findElement(By.tagName("h1")));
        Assert.assertEquals(hdr,"Category Archives: SoftwareTesting");
    }
}
