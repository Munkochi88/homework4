package com.test.blaze.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import utils.BrowserUtils;

import java.util.List;

public class CartPage {
    public CartPage(WebDriver driver){
        PageFactory.initElements(driver, this);
    }
    @FindBy(xpath = "//tr//td")
    List<WebElement> productInfos;

    @FindBy(xpath = "//button[.='Place Order']")
    WebElement placeOrderButton;

    public void validatingNameOfProductAndPrice(List<String> expectedInfos){
        for (int i = 1; i<productInfos.size()-1;i++){
            Assert.assertEquals(BrowserUtils.getText(productInfos.get(i)),expectedInfos.get(i));
        }
    }
    public void clickingPlaceOrderButton(){
        placeOrderButton.click();
    }
}
