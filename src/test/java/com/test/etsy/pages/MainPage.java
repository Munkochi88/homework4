package com.test.etsy.pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import utils.BrowserUtils;

import java.util.List;

public class MainPage {
    public MainPage(WebDriver driver){
        PageFactory.initElements(driver,this);
    }
    @FindBy(xpath = "//input[@data-id='search-query']")
    WebElement searchButton;
    @FindBy(xpath = "//li//h3")
    List<WebElement> allHeader;
    public void searchButtonFunctionality(String searchItem){
        this.searchButton.sendKeys(searchItem, Keys.ENTER);
    }
    public void validateHeader(String brand,String model,String phoneCase){
        for (WebElement header:allHeader) {
            Assert.assertTrue(BrowserUtils.getText(header).toLowerCase().contains(brand)||BrowserUtils.getText(header).toLowerCase().contains(model)||BrowserUtils.getText(header).toLowerCase().contains(phoneCase));
        }
    }
}
