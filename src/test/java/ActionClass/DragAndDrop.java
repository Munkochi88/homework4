package ActionClass;

import com.beust.ah.A;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
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

public class DragAndDrop {
    @Test
    public void DragAndDrop() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
        driver.navigate().to("https://demos.telerik.com/kendo-ui/dragdrop/area");
        Thread.sleep(2000);
        WebElement cookiesButton = driver.findElement(By.xpath("//button[@id='onetrust-accept-btn-handler']"));
        cookiesButton.click();
        WebElement orangeBox = driver.findElement(By.xpath("//div[@class='test2']"));
        String actualMessage = BrowserUtils.getText(orangeBox);
        String expectedMessage = "... Or here.";
        Assert.assertEquals(actualMessage,expectedMessage);
        String actualColorOfBox = orangeBox.getCssValue("background-color");
        String expectedColorOfBox = "rgba(238, 111, 11, 1)";
        Assert.assertEquals(actualColorOfBox,expectedColorOfBox);
        WebElement dragger = driver.findElement(By.xpath("//div[@id='draggable']"));
        Actions actions = new Actions(driver);
        actions.scrollByAmount(300,300).perform();
        actions.dragAndDrop(dragger,orangeBox).perform();
        Thread.sleep(3000);
        orangeBox = driver.findElement(By.xpath("//div[@class='test2']"));
        String actualMessageAfterDragAndDrop = BrowserUtils.getText(orangeBox);
        String expectedMessageAfterDragAndDrop = "You did great!";
        Assert.assertEquals(actualMessageAfterDragAndDrop,expectedMessageAfterDragAndDrop);
    }
    @Test
    public void ClickAndHoldAndRelease() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
        driver.navigate().to("https://demos.telerik.com/kendo-ui/dragdrop/area");
        Thread.sleep(2000);
        WebElement cookiesButton = driver.findElement(By.xpath("//button[@id='onetrust-accept-btn-handler']"));
        cookiesButton.click();
        WebElement blueBox = driver.findElement(By.xpath("//div[@class='test1']"));
        String actualMessage=BrowserUtils.getText(blueBox);
        String expectedMessage = "Drag the small circle here ...";
        Assert.assertEquals(actualMessage,expectedMessage);
        String actualColor = blueBox.getCssValue("background-color");
        String expectedColor = "rgba(63, 81, 181, 1)";
        Assert.assertEquals(actualColor,expectedColor);
        Actions actions = new Actions(driver);
        actions.scrollByAmount(400,400);
        WebElement dragger = driver.findElement(By.xpath("//div[@id='draggable']"));
        actions.clickAndHold(dragger).moveToElement(blueBox).release().perform();
        blueBox = driver.findElement(By.xpath("//div[@class='test1']"));
        String actualMessageAfterClickAndHold=BrowserUtils.getText(blueBox);
        String expectedMessageAfterClickAndHold = "You did great!";
        Assert.assertEquals(actualMessageAfterClickAndHold,expectedMessageAfterClickAndHold);
    }

}
