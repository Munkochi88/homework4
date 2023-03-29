package HomeworkSelenium;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class TestCase2 {
    public static void main(String[] args) throws InterruptedException {
        /*
        Navigate to "https://demoqa.com/radio-button"
        Click Yes radio button
        Validate text is : You have selected Yes
        Click Impressive radio button
        Validate text is : You have selected Impressive
        TIPS: be careful about your xpath if you have any issue with getting the text.
         */
        System.setProperty("webdriver.chrome.driver", "chromedriver");
        WebDriver driver = new ChromeDriver();
        driver.get("https://demoqa.com/radio-button");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        WebElement yes = driver.findElement(By.xpath("//input[@id='yesRadio']"));
        JavascriptExecutor executor = (JavascriptExecutor) driver;
        executor.executeScript("arguments[0].click();", yes);
        Thread.sleep(3000);

        if (yes.isDisplayed() && yes.isEnabled() && !yes.isSelected()) {
            yes.click();
        }

        String actualYes = driver.findElement(By.xpath("//p[@class='mt-3']")).getText().trim();

        String expectedYes = "You have selected Yes";
        System.out.println(actualYes.equals(expectedYes) ? "Pass" : "Fail");

        WebElement impressive = driver.findElement(By.xpath("//input[@id='impressiveRadio']"));

        JavascriptExecutor executor1 = (JavascriptExecutor) driver;
        executor1.executeScript("arguments[0].click();", impressive);

        if (impressive.isDisplayed() && impressive.isEnabled() && !impressive.isSelected()) {
            impressive.click();
        }

        String actualImpressive = driver.findElement(By.xpath("//p[@class='mt-3']")).getText().trim();
        String expectedImpressive = "You have selected Impressive";
        System.out.println(actualImpressive.equals(expectedImpressive) ? "Pass" : "Fail");

        Thread.sleep(4000);

        driver.close();


    }
}
