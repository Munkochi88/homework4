package JavaScriptExecutor;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
import utils.BrowserUtils;

import java.time.Duration;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class JavaScriptPractice {
    @Test
    public void javaScriptPractice() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
        driver.navigate().to("https://www.techtorialacademy.com/");
        WebElement copyRight = driver.findElement(By.xpath("//div[contains(text(),'Copyright')]"));
        BrowserUtils.scrollWithJS(driver, copyRight);
        String actualMessage = BrowserUtils.getText(copyRight);
        String expectedMessage = "Copyright © 2023";
        Assert.assertEquals(actualMessage, expectedMessage);
        WebElement applyNow = driver.findElement(By.cssSelector("#menuItem_1594985863854_2"));
        BrowserUtils.scrollWithJS(driver, applyNow);
        Thread.sleep(1000);
        BrowserUtils.clickWithJS(driver, applyNow);
        Thread.sleep(2000);
        List<WebElement> infos = driver.findElements(By.xpath("//h3[@data-element-id='heading3Normal']"));
        List<String> expectedinfos = Arrays.asList("info@techtorialacademy.com", "+ 1 (224) 570 91 91", "Chicago & Houston");
        //List<String> actualinfos = new ArrayList<>();
        for (int i = 0; i < infos.size(); i++) {
            //actualinfos.add(BrowserUtils.getText(infos.get(i)));
            Assert.assertEquals(BrowserUtils.getText(infos.get(i)), expectedinfos.get(i));
        }
    }
}
