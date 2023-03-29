package aaaPractice;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.List;

public class amazonPractice {
    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "chromedriver");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
        driver.get("https://www.amazon.com/");
        WebElement searchTextBox = driver.findElement(By.xpath("//input[@id='twotabsearchtextbox']"));
        searchTextBox.sendKeys("laptop stand");
        WebElement searchSubmitButton = driver.findElement(By.xpath("//input[@id='nav-search-submit-button']"));
        searchSubmitButton.click();
        Thread.sleep(4000);
//        WebElement iconBox = driver.findElement(By.xpath("//li[@id='p_76/1249170011']"));
//        iconBox.click();
        //Thread.sleep(5000);
        //driver.close();
        WebElement vivoBrand= driver.findElement(By.xpath("//li[@id='p_89/VIVO']"));
        vivoBrand.click();
        Thread.sleep(5000);
        //driver.close();

    }
}
