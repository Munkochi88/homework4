package com.test.bank.pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import utils.BrowserUtils;

import java.util.Arrays;
import java.util.List;

public class ManagerPage {
    public ManagerPage(WebDriver driver){
        PageFactory.initElements(driver, this);
    }
    @FindBy(xpath = "//button[@ng-class='btnClass1']")
    WebElement addCustomerButton;

    public void clickAddCustomerButton(){
        addCustomerButton.click();
    }
    @FindBy(xpath = "//input[@ng-model='fName']")
    WebElement firstName;
    @FindBy(xpath = "//input[@ng-model='lName']")
    WebElement lastName;
    @FindBy(xpath = "//input[@ng-model='postCd']")
    WebElement postCode;
    @FindBy(xpath = "//button[.='Add Customer']")
    WebElement addCustomerButton1;
    @FindBy(xpath = "//button[@ng-click='openAccount()']")
    WebElement openAccountButton;
    @FindBy(css = "#userSelect")
    WebElement customerName;
    @FindBy(css = "#currency")
    WebElement currency;
    @FindBy(xpath = "//button[@type='submit']")
    WebElement processButton;
    @FindBy(xpath = "//button[@ng-click='showCust()']")
    WebElement customersButton;
    @FindBy(xpath = "//input[@ng-model='searchCustomer']")
    WebElement searchButton;
    @FindBy(xpath = "//tr[1]//td[@class='ng-binding']")
    List<WebElement> info;
    @FindBy(xpath = "//button[.='Delete']")
    WebElement deleteButton;
    public void addCustomer(String FirstName,String LastName,String PostCode,WebDriver driver){
        addCustomerButton.click();
        this.firstName.sendKeys(FirstName);
        this.lastName.sendKeys(LastName);
        this.postCode.sendKeys(PostCode);
        addCustomerButton1.click();
        Assert.assertTrue(driver.switchTo().alert().getText().contains("Customer added successfully"));
        driver.switchTo().alert().accept();

    }
    public void selectCustomer(String fullName, WebDriver driver){
        openAccountButton.click();
        BrowserUtils.selectBy(customerName,fullName,"text");
        BrowserUtils.selectBy(currency,"Dollar","text");
        processButton.click();
        Assert.assertTrue(driver.switchTo().alert().getText().contains("Account created successfully with"));
        driver.switchTo().alert().accept();
    }
    public void validateCustomerInformationAndDeleteFunctionality(String firstName,String lastName, String postCode){
        customersButton.click();
        this.searchButton.sendKeys(firstName);
        List<String> expectedInfo = Arrays.asList(firstName,lastName,postCode);
        for (int i = 0; i<info.size();i++){
            Assert.assertEquals(BrowserUtils.getText(info.get(i)),expectedInfo.get(i));
        }
        deleteButton.click();
    }
}
