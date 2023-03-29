package AlertInterface;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
import utils.BrowserUtils;

import java.time.Duration;

public class Practice {
    @Test
    public void practice() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
        driver.navigate().to("https://www.hyrtutorials.com/p/alertsdemo.html");
        WebElement alertBox = driver.findElement(By.cssSelector("#alertBox"));
        alertBox.click();
        driver.switchTo().alert();
        Assert.assertEquals(driver.switchTo().alert().getText(),"I am an alert box!");
        driver.switchTo().alert().accept();
        Assert.assertEquals(BrowserUtils.getText(driver.findElement(By.cssSelector("#output"))),"You selected alert popup");
        WebElement confirmBox = driver.findElement(By.cssSelector("#confirmBox"));
        confirmBox.click();
        driver.switchTo().alert().dismiss();
        Assert.assertEquals(BrowserUtils.getText(driver.findElement(By.cssSelector("#output"))),"You pressed Cancel in confirmation popup");
        WebElement promptBox = driver.findElement(By.cssSelector("#promptBox"));
        promptBox.click();
        driver.switchTo().alert().sendKeys("Selenium");
        driver.switchTo().alert().accept();
        Assert.assertEquals(BrowserUtils.getText(driver.findElement(By.cssSelector("#output"))),"You entered text Selenium in propmt popup");
    }
}
