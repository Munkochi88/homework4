package HomeworkSelenium;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.List;

public class getAttributeHomework {
    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "chromedriver");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://www.w3.org/TR/2019/NOTE-wai-aria-practices-1.1-20190814/examples/checkbox/checkbox-1/checkbox-1.html");
        List<WebElement> boxes = driver.findElements(By.xpath("//div[@role='checkbox']"));
        for (WebElement box : boxes
        ) {
            if (box.isDisplayed() && box.getAttribute("aria-checked").equals("false") && box.isEnabled()) {
                box.click();
                box.sendKeys(Keys.ARROW_DOWN);
            }

        }
        Thread.sleep(4000);
        //driver.quit();
    }
}
