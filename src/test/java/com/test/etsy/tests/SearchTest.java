package com.test.etsy.tests;

import com.test.etsy.pages.MainPage;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class SearchTest extends TestBaseEtsy{
    @Parameters({"searchItem","brand","model","phoneCase"})
    @Test
    public void validateSearchFunctionality(String searchItem,String brand,String model,String phoneCase){
        MainPage mainPage = new MainPage(driver);
        mainPage.searchButtonFunctionality(searchItem);
        mainPage.validateHeader(brand,model,phoneCase);
    }
}
