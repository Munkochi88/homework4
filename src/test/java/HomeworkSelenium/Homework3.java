package HomeworkSelenium;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;
import utils.BrowserUtils;

import java.time.Duration;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Homework3 {
    @Test
    public void testCase1() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.navigate().to("http://uitestpractice.com/Students/Index");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        WebElement createNewButton = driver.findElement(By.linkText("Create New"));
        createNewButton.click();
        driver.switchTo().frame("aswift_2");
        driver.switchTo().frame("ad_iframe");
        WebElement closeButton = driver.findElement(By.xpath("//div[@id='dismiss-button']"));
        closeButton.click();
        driver.switchTo().parentFrame();
        WebElement firstNameInput = driver.findElement(By.xpath("//input[@id='FirstName']"));
        firstNameInput.sendKeys("Joseph");
        WebElement lastNameInput = driver.findElement(By.xpath("//input[@id='LastName']"));
        lastNameInput.sendKeys("Ochirbat");
        WebElement enrollmentDateInput = driver.findElement(By.xpath("//input[@id='EnrollmentDate']"));
        enrollmentDateInput.sendKeys("12/31/2023");
        WebElement createButton = driver.findElement(By.xpath("//input[@value='Create']"));
        createButton.click();
        WebElement searchBar = driver.findElement(By.id("Search_Data"));
        searchBar.sendKeys("Joseph", Keys.ENTER);
        List<WebElement> newInformation = driver.findElements(By.xpath("//tr[2]//td"));
        List<String> actualNewInformation = new ArrayList<>();
        List<String> expectedNewInformation = Arrays.asList("Joseph", "Ochirbat", "12/31/2023 12:00:00 AM");
        for (int i = 0; i < newInformation.size() - 1; i++) {
            System.out.println(BrowserUtils.getText(newInformation.get(i)));
            actualNewInformation.add(BrowserUtils.getText(newInformation.get(i)));
            Assert.assertEquals(actualNewInformation.get(i), expectedNewInformation.get(i));
        }
    }
    @Test
    public void testCase2() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.navigate().to("http://uitestpractice.com/Students/Index");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        WebElement searchBar = driver.findElement(By.id("Search_Data"));
        searchBar.sendKeys("Ochirbat", Keys.ENTER);
        Thread.sleep(2000);
        WebElement editButton = driver.findElement(By.xpath("//tr[2]//button[.='EDIT']"));
        editButton.click();
        WebElement firstName = driver.findElement(By.xpath("//input[@id='FirstName']"));
        firstName.clear();
        firstName.sendKeys("Munk");
        WebElement saveButton = driver.findElement(By.xpath("//input[@value='Save']"));
        saveButton.click();
        Thread.sleep(2000);
        searchBar = driver.findElement(By.id("Search_Data"));
        searchBar.sendKeys("Munk");
        WebElement findButton = driver.findElement(By.xpath("//input[@value='Find']"));
        findButton.click();
        Assert.assertEquals(BrowserUtils.getText(driver.findElement(By.xpath("//tr[2]//td[1]"))),"Munk");
    }
    @Test
    public void testCase3() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.navigate().to("http://uitestpractice.com/Students/Index");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        WebElement searchBar = driver.findElement(By.id("Search_Data"));
        searchBar.sendKeys("Ochirbat",Keys.ENTER);
        WebElement deleteButton = driver.findElement(By.xpath("//button[.='DELETE']"));
        deleteButton.click();
        WebElement confirmDeleteButton = driver.findElement(By.xpath("//input[@value='Delete']"));
        confirmDeleteButton.click();
        Thread.sleep(2000);
        searchBar = driver.findElement(By.id("Search_Data"));
        searchBar.sendKeys("Ochirbat",Keys.ENTER);
        Assert.assertTrue(BrowserUtils.getText(driver.findElement(By.xpath("//div[@class='container body-content']"))).contains("There are zero students with this search text Page 0 of 0"));
    }
    @Test
    public void testCase4(){
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.navigate().to("http://uitestpractice.com/");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        WebElement dragMeBox = driver.findElement(By.xpath("//div[@id='draggable']"));
        WebElement dropHereBox = driver.findElement(By.xpath("//div[@id='droppable']"));
        Actions actions = new Actions(driver);
        actions.dragAndDrop(dragMeBox,dropHereBox).perform();
        Assert.assertEquals(BrowserUtils.getText(driver.findElement(By.xpath("//div[@id='droppable']//p"))),"Dropped!");
    }
    @Test
    public void testCase5() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.navigate().to("http://uitestpractice.com/");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        WebElement doubleClickMeButton = driver.findElement(By.name("dblClick"));
        Actions actions = new Actions(driver);
        doubleClickMeButton.click();
        actions.doubleClick(doubleClickMeButton).perform();
        Thread.sleep(1500);
        Assert.assertEquals(driver.switchTo().alert().getText(),"Double Clicked !!");
        driver.switchTo().alert().accept();
    }
    @Test
    public void testCase6() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.navigate().to("http://uitestpractice.com/");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.switchTo().frame("iframe_a");
        WebElement enterYourNameBox = driver.findElement(By.xpath("//input[@id='name']"));
        enterYourNameBox.sendKeys("Munk");
        driver.switchTo().parentFrame();
        WebElement belowLink = driver.findElement(By.linkText("uitestpractice.com"));
        belowLink.click();
        Actions actions = new Actions(driver);
        Thread.sleep(2000);
        driver.switchTo().frame("iframe_a");
        WebElement subFrameError = driver.findElement(By.xpath("//div[@id='sub-frame-error-details']"));
        actions.moveToElement(subFrameError).perform();
        Assert.assertTrue(subFrameError.isDisplayed());
    }
    @Test
    public void testCase7() {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.navigate().to("http://uitestpractice.com/");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        WebElement clickHereToWatchVideosOnButton = driver.findElement(By.linkText("Click here to watch videos on C#"));
        clickHereToWatchVideosOnButton.click();
        BrowserUtils.switchByTitle(driver,"C# Beginner to advanced");
        Assert.assertTrue(BrowserUtils.getTitleWithJS(driver).contains("C# Beginner to advanced"));
        Assert.assertTrue(driver.getCurrentUrl().trim().contains("youtube"));
    }
}
