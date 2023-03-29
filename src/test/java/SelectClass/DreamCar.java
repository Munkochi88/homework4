package SelectClass;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;
import utils.BrowserUtils;

import javax.swing.plaf.synth.SynthOptionPaneUI;
import java.time.Duration;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class DreamCar {
    @Test
    public void validateHeader() throws InterruptedException {
        /*
        NOTE: Please use browser utils for the select classes if it is needed.
        1-Navigate to the website
        2-Choose the "New Cars" from the New/used option
        3-Choose "Lexus" for Make part
        4-Choose "RX-350"
        5-Validate the Price is selected "No max price"-->getFirstSelectedOption
        6-Choose the distance 40 mil
        7-Put your Zip code-->Before that Clear it.60056
        8-Click Search Button
        9-Validate the header "New Lexus RX 350 for sale"
        10-Click Sort by and choose the Lowest Price
        11-Validate the all titles has Lexus RX 350
        */
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://www.cars.com/");
        WebElement newUsed = driver.findElement(By.cssSelector("#make-model-search-stocktype"));
        BrowserUtils.selectBy(newUsed,"new","value");
        WebElement make = driver.findElement(By.cssSelector("#makes"));
        BrowserUtils.selectBy(make,"Lexus","text");
        WebElement model = driver.findElement(By.cssSelector("#models"));
        BrowserUtils.selectBy(model,"lexus-rx_350","value");
        WebElement price = driver.findElement(By.cssSelector("#make-model-max-price"));
        Select price1=new Select(price);
        String actual = price1.getFirstSelectedOption().getText();
        String expected = "No max price";
        Assert.assertEquals(actual,expected);
        WebElement distance = driver.findElement(By.cssSelector("#make-model-maximum-distance"));
        BrowserUtils.selectBy(distance,"40 miles","text");
        WebElement zip = driver.findElement(By.cssSelector("#make-model-zip"));
        zip.clear();
        zip.sendKeys("60056");
        WebElement searchButton = driver.findElement(By.xpath("//button[@data-searchtype='make']"));
        searchButton.click();
        //driver.navigate().refresh();
        WebElement header = driver.findElement(By.xpath("//h1[.='New Lexus RX 350 for sale']"));
        String actualHeader = BrowserUtils.getText(header);
        String expectedHeader = "New Lexus RX 350 for sale";
        Assert.assertEquals(actualHeader,expectedHeader);
        WebElement sortBy = driver.findElement(By.cssSelector("#sort-dropdown"));
        BrowserUtils.selectBy(sortBy,"Lowest price","text");
        Thread.sleep(2000);
        List<WebElement> titles = driver.findElements(By.xpath("//h2[@class='title']"));
        for (WebElement title:titles){
            Assert.assertTrue(BrowserUtils.getText(title).contains("Lexus RX 350"));
        }
        Thread.sleep(2000);
        List<WebElement> prices=driver.findElements(By.cssSelector(".primary-price"));
        List<Integer> actualCarPrice = new ArrayList<>();
        List<Integer> expectedCarPrice = new ArrayList<>();
        for (WebElement carPrice:prices){
            actualCarPrice.add(Integer.parseInt(BrowserUtils.getText(carPrice).replace("$","").replace(",","")));
            expectedCarPrice.add(Integer.parseInt(BrowserUtils.getText(carPrice).replace("$","").replace(",","")));
        }
        Collections.sort(expectedCarPrice);
        Assert.assertEquals(actualCarPrice,expectedCarPrice);
    }
}
