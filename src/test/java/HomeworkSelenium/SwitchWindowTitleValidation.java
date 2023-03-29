package HomeworkSelenium;

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

public class SwitchWindowTitleValidation {
    @Test
    public void switchWindowPractice(){
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.navigate().to("https://www.techtorialacademy.com/home");
        WebElement courseButton = driver.findElement(By.xpath("//a[@class='js-linked-node']//button[@id='el_1670489249529_345']"));
        courseButton.click();
        String mainPageId = driver.getWindowHandle();
        Set<String> allPageId = driver.getWindowHandles();
        for (String id:allPageId){
            if (!id.equals(mainPageId)){
                driver.switchTo().window(id);
                break;
            }
        }
        String actualTitle = BrowserUtils.getTitleWithJS(driver);
        String expectedTitle = "Courses";
        Assert.assertEquals(actualTitle,expectedTitle);
    }
}
