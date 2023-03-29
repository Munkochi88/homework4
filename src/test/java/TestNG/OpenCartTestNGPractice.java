package TestNG;

import io.github.bonigarcia.wdm.WebDriverManager;
import net.bytebuddy.build.ToStringPlugin;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class OpenCartTestNGPractice {
    @Test
    public void succesfulLogin() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://demo.opencart.com/admin/");
        Thread.sleep(1000);
        WebElement userName = driver.findElement(By.xpath("//input[@id='input-username']"));
        userName.sendKeys("demo");
        WebElement password = driver.findElement(By.xpath("//input[@id='input-password']"));
        password.sendKeys("demo");
        WebElement loginButton = driver.findElement(By.xpath("//button[@type='submit']"));
        loginButton.click();
        Thread.sleep(1000);
        String actualTitle = driver.getTitle().trim();
        String expectedTitle = "Dashboard";
        Assert.assertEquals(actualTitle, expectedTitle);

    }

    @Test
    public void negativeLogin() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://demo.opencart.com/admin/");
        Thread.sleep(1000);
        WebElement userName = driver.findElement(By.xpath("//input[@id='input-username']"));
        userName.sendKeys("omed");
        WebElement password = driver.findElement(By.xpath("//input[@id='input-password']"));
        password.sendKeys("demo");
        WebElement loginButton = driver.findElement(By.xpath("//button[@type='submit']"));
        loginButton.click();
        Thread.sleep(1000);
        String actualAlert = driver.findElement(By.xpath("//div[@id='alert']")).getText().trim();
        String expectedAlert = "No match for Username and/or Password.";
        Assert.assertEquals(actualAlert, expectedAlert);
    }

    @Test
    public void validatingProduct() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://demo.opencart.com/admin/");
        Thread.sleep(1000);
        WebElement userName = driver.findElement(By.xpath("//input[@id='input-username']"));
        userName.sendKeys("demo");
        WebElement password = driver.findElement(By.xpath("//input[@id='input-password']"));
        password.sendKeys("demo");
        WebElement loginButton = driver.findElement(By.xpath("//button[@type='submit']"));
        loginButton.click();
        Thread.sleep(1000);
        WebElement closeButton = driver.findElement(By.xpath("//button[@class='btn-close']"));
        closeButton.click();
        WebElement catalog = driver.findElement(By.xpath("//li[@id='menu-catalog']"));
        catalog.click();
        WebElement product = driver.findElement(By.xpath("//a[contains(text(),'Products')]"));
        Assert.assertTrue(product.isDisplayed());
//        WebElement product1= driver.findElement(By.xpath("https://demo.opencart.com/admin/index.php?route=catalog/product&user_token=32593e2822c440b5d63a3d877ce3203c"));
//        Assert.assertTrue(product1.isDisplayed()); // not suggested use href

    }

    @Test
    public void validateBoxesFunctionality() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://demo.opencart.com/admin/");
        Thread.sleep(1000);
        WebElement userName = driver.findElement(By.xpath("//input[@id='input-username']"));
        userName.sendKeys("demo");
        WebElement password = driver.findElement(By.xpath("//input[@id='input-password']"));
        password.sendKeys("demo");
        WebElement loginButton = driver.findElement(By.xpath("//button[@type='submit']"));
        loginButton.click();
        Thread.sleep(1000);
        WebElement closeButton = driver.findElement(By.xpath("//button[@class='btn-close']"));
        closeButton.click();
        WebElement catalog = driver.findElement(By.xpath("//li[@id='menu-catalog']"));
        catalog.click();
        WebElement product = driver.findElement(By.xpath("//a[contains(text(),'Products')]"));
        product.click();
        List<WebElement> boxes = driver.findElements(By.xpath("//input[@type='checkbox']"));
        for (int i = 1; i < boxes.size(); i++) {
            Assert.assertTrue(boxes.get(i).isDisplayed());
            Assert.assertTrue(boxes.get(i).isEnabled());
            Assert.assertFalse(boxes.get(i).isSelected()); //box is not selected it will return false
            boxes.get(i).click();
            Assert.assertTrue(boxes.get(i).isSelected()); //true
            boxes.get(i).sendKeys(Keys.ARROW_DOWN);
        }
    }
    @Test
    public void DescendingOrder() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://demo.opencart.com/admin/");
        Thread.sleep(1000);
        WebElement userName = driver.findElement(By.xpath("//input[@id='input-username']"));
        userName.sendKeys("demo");
        WebElement password = driver.findElement(By.xpath("//input[@id='input-password']"));
        password.sendKeys("demo");
        WebElement loginButton = driver.findElement(By.xpath("//button[@type='submit']"));
        loginButton.click();
        Thread.sleep(1000);
        WebElement closeButton = driver.findElement(By.xpath("//button[@class='btn-close']"));
        closeButton.click();
        WebElement catalog = driver.findElement(By.xpath("//li[@id='menu-catalog']"));
        catalog.click();
        WebElement product = driver.findElement(By.xpath("//a[contains(text(),'Products')]"));
        product.click();
        Thread.sleep(2000);
        //WebElement productNameButton= driver.findElement(By.xpath("//a[@class='asc']"));
        WebElement productNameButton= driver.findElement(By.xpath("//a[.='Product Name']"));
        //WebElement productNameButton= driver.findElement(By.xpath("//a[contains(text(),'Product Name')]"));
        productNameButton.click();
        Thread.sleep(2000);
        List<WebElement> productNames=driver.findElements(By.xpath("//td[@class='text-start']"));
        List<String> actualNames=new ArrayList<>();
        List<String> expextedNames=new ArrayList<>();
        for (int i = 1; i < productNames.size(); i++) {
            actualNames.add(productNames.get(i).getText().toLowerCase().trim());//mostly for comparison like asc, desc (to upper or lower)
            expextedNames.add(productNames.get(i).getText().toLowerCase().trim());
        }
        Collections.sort(expextedNames);
        Collections.reverse(expextedNames);

        System.out.println(expextedNames);
        System.out.println(actualNames);
        Assert.assertEquals(actualNames,expextedNames);

    }
        @Test
    public void Ascending() throws InterruptedException {
            WebDriverManager.chromedriver().setup();
            WebDriver driver = new ChromeDriver();
            driver.manage().window().maximize();
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
            driver.get("https://demo.opencart.com/admin/");
            Thread.sleep(1000);
            WebElement userName = driver.findElement(By.xpath("//input[@id='input-username']"));
            userName.sendKeys("demo");
            WebElement password = driver.findElement(By.xpath("//input[@id='input-password']"));
            password.sendKeys("demo");
            WebElement loginButton = driver.findElement(By.xpath("//button[@type='submit']"));
            loginButton.click();
            Thread.sleep(1000);
            WebElement closeButton = driver.findElement(By.xpath("//button[@class='btn-close']"));
            closeButton.click();
            WebElement catalog = driver.findElement(By.xpath("//li[@id='menu-catalog']"));
            catalog.click();
            WebElement product = driver.findElement(By.xpath("//a[contains(text(),'Products')]"));
            product.click();
            Thread.sleep(2000);
            List<WebElement> productNames=driver.findElements(By.xpath("//td[@class='text-start']"));
            List<String> actualNames=new ArrayList<>();
            List<String> expextedNames=new ArrayList<>();
            for (int i = 1; i < productNames.size(); i++) {
                actualNames.add(productNames.get(i).getText().toLowerCase().trim());//mostly for comparison like asc, desc (to upper or lower)
                expextedNames.add(productNames.get(i).getText().toLowerCase().trim());
            }
            Collections.sort(expextedNames);
            System.out.println(actualNames);
            System.out.println(expextedNames);
            Assert.assertEquals(actualNames,expextedNames);
        }
}
