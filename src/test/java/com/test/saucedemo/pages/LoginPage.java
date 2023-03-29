package com.test.saucedemo.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import utils.BrowserUtils;

public class LoginPage {
    public LoginPage(WebDriver driver){
        PageFactory.initElements(driver,this);
    }
    @FindBy(css = "#user-name")
    WebElement userName;
    @FindBy(css = "#password")
    WebElement password;
    @FindBy(css = "#login-button")
    WebElement loginButton;
    @FindBy(tagName = "h3")
    WebElement message;

    public void loginPositive(String username,String password){
        this.userName.sendKeys(username);
        this.password.sendKeys(password);
        loginButton.click();
    }
    public void loginNegative(String username,String password,String errMsg){
        this.userName.sendKeys(username);
        this.password.sendKeys(password);
        loginButton.click();
        Assert.assertEquals(BrowserUtils.getText(message),errMsg);
    }
}
