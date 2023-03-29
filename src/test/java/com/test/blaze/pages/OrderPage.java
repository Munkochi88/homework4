package com.test.blaze.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import utils.BrowserUtils;

public class OrderPage {
    public OrderPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    @FindBy(css = "#name")
    WebElement name;
    @FindBy(css = "#country")
    WebElement country;
    @FindBy(css = "#city")
    WebElement city;
    @FindBy(css = "#card")
    WebElement creditCard;
    @FindBy(css = "#month")
    WebElement month;
    @FindBy(css = "#year")
    WebElement year;
    @FindBy(xpath = "//button[.='Purchase']")
    WebElement purchaseButton;
    @FindBy(xpath = "//h2[contains(text(),'Thank')]")
    WebElement thankYouMessage;
    @FindBy(xpath = "//button[.='OK']")
    WebElement okButton;

    public void validatingPlacingOrderFunctionality(String name, String country, String city, String creditCard, String month, String year, String expectedMessage) throws InterruptedException {
        this.name.sendKeys(name);
        this.country.sendKeys(country);
        this.city.sendKeys(city);
        this.creditCard.sendKeys(creditCard);
        this.month.sendKeys(month);
        this.year.sendKeys(year);
        Thread.sleep(500);
        purchaseButton.click();
        Assert.assertEquals(BrowserUtils.getText(thankYouMessage), expectedMessage);
        Thread.sleep(500);
        okButton.click();
        Thread.sleep(500);
    }

}
