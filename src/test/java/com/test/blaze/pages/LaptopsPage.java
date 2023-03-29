package com.test.blaze.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.BrowserUtils;

import java.util.List;

public class LaptopsPage {
    public LaptopsPage(WebDriver driver){
        PageFactory.initElements(driver, this);
    }
    @FindBy(xpath = "//a[.='MacBook Pro']")
    WebElement macbookPro;

    @FindBy(xpath = "//h4//a")
    List<WebElement> laptops;

    public void clickingMacbookPro(String brand){
        for (WebElement laptop:laptops) {
            if (BrowserUtils.getText(laptop).contains(brand)){
                laptop.click();
                break;
            }
        }
    }
}
