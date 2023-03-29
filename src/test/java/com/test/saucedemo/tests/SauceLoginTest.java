package com.test.saucedemo.tests;

import com.test.saucedemo.pages.LoginPage;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import utils.ConfigReader;

public class SauceLoginTest extends SauceTestBase{
    @Parameters("expectedUrl")
    @Test
    public void validatePositiveLoginTest(String expectedUrl){
        LoginPage loginPage = new LoginPage(driver);
        loginPage.loginPositive(ConfigReader.readProperty("QA_username"),ConfigReader.readProperty("QA_password"));
        Assert.assertEquals(driver.getCurrentUrl(),expectedUrl);
    }
    @Test(dataProvider = "negativeLogin",dataProviderClass = AllData.class)
    public void validateNegativeLogin(String username,String password,String msg){
        LoginPage loginPage = new LoginPage(driver);
        loginPage.loginNegative(username,password,msg);
    }
}
