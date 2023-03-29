package com.test.blaze.tests;

import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import utils.BrowserUtils;
import utils.DriverHelper;

public class TestBaseBlaze {
    public WebDriver driver;
    @BeforeSuite
    public void clearTheCaches(){
       driver=DriverHelper.getDriver();
       driver.manage().deleteAllCookies();
    }

    @BeforeMethod
    public void setup() {

        driver = DriverHelper.getDriver();
        driver.get("https://www.demoblaze.com/#");
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
