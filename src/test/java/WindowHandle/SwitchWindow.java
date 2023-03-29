package WindowHandle;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
import utils.BrowserUtils;

import java.time.Duration;
import java.util.Set;

public class SwitchWindow {
    @Test
    public void switchPractice(){
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
        driver.navigate().to("https://the-internet.herokuapp.com/windows");
        WebElement clickHereButton = driver.findElement(By.xpath("//a[contains(text(),'Click Here')]"));
        BrowserUtils.clickWithJS(driver,clickHereButton);
        String mainPageID = driver.getWindowHandle();
        System.out.println(mainPageID);
        Set <String> allPagesId=driver.getWindowHandles();
        System.out.println(allPagesId);
        for (String id:allPagesId){
            //this is used for only 2 tabs/windows
            if(!id.equals(mainPageID)){
                driver.switchTo().window(id);
                break;
            }
        }
        String actualHeader = driver.findElement(By.tagName("h3")).getText().trim();
        String expectedHeader = "New Window";
        Assert.assertEquals(actualHeader,expectedHeader);
    }
    @Test
    public void practice1() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
        driver.navigate().to("https://www.hyrtutorials.com/p/window-handles-practice.html");
        WebElement openNewTab = driver.findElement(By.cssSelector("#newTabBtn"));
        openNewTab.click();
        String mainId = driver.getWindowHandle();
        Set<String> allPageId = driver.getWindowHandles();
        for (String id:allPageId){
            if (!id.equals(mainId)){
                driver.switchTo().window(id);
                break;
            }
        }
        String title = BrowserUtils.getTitleWithJS(driver);
        Assert.assertEquals(title,"AlertsDemo - H Y R Tutorials");
        String header = BrowserUtils.getText(driver.findElement(By.xpath("//h1[@itemprop='name']")));
        Assert.assertEquals(header,"AlertsDemo");
        Thread.sleep(2000);
        WebElement clickMe = driver.findElement(By.xpath("//button[@id='alertBox']"));
        clickMe.click();
        Thread.sleep(3000);
        driver.quit();
    }
}
