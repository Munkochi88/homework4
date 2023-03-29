package com.test.bank.tests;

import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import utils.BrowserUtils;
import utils.DriverHelper;

public class TestBaseBank {
    public WebDriver driver;

    @BeforeMethod
    public void setup() {

        driver = DriverHelper.getDriver();
        driver.get("https://www.globalsqa.com/angularJs-protractor/BankingProject/#/login");
    }

    @AfterMethod
    public void tearDown(ITestResult iTestResult) throws InterruptedException {
        if (!iTestResult.isSuccess()) {
            BrowserUtils.getScreenShot(driver, "blazepicture");
        }
        Thread.sleep(3000);
        driver.quit();
    }
}
