package ActionClass;

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

public class PracticeActions {
    @Test
    public void validateMessageAndColor() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
        driver.navigate().to("https://demoqa.com/droppable");
        Thread.sleep(2000);
        Actions actions = new Actions(driver);
        WebElement dragger = driver.findElement(By.xpath("//div[@id='draggable']"));
        WebElement dropHere = dragger.findElement(By.xpath("//div[@id='simpleDropContainer']//div[@id='droppable']"));
//        actions.clickAndHold(dragger).moveToElement(dropHere).release().perform();
        actions.dragAndDrop(dragger, dropHere).perform();
        Thread.sleep(2000);
        //actions.scrollByAmount(300,300).perform();
        String actualColorOfBox = dropHere.getCssValue("background-color");
        String expectedColorOfBox = "rgba(70, 130, 180, 1)";
        String actualMessage = BrowserUtils.getText(dropHere);
        String expectedMessage = "Dropped!";
        Assert.assertEquals(actualMessage, expectedMessage);
        Assert.assertEquals(actualColorOfBox, expectedColorOfBox);
    }
    @Test
    public void validateNotAcceptableFunctionality() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
        driver.navigate().to("https://demoqa.com/droppable");
        WebElement acceptButton = driver.findElement(By.cssSelector("#droppableExample-tab-accept"));
        acceptButton.click();
        Thread.sleep(1000);
        WebElement notAcceptable = driver.findElement(By.cssSelector("#notAcceptable"));
        Actions actions = new Actions(driver);
        WebElement dropHere = driver.findElement(By.xpath("//div[@id='droppableExample-tabpane-accept']//div[@id='droppable']"));
        actions.clickAndHold(notAcceptable).moveToElement(dropHere).release().perform();
        String actualMessage = BrowserUtils.getText(notAcceptable);
        String expectedMessage = "Not Acceptable";
        Assert.assertEquals(actualMessage,expectedMessage);
        String actualMessage1 = BrowserUtils.getText(dropHere);
        String expectedMessage1 = "Drop here";
        Assert.assertEquals(actualMessage1,expectedMessage1);
    }
}
