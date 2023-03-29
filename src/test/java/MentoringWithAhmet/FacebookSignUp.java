package MentoringWithAhmet;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;
import utils.BrowserUtils;

import java.time.Duration;

public class FacebookSignUp {
    @Test
    public void validateFacebookSignUp() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
        driver.navigate().to("https://www.facebook.com/");
        WebElement signUpButton = driver.findElement(By.xpath("//a[@data-testid='open-registration-form-button']"));
        signUpButton.click();
        WebElement firstName = driver.findElement(By.xpath("//input[@name='firstname']"));
        firstName.sendKeys("Munk");
        WebElement lastName = driver.findElement(By.xpath("//input[@name='lastname']"));
        lastName.sendKeys("Ochi");
        WebElement mobileNumber = driver.findElement(By.xpath("//input[@name='reg_email__']"));
        mobileNumber.sendKeys("1234567890");
        WebElement password = driver.findElement(By.xpath("//input[@name='reg_passwd__']"));
        password.sendKeys("password1!");
        WebElement birthdayMonth = driver.findElement(By.cssSelector("#month"));
        BrowserUtils.selectBy(birthdayMonth,"9","value");
        WebElement birthdayDay = driver.findElement(By.cssSelector("#day"));
        BrowserUtils.selectBy(birthdayDay,"10","value");
        WebElement birthdayYear = driver.findElement(By.cssSelector("#year"));
        BrowserUtils.selectBy(birthdayYear,"1990","value");
        Thread.sleep(2000);
        WebElement maleRadioButton = driver.findElement(By.xpath("//input[@value='2']"));
        maleRadioButton.click();
        WebElement signUpButton2 = driver.findElement(By.xpath("//button[@name='websubmit']"));
        signUpButton2.click();
    }
}
