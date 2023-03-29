package SeleniumIntro;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TransferQueue;

public class SeleniumDriverMethods {
    /*
    driver.get()
    driver.manage.window.maximize()
    driver.getTitle()
    driver.getCurrentUrl()
    driver.getPageSource()
    driver.navigate().To()
    driver.navigate().refresh()
    driver.navigate().forward()
    driver.navigate().back()
    driver.close()
     */
    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver","chromedriver");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.navigate().to("https://www.google.com/");
        System.out.println(driver.getTitle());
        driver.get("https://www.youtube.com/");
        System.out.println(driver.getCurrentUrl());
        //Thread.sleep(3000);
        driver.navigate().back();
        //Thread.sleep(3000);
        driver.navigate().forward();
        //Thread.sleep(3000);
        driver.navigate().refresh();
        //Thread.sleep(3000);
        System.out.println(driver.getPageSource());//it will give the html structure of page
        driver.quit();

    }

}
