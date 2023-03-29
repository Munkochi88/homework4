package aaaPractice;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class LogInPractice {
    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver","chromedriver");
        WebDriver driver=new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
        driver.get("http://tutorialsninja.com/demo/index.php?route=account/register");
        Thread.sleep(2000);
        WebElement myAccount= driver.findElement(By.xpath("//a[@title='My Account']"));
        myAccount.click();
        Thread.sleep(2000);
        WebElement logIn1= driver.findElement(By.xpath("//a[.='Login']"));
        logIn1.click();
        Thread.sleep(2000);
        WebElement inputEmail= driver.findElement(By.xpath("//input[@id='input-email']"));
        inputEmail.sendKeys("helloo1234@gmail.com");
        Thread.sleep(2000);
        WebElement inputPassword= driver.findElement(By.xpath("//input[@id='input-password']"));
        inputPassword.sendKeys("Helloo1234567");
        Thread.sleep(2000);
        WebElement logInBtn= driver.findElement(By.xpath("//input[@value='Login']"));
        logInBtn.click();
        Thread.sleep(2000);
        WebElement header=driver.findElement(By.xpath("//h2[.='My Account']"));
        String actualHeader= header.getText().trim();
        String expectedHeader="My Account";
        System.out.println(actualHeader.equals(expectedHeader)?"Pass":"Fail");
        Thread.sleep(4000);
        //driver.quit();

    }

}
