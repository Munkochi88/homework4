package com.test.blaze.tests;

import com.test.blaze.pages.*;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.checkerframework.checker.units.qual.A;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import utils.ConfigReader;

import java.time.Duration;
import java.util.Arrays;

public class OrderTest extends TestBaseBlaze{
    @DataProvider(name = "customerInfo")
    public Object[][] getData(){
        return new Object[][]{
            {"Ahmet","Turkia","Ankara","1234567","12","2025"},
                {"John","USA","Chicago","999999","11","2024"},
                {"Phuong Pak","Vietnam","Siylong","9876543","3","2026"}
        };
    }
    @Test(dataProvider = "customerInfo")
    public void validatingPurchaseAndOrderConfirmation(String name,String country,String city,String creditCard,
                                                       String month,String year) throws InterruptedException {
        HomePage homePage = new HomePage(driver);
        LaptopsPage laptopsPage = new LaptopsPage(driver);
        MacbookProPage macbookProPage = new MacbookProPage(driver);
        OrderPage orderPage = new OrderPage(driver);
        CartPage cartPage = new CartPage(driver);
        homePage.clickingLaptopsButton();
        Thread.sleep(1000);
        laptopsPage.clickingMacbookPro("MacBook Pro");
        macbookProPage.clickAddToCartButton(driver, "Product added");
        homePage.clickingCartButton();
        cartPage.validatingNameOfProductAndPrice(Arrays.asList("", "MacBook Pro", "1100", ""));
        cartPage.clickingPlaceOrderButton();
        Thread.sleep(1000);
        orderPage.validatingPlacingOrderFunctionality(name,country,city,creditCard,month,year, "Thank you for your purchase!");
        Assert.assertEquals(driver.getCurrentUrl().trim(), "https://www.demoblaze.com/index.html");
    }
}
