package com.test.blaze.pages;

import com.test.bank.pages.ManagerPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import utils.BrowserUtils;

public class MacbookProPage {
    public MacbookProPage(WebDriver driver){
        PageFactory.initElements(driver, this);
    }
    @FindBy(tagName = "h2")
    WebElement headerMacbookPro;
    @FindBy(tagName = "h3")
    WebElement priceMacbookPro;
    @FindBy(xpath = "//div[@id='more-information']")
    WebElement productDescription;
    @FindBy(xpath = "//a[.='Add to cart']")
    WebElement addToCartButton;

    public void validation(WebDriver driver,String laptopHeader,String laptopPrice,String laptopDesc) throws InterruptedException {
        Assert.assertEquals(BrowserUtils.getText(headerMacbookPro),laptopHeader);
        Assert.assertEquals(BrowserUtils.getText(priceMacbookPro),laptopPrice);
        Assert.assertTrue(BrowserUtils.getText(productDescription).contains(laptopDesc));
    }
    public void clickAddToCartButton(WebDriver driver,String expectedMessage) throws InterruptedException {
        addToCartButton.click();
        Thread.sleep(1000);
        Assert.assertEquals(driver.switchTo().alert().getText(),expectedMessage);
        driver.switchTo().alert().accept();
    }

}
