package com.test.blaze.tests;

import com.test.blaze.pages.HomePage;
import com.test.blaze.pages.LaptopsPage;
import com.test.blaze.pages.MacbookProPage;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;



public class MacbookProTest extends TestBaseBlaze{
    @Parameters({"laptopBrand","laptopPrice","message","description"})
    @Test
    public void validateProductInformation(String laptopBrand,String laptopPrice,String message,String description) throws InterruptedException {
        HomePage homePage = new HomePage(driver);
        LaptopsPage laptopsPage = new LaptopsPage(driver);
        MacbookProPage macbookProPage = new MacbookProPage(driver);
        homePage.clickingLaptopsButton();
        Thread.sleep(1000);
        laptopsPage.clickingMacbookPro(laptopBrand);
        Thread.sleep(1000);
        macbookProPage.validation(driver,laptopBrand,laptopPrice,description);
        macbookProPage.clickAddToCartButton(driver,message);
    }
}
