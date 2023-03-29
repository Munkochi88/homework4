package aaaPractice;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class youtubePractice1 {
    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver","chromedriver");
        WebDriver driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://www.youtube.com/");
        WebElement search= driver.findElement(By.xpath("//input[@id='search']"));
        search.sendKeys("one republic secrets");
        WebElement clickingSearch= driver.findElement(By.xpath("//button[@id='search-icon-legacy']"));
        clickingSearch.click();
        Thread.sleep(3000);
        WebElement clickingVideo= driver.findElement(By.xpath("//a[@title='OneRepublic - Secrets (Official Music Video)']"));
        clickingVideo.click();
        Thread.sleep(3000);
        System.out.println(clickingVideo.getAttribute("aria-label").trim());
        driver.quit();

    }
}
