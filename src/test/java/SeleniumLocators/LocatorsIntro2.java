package SeleniumLocators;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class LocatorsIntro2 {
    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver","chromedriver");
        WebDriver driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.navigate().to("file:///Users/narmandakhsumiya/Desktop/Techtorial/Techtorialhtml.html");

        //LINKTEXT LOCATOR

        WebElement javaLink = driver.findElement(By.linkText("Java"));
        javaLink.click();
        WebElement header= driver.findElement(By.tagName("h1"));
        System.out.println(header.getText().trim().equals("Java")? "Passed":"Failed");
        Thread.sleep(2000);
        driver.navigate().back();

        WebElement seleniumLink= driver.findElement(By.linkText("Selenium"));
        seleniumLink.click();
        WebElement headerSelenium=driver.findElement(By.tagName("h1"));
        System.out.println(headerSelenium.getText().trim().equals("Selenium automates browsers. That's it!")?"Passed":"Failed");
        Thread.sleep(2000);
        driver.navigate().back();

        WebElement cucumberLink= driver.findElement(By.linkText("Cucumber ".trim()));
        cucumberLink.click();
        WebElement headerCucumber= driver.findElement(By.tagName("h1"));
        System.out.println(headerCucumber.getText().trim().equals("Tools & techniques that elevate teams to greatness")?"Passed":"Failed");
        Thread.sleep(2000);
        driver.navigate().back();

        WebElement testNGLink = driver.findElement(By.linkText("TestNG"));
        testNGLink.click();
        WebElement headerTestNG=driver.findElement(By.tagName("h2"));
        System.out.println(headerTestNG.getText().trim().equals("TestNG")?"Passed":"Failed");
        Thread.sleep(2000);
        driver.navigate().back();

        System.out.println(driver.getCurrentUrl().trim().equals("file:///Users/narmandakhsumiya/Desktop/Techtorial/Techtorialhtml.html")?"URL PASS":"Fail");

        //driver.quit();

        //PARTIAL LINK TEXT LOCATOR: //must have a tag and text

        WebElement restApi= driver.findElement(By.partialLinkText("Rest"));
        restApi.click();
        String actualUrlRestApi= driver.getCurrentUrl();
        String expecterUrlRestApi="https://rest-assured.io/";
        System.out.println(actualUrlRestApi.equals(expecterUrlRestApi) ? "Passed":"Failed");

    }
}
