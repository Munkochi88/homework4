package com.test.blaze.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {
    public HomePage(WebDriver driver){
        PageFactory.initElements(driver, this);
    }
    @FindBy(xpath = "//a[.='Laptops']")
    WebElement laptopsButton;

    @FindBy(xpath = "//a[.='Cart']")
    WebElement cartButton;

    public void clickingLaptopsButton(){
        laptopsButton.click();
    }

    public void clickingCartButton(){
        cartButton.click();
    }
}
