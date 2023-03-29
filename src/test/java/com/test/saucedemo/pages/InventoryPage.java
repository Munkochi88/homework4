package com.test.saucedemo.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import utils.BrowserUtils;

import java.util.List;

public class InventoryPage {
    public InventoryPage(WebDriver driver){
        PageFactory.initElements(driver,this);
    }
    @FindBy(css = ".inventory_item_name")
    List<WebElement> allInventories;
    @FindBy(xpath = "//div[@class='inventory_details_desc large_size']")
    WebElement inventoryDescription;
    @FindBy(xpath = "//div[@class='inventory_details_price']")
    WebElement inventoryPrice;
    @FindBy(xpath = "//button[.='Add to cart']")
    WebElement addToCartButton;
    @FindBy(css = "#shopping_cart_container")
    WebElement shoppingCartBasket;
    @FindBy(css = "#checkout")
    WebElement checkoutButton;
    @FindBy(id = "first-name")
    WebElement firstName;
    @FindBy(id = "last-name")
    WebElement lastName;
    @FindBy(id = "postal-code")
    WebElement postalCode;
    @FindBy(css = "#continue")
    WebElement continueButton;
    @FindBy(css = "#finish")
    WebElement finishButton;
    @FindBy(tagName = "h2")
    WebElement thankYouMsg;

    public void chooseInventory(String inventoryName,String expectedDescription,String expectedPrice,
                                String [] info ,String expectedMsg){
        for (WebElement inventory:allInventories) {
            if (BrowserUtils.getText(inventory).contains(inventoryName)){
                inventory.click();
                break;
            }
        }
        Assert.assertTrue(BrowserUtils.getText(inventoryDescription).contains(expectedDescription));
        Assert.assertEquals(BrowserUtils.getText(inventoryPrice),expectedPrice);
        addToCartButton.click();
        shoppingCartBasket.click();
        checkoutButton.click();
        firstName.sendKeys(info[0]);
        lastName.sendKeys(info[1]);
        postalCode.sendKeys(info[2]);
        continueButton.click();
        finishButton.click();
        Assert.assertEquals(BrowserUtils.getText(thankYouMsg),expectedMsg);
    }
}
