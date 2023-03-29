package WindowHandle;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;
import utils.BrowserUtils;

import java.time.Duration;

public class SwitchMultipleWindows {
    @Test
    public void multipleWindowsPractice() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver=new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.open('http://www.techtorialacademy.com/')");
        js.executeScript("window.open('https://www.techtorialacademy.com/contact-us-techtorial')");
        js.executeScript("window.open('https://www.techtorialacademy.com/courses')");
        BrowserUtils.switchByTitle(driver,"Contact");
        Thread.sleep(3000);
        BrowserUtils.switchByTitle(driver,"Home");
        Thread.sleep(3000);
        BrowserUtils.switchByTitle(driver,"Courses");
        Thread.sleep(3000);
        driver.quit();
    }
    @Test
    public void task2() throws InterruptedException {
        /*
        1-Navigate to https://www.hyrtutorials.com/p/window-handles-practice.html
        2-Click open multiple tabs under Button 4
        3-the Basic Control and fill all the blanks
        4-Click Register button and validate the message "Registration is Successful"
        5-GO to the Window handle practice page and validate Header  which is Window Handles Practice
        6- go to the alertsDemo page and click  the "Click Me" button under prompt box
        7-quit all the pages.
        8-Proud of yourself
        */
        WebDriverManager.chromedriver().setup();
        WebDriver driver=new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
        driver.navigate().to("https://www.hyrtutorials.com/p/window-handles-practice.html");
        WebElement button4 = driver.findElement(By.cssSelector("#newTabsBtn"));
        BrowserUtils.clickWithJS(driver,button4);
        BrowserUtils.switchByTitle(driver,"Basic Controls");
        WebElement firstName = driver.findElement(By.cssSelector("#firstName"));
        firstName.sendKeys("Munk");
        WebElement lastName = driver.findElement(By.cssSelector("#lastName"));
        lastName.sendKeys("Ochi");
        WebElement englishButton = driver.findElement(By.cssSelector("#englishchbx"));
        BrowserUtils.clickWithJS(driver,englishButton);
        WebElement email = driver.findElement(By.xpath("//input[@id='email']"));
        email.sendKeys("helloworld@gmail.com");
        WebElement password = driver.findElement(By.xpath("//input[@id='password']"));
        password.sendKeys("password1!");
        Thread.sleep(2000);
        WebElement registerButton = driver.findElement(By.xpath("//button[@id='registerbtn']"));
        Actions actions = new Actions(driver);
        //actions.sendKeys(Keys.PAGE_DOWN).build().perform();
        //BrowserUtils.scrollWithJS(driver,registerButton);
        actions.scrollByAmount(1500,1500).perform();
        registerButton.click();
        String actualMessage = BrowserUtils.getText(driver.findElement(By.xpath("//label[.='Registration is Successful']")));
        Assert.assertEquals(actualMessage,"Registration is Successful");
        BrowserUtils.switchByTitle(driver,"Window Handles Practice");
        String actualHeader = BrowserUtils.getText(driver.findElement(By.xpath("//h1[@itemprop='name']")));
        Assert.assertEquals(actualHeader,"Window Handles Practice");
        BrowserUtils.switchByTitle(driver,"AlertsDemo");
        WebElement clickMe = driver.findElement(By.xpath("//button[@id='promptBox']"));
        BrowserUtils.scrollWithJS(driver,clickMe);
        clickMe.click();
        //Thread.sleep(2000);
        //driver.quit();
    }
}
