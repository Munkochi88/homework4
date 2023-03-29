package HomeworkSelenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class TestCase3 {
    public static void main(String[] args) throws InterruptedException {
        /*
        Navigate to "https://www.saucedemo.com/"
        Enter username "Java"
        Enter password "Selenium"
        Click Login button
        Validate "Epic sadface: Username and password do not match any user in this service" message
        TIPS:to be able to see this message you need to first see this message then try to inspect it.
        it means at least run one time with the username and password you provided above to see the
        message then inspect the message.*be careful with it is fully copied or not.
         */
        System.setProperty("webdriver.chrome.driver", "chromedriver");
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.saucedemo.com/");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        WebElement userName = driver.findElement(By.xpath("//input[@id='user-name']"));
        userName.sendKeys("Java");

        WebElement password = driver.findElement(By.xpath("//input[@id='password']"));
        password.sendKeys("Selenium");

        WebElement loginButton = driver.findElement(By.xpath("//input[@id='login-button']"));
        loginButton.click();

        Thread.sleep(4000);

        String actualMessage = driver.findElement(By.xpath("//h3[@data-test='error']")).getText().trim();
        String expectedMessage = "Epic sadface: Username and password do not match any user in this service";
        System.out.println(actualMessage.equals(expectedMessage) ? "Pass" : "Fail");

        driver.close();

    }
}
