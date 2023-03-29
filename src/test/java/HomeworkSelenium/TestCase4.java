package HomeworkSelenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class TestCase4 {
    public static void main(String[] args) throws InterruptedException {
        /*
        Navigate to "https://www.saucedemo.com/"
        Enter username "standard_user"
        Enter password "secret_sauce"
        Click Login button
        Validate current url is "https://www.saucedemo.com/inventory.html"
         */
        System.setProperty("webdriver.chrome.driver", "chromedriver");
        WebDriver driver = new ChromeDriver();
        driver.navigate().to("https://www.saucedemo.com/");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();

        WebElement userName = driver.findElement(By.xpath("//input[@id='user-name']"));
        userName.sendKeys("standard_user");

        WebElement password = driver.findElement(By.xpath("//input[@id='password']"));
        password.sendKeys("secret_sauce");

        WebElement loginButton = driver.findElement(By.xpath("//input[@id='login-button']"));
        loginButton.click();

        String actualCurrentUrl = driver.getCurrentUrl().trim();
        String expectedUrl = "https://www.saucedemo.com/inventory.html";
        System.out.println(actualCurrentUrl.equals(expectedUrl) ? "Pass" : "Fail");

        Thread.sleep(4000);

        driver.close();

    }
}
