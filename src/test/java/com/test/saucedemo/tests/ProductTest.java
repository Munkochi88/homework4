package com.test.saucedemo.tests;

import com.test.saucedemo.pages.InventoryPage;
import com.test.saucedemo.pages.LoginPage;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import utils.ConfigReader;

import java.util.Arrays;
import java.util.List;

public class ProductTest extends SauceTestBase{

    @Test(dataProvider = "TestProductLinks",dataProviderClass = AllData.class)
    public void validateAllProductLinksAreWorking(String inventoryName, String expectedDescription, String expectedPrice,
                                                  String [] info,String expectedMsg){
        LoginPage loginPage = new LoginPage(driver);
        loginPage.loginPositive(ConfigReader.readProperty("QA_username"),ConfigReader.readProperty("QA_password"));
        InventoryPage inventoryPage = new InventoryPage(driver);
        inventoryPage.chooseInventory(inventoryName,expectedDescription,expectedPrice,info,expectedMsg);
    }
}
