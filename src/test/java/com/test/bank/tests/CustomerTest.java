package com.test.bank.tests;

import com.test.bank.pages.CustomerPage;
import com.test.bank.pages.LoginPage;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import java.time.Duration;

public class CustomerTest {
    WebDriver driver;
    @BeforeMethod
    public void setup(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://www.globalsqa.com/angularJs-protractor/BankingProject/#/login");
    }
    @Test
    public void validateBankFunctionalityForCustomer() throws InterruptedException {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.clickingCustomerLoginButton();
        CustomerPage customerPage = new CustomerPage(driver);
        customerPage.validateSelectingName();
        customerPage.validateSelectingAccount();
        customerPage.validateDepositFunctionality("1000");
        customerPage.validateWithdrawFunctionality("500");
        Thread.sleep(1000);
        customerPage.validateTransactionsFunctionality(driver);
        Thread.sleep(1000);
    }
    @AfterMethod
    public void tearDown(){
        driver.quit();
    }
}
