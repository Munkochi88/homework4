package com.test.bank.tests;

import com.test.bank.pages.LoginPage;
import com.test.bank.pages.ManagerPage;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import utils.ConfigReader;

import java.time.Duration;
import java.util.Arrays;

public class ManagerTest {
    WebDriver driver;
    @BeforeMethod
    public void setup(){

        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get(ConfigReader.readProperty("xyzBank"));
    }
    @Test
    public void validateBankFunctionalityForManager(){
        LoginPage loginPage = new LoginPage(driver);
        ManagerPage managerPage = new ManagerPage(driver);
        loginPage.clickingBankManagerButton();
        managerPage.addCustomer(ConfigReader.readProperty("firstName"),ConfigReader.readProperty("lastName"),ConfigReader.readProperty("postCode"),driver);
        managerPage.selectCustomer("Munk Ochi",driver);
        managerPage.validateCustomerInformationAndDeleteFunctionality("Munk","Ochi","60000");
    }
    @AfterMethod
    public void tearDown(){
        driver.quit();
    }
}
