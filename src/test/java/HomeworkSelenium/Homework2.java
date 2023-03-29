package HomeworkSelenium;

import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.github.dockerjava.core.exec.ListVolumesCmdExec;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Homework2 {
    @Test(priority = 1)
    public void testing1() throws InterruptedException {
        /*
        Navigate to "http://secure.smartbearsoftware.com/samples/Te stComplete11/WebOrders/Login.aspx?"
        Validate the title is equals to "Web Orders Login" Input username "Tester"
        Input password "test"
        Click login button
        Validate the title is equals to "Web Orders"
        Validate header is equals to "List of All Orders"
         */
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
        driver.get("http://secure.smartbearsoftware.com/samples/TestComplete11/WebOrders/Login.aspx?");
        Thread.sleep(1000);
        String actualTitle = driver.getTitle().trim();
        String expectedTitle = "Web Orders Login";
        Assert.assertEquals(actualTitle, expectedTitle);
        WebElement userName = driver.findElement(By.xpath("//input[@id='ctl00_MainContent_username']"));
        userName.sendKeys("Tester");
        WebElement password = driver.findElement(By.xpath("//input[@id='ctl00_MainContent_password']"));
        password.sendKeys("test");
        WebElement loginButton = driver.findElement(By.xpath("//input[@id='ctl00_MainContent_login_button']"));
        loginButton.click();
        Thread.sleep(2000);
        String actualTitle2 = driver.getTitle().trim();
        String expectedTitle2 = "Web Orders";
        Assert.assertEquals(actualTitle2, expectedTitle2);
        String actualHeader = driver.findElement(By.tagName("h2")).getText().trim();
        String expectedHeader = "List of All Orders";
        Assert.assertEquals(actualHeader, expectedHeader);
    }

    @Test(priority = 2)
    public void testing2() throws InterruptedException {
        /*
        Navigate to "http://secure.smartbearsoftware.com/samples/TestComplete11/WebOrders/Login.aspx?"
        Input username "Tester"
        Input password "Test"
        Click login button
        Click "View all products" button
        Validate "View all products" is selected
        Validate header is equals to "List of Products"
        Validate the url has "Products" keyword
         */
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.navigate().to("http://secure.smartbearsoftware.com/samples/TestComplete11/WebOrders/Login.aspx?");
        WebElement userName = driver.findElement(By.xpath("//input[@id='ctl00_MainContent_username']"));
        userName.sendKeys("Tester");
        WebElement password = driver.findElement(By.xpath("//input[@id='ctl00_MainContent_password']"));
        password.sendKeys("test");
        WebElement loginButton = driver.findElement(By.xpath("//input[@id='ctl00_MainContent_login_button']"));
        loginButton.click();
        Thread.sleep(2000);
        WebElement viewAllProductsButton= driver.findElement(By.xpath("//a[contains(text(),'products')]"));
        viewAllProductsButton.click();
        WebElement viewAllProductSelected = driver.findElement(By.xpath("//li[@class='selected']"));
        Thread.sleep(2000);
        Assert.assertEquals(viewAllProductSelected.getAttribute("class"),"selected");
        String actualHeader = driver.findElement(By.tagName("h2")).getText().trim();
        String expectedHeader = "List of Products";
        Assert.assertEquals(actualHeader,expectedHeader);
        String actualUrl = driver.getCurrentUrl().trim();
        Assert.assertTrue(actualUrl.contains("Products"));
    }
    @Test(priority = 3)
    public void testing3() throws InterruptedException {
        /*
        Navigate to "http://secure.smartbearsoftware.com/samples/TestComplete11/WebOrders/Login.aspx?"
        Input username "Tester"
        Input password "Test"
        Click login button
        Find the links for
        View all orders
        View all products
        Orders
        Validate their href values are equals to :
        "Default.aspx"
        "Products.aspx"
        "Process.aspx"
         */
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.navigate().to("http://secure.smartbearsoftware.com/samples/TestComplete11/WebOrders/Login.aspx?");
        WebElement userName = driver.findElement(By.xpath("//input[@id='ctl00_MainContent_username']"));
        userName.sendKeys("Tester");
        WebElement password = driver.findElement(By.xpath("//input[@id='ctl00_MainContent_password']"));
        password.sendKeys("test");
        WebElement loginButton = driver.findElement(By.xpath("//input[@id='ctl00_MainContent_login_button']"));
        loginButton.click();
        Thread.sleep(2000);
        WebElement viewAllOrders = driver.findElement(By.xpath("//a[@href='Default.aspx']"));
        viewAllOrders.click();
        driver.navigate().refresh();
        Assert.assertTrue(driver.getCurrentUrl().contains("Default.aspx"));
        WebElement viewAllProducts = driver.findElement(By.xpath("//a[.='View all products']"));
        viewAllProducts.click();
        Assert.assertTrue(driver.getCurrentUrl().contains("Products.aspx"));
        WebElement orders = driver.findElement(By.xpath("//a[.='Order']"));
        orders.click();
        Assert.assertTrue(driver.getCurrentUrl().contains("Process.aspx"));
    }
    @Test(priority = 4)
    public void testing4() throws InterruptedException {
        /*
        Navigate to "http://secure.smartbearsoftware.com/samples/TestComplete11 /WebOrders/Login.aspx?"
        Input username "Tester"
        Input password "Test"
        Click login button
        Click "Order" button
        Select product "Screen Saver"
        Input quantity 5
        Input Customer name "CodeFish IT School"
        Input Street "2200 E devon"
        Input City "Des Plaines"
        Input State "Illinois"
        Input Zip "60018"
        Select MasterCard
        Input card number "444993876233"
        Input expiration date "03/24"
        Click Process button
        Validate text "New order has been successfully added." is displayed below the Process button.
        Click View all orders button
        Validate new order is added and all inputs are matching with new order
        */
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.navigate().to("http://secure.smartbearsoftware.com/samples/TestComplete11/WebOrders/Login.aspx?");
        WebElement userName = driver.findElement(By.xpath("//input[@id='ctl00_MainContent_username']"));
        userName.sendKeys("Tester");
        WebElement password = driver.findElement(By.xpath("//input[@id='ctl00_MainContent_password']"));
        password.sendKeys("test");
        WebElement loginButton = driver.findElement(By.xpath("//input[@id='ctl00_MainContent_login_button']"));
        loginButton.click();
        Thread.sleep(2000);
        WebElement orders = driver.findElement(By.xpath("//a[.='Order']"));
        orders.click();
        WebElement productSelect = driver.findElement(By.xpath("//select[@id='ctl00_MainContent_fmwOrder_ddlProduct']"));
        Select productSelect1 = new Select(productSelect);
        productSelect1.selectByValue("ScreenSaver");
        WebElement quantityInput = driver.findElement(By.xpath("//input[@id='ctl00_MainContent_fmwOrder_txtQuantity']"));
        quantityInput.sendKeys("5");
        WebElement customerNameInput = driver.findElement(By.xpath("//input[@id='ctl00_MainContent_fmwOrder_txtName']"));
        customerNameInput.sendKeys("CodeFish IT School");
        WebElement streetInput = driver.findElement(By.xpath("//input[@id='ctl00_MainContent_fmwOrder_TextBox2']"));
        streetInput.sendKeys("2200 E devon");
        WebElement cityInput = driver.findElement(By.xpath("//input[@id='ctl00_MainContent_fmwOrder_TextBox3']"));
        cityInput.sendKeys("Des Plaines");
        WebElement stateInput = driver.findElement(By.xpath("//input[@id='ctl00_MainContent_fmwOrder_TextBox4']"));
        stateInput.sendKeys("Illinois");
        WebElement zipInput = driver.findElement(By.xpath("//input[@id='ctl00_MainContent_fmwOrder_TextBox5']"));
        zipInput.sendKeys("60018");
        WebElement masterCard = driver.findElement(By.xpath("//input[@id='ctl00_MainContent_fmwOrder_cardList_1']"));
        masterCard.click();
        WebElement cardNumberInput = driver.findElement(By.xpath("//input[@id='ctl00_MainContent_fmwOrder_TextBox6']"));
        cardNumberInput.sendKeys("444993876233");
        WebElement expireDateOfCard = driver.findElement(By.xpath("//input[@id='ctl00_MainContent_fmwOrder_TextBox1']"));
        expireDateOfCard.sendKeys("03/24");
        WebElement processButton = driver.findElement(By.xpath("//a[@id='ctl00_MainContent_fmwOrder_InsertButton']"));
        processButton.click();
        Thread.sleep(1500);
        WebElement text = driver.findElement(By.tagName("strong"));
        Assert.assertTrue(text.isDisplayed());
        WebElement viewAllOrders = driver.findElement(By.xpath("//a[@href='Default.aspx']"));
        viewAllOrders.click();
        Thread.sleep(3000);
        List<WebElement> actualOrderInfo=driver.findElements(By.xpath("//tr[2]//td"));
        List<String> expectedOrderInfo = Arrays.asList("","CodeFish IT School","ScreenSaver","5","02/22/2023","2200 E devon","Des Plaines","Illinois","60018","MasterCard","444993876233","03/24","");
        for (int i = 1; i <actualOrderInfo.size()-1 ; i++) {
            Assert.assertEquals(actualOrderInfo.get(i).getText().trim(),expectedOrderInfo.get(i));
        }
    }
}
