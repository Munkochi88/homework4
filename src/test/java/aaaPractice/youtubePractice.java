package aaaPractice;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.List;

public class youtubePractice {
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver","chromedriver");
        WebDriver driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.navigate().to("https://www.youtube.com/");
        WebElement searchVideo=driver.findElement(By.xpath("//input[@id='search']"));
        searchVideo.sendKeys("Nava Hyicha & BENJEN - Aquarius");
        WebElement searchButton=driver.findElement(By.xpath("//button[@id='search-icon-legacy']"));
        searchButton.click();
        WebElement clickingVideo= driver.findElement(By.xpath("//a[@href='/watch?v=SDVWNRZ57Ac']//img"));
        clickingVideo.click();

    }
}
