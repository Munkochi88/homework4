package FileUpload;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
import utils.BrowserUtils;

import java.time.Duration;

public class FileUploadPractice {
    @Test
    public void practice1(){
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
        driver.navigate().to("https://the-internet.herokuapp.com/upload");
        WebElement chooseFileButton = driver.findElement(By.cssSelector("#file-upload"));
        chooseFileButton.sendKeys("/Users/narmandakhsumiya/Desktop/Techtorial/usa.png");
        WebElement uploadButton = driver.findElement(By.cssSelector("#file-submit"));
        uploadButton.click();
        Assert.assertEquals(BrowserUtils.getText(driver.findElement(By.cssSelector("#uploaded-files"))),"usa.png");
    }
    @Test
    public void practice2(){
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
        driver.navigate().to("https://demo.guru99.com/test/upload/");
        WebElement chooseFileButton = driver.findElement(By.cssSelector(".upload_txt"));
        chooseFileButton.sendKeys("/Users/narmandakhsumiya/Desktop/Techtorial/Selenium Homework 1.pdf");
        Assert.assertEquals(BrowserUtils.getText(driver.findElement(By.xpath("//div[@id='uploadmode3']//following-sibling::span"))),"Select file to send(max 196.45 MB)");
        WebElement iAcceptButton = driver.findElement(By.xpath("//a[.='terms of service']//preceding-sibling::input"));
        iAcceptButton.click();
        WebElement submitFileButton = driver.findElement(By.xpath("//button[@id='submitbutton']"));
        submitFileButton.click();
        //submitFileButton.submit();
        Assert.assertEquals(BrowserUtils.getText(driver.findElement(By.xpath("//h3"))),"1 file\n" +
                "has been successfully uploaded.");
        System.out.println(BrowserUtils.getText(driver.findElement(By.xpath("//h3//center"))));
    }
}
