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
import java.util.*;

public class HoverOver {
    @Test
    public void validateNamesFromPictures() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
        driver.navigate().to("https://the-internet.herokuapp.com/hovers");
        List<WebElement> userNames = driver.findElements(By.tagName("h5"));
        List<WebElement> images = driver.findElements(By.xpath("//div[@class='figure']//img"));
        List<String> actualNames = new ArrayList<>();
        List<String> expectedNames = Arrays.asList("name: user1", "name: user2", "name: user3");
        Actions actions = new Actions(driver);
        for (int i = 0; i < userNames.size(); i++) {
            Thread.sleep(1000);
            actions.moveToElement(images.get(i)).perform();//you are hover overing the picture
            actualNames.add(BrowserUtils.getText(userNames.get(i)));//you are storing the names of the list for validating
        }
        System.out.println(actualNames);
        System.out.println(expectedNames);
        Assert.assertEquals(actualNames, expectedNames);
    }

    @Test
    public void practiceMoveToElement() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
        driver.navigate().to("https://demos.telerik.com/kendo-ui/fx/expand");
        Thread.sleep(2000);
        WebElement cookieButton = driver.findElement(By.xpath("//button[@id='onetrust-accept-btn-handler']"));
        cookieButton.click();
        Thread.sleep(2000);
        Actions actions = new Actions(driver);
        Map<String, String> map = new HashMap<>();
        List<WebElement> titles = driver.findElements(By.xpath("//div[@class='product-description']//h3"));
        List<WebElement> prices = driver.findElements(By.xpath("//div[@class='product-description']//p"));
        List<WebElement> images = driver.findElements(By.xpath("//div[@class='product k-listview-item']//img"));
        actions.scrollByAmount(400,400);
        for (int i = 0; i < images.size(); i++) {
            Thread.sleep(500);
            actions.moveToElement(images.get(i)).perform();
            map.put(BrowserUtils.getText(titles.get(i)),BrowserUtils.getText(prices.get(i)));
        }
        System.out.println(map);
        driver.close();
    }
}
