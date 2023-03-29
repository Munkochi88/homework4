package com.test.bank.pages;

import com.fasterxml.jackson.annotation.JsonTypeInfo;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import utils.BrowserUtils;

import java.util.Arrays;
import java.util.List;

public class CustomerPage {
    public CustomerPage(WebDriver driver){
        PageFactory.initElements(driver,this);
    }
    @FindBy(css = "#userSelect")
    WebElement yourNameSelect;

    @FindBy(xpath = "//button[.='Login']")
    WebElement loginButton;

    @FindBy(css = "#accountSelect")
    WebElement accountSelect;

    @FindBy(xpath = "//button[contains(text(),'Deposit')]")
    WebElement depositButton;

    @FindBy(xpath = "//input[@type='number']")
    WebElement depositAmount;

    @FindBy(xpath = "//button[@type='submit']")
    WebElement submitDepositButton;

    @FindBy(xpath = "//span[.='Deposit Successful']")
    WebElement depositSuccessfulMessage;

    @FindBy(xpath = "//span[.='Harry Potter']")
    WebElement accountHolderName;

    @FindBy(xpath = "//button[contains(text(),'Withdrawl')]")
    WebElement withdrawButton;

    @FindBy(xpath = "//input[@ng-model='amount']")
    WebElement withdrawAmount;

    @FindBy(xpath = "//button[@type='submit']")
    WebElement submitWithdrawButton;

    @FindBy(xpath = "//span[.='Transaction successful']")
    WebElement withdrawSuccessfulMessage;

    @FindBy(xpath = "//button[contains(text(),'Transactions')]")
    WebElement transactionsButton;

    @FindBy(xpath = "//tbody//tr[1]//td")
    List<WebElement> depositTransactionInfo;

    @FindBy(xpath = "//tbody//tr[2]//td")
    List<WebElement> withdrawTransactionInfo;

    @FindBy(xpath = "//button[.='Reset']")
    WebElement resetButton;

    @FindBy(xpath = "//button[.='Back']")
    WebElement backButton;

    @FindBy(xpath = "//button[.='Logout']")
    WebElement logoutButton;

    @FindBy(xpath = "//button[.='Home']")
    WebElement homeButton;

    @FindBy(xpath = "//strong[contains(text(),'1006')]")
    WebElement accountNumber;

    @FindBy(xpath = "//strong[@class='ng-binding'][2]")
    WebElement balance;

    public void validateSelectingName(){
        BrowserUtils.selectBy(yourNameSelect,"Harry Potter","text");
        loginButton.click();
        Assert.assertTrue(BrowserUtils.getText(accountHolderName).contains("Harry Potter"));
    }

    public void validateSelectingAccount(){
        BrowserUtils.selectBy(accountSelect,"1006","text");
        Assert.assertEquals(BrowserUtils.getText(accountNumber),"1006");
        Assert.assertEquals(BrowserUtils.getText(balance),"0");
    }

    public void validateDepositFunctionality(String depositAmount){
        depositButton.click();
        this.depositAmount.sendKeys(depositAmount);
        submitDepositButton.click();
        Assert.assertEquals(BrowserUtils.getText(depositSuccessfulMessage),"Deposit Successful");
        Assert.assertEquals(BrowserUtils.getText(balance),"1000");
    }

    public void validateWithdrawFunctionality(String Amount) throws InterruptedException {
        withdrawButton.click();
        Thread.sleep(1000);
        withdrawAmount.sendKeys(Amount);
        Thread.sleep(1000);
        submitWithdrawButton.click();
        Assert.assertEquals(BrowserUtils.getText(withdrawSuccessfulMessage),"Transaction successful");
        Assert.assertEquals(BrowserUtils.getText(balance),"500");
    }
    public void validateTransactionsFunctionality(WebDriver driver) throws InterruptedException {
        transactionsButton.click();
        List<String> expectedDepositTransactionInfo = Arrays.asList("","1000","Credit");
        List<String> expectedWithdrawTransactionInfo = Arrays.asList("","500","Debit");
        for (int i = 1; i < depositTransactionInfo.size(); i++) {
            Assert.assertEquals(BrowserUtils.getText(depositTransactionInfo.get(i)),expectedDepositTransactionInfo.get(i));
            Assert.assertEquals(BrowserUtils.getText(withdrawTransactionInfo.get(i)),expectedWithdrawTransactionInfo.get(i));
        }
        Thread.sleep(1000);
        resetButton.click();
        Thread.sleep(1000);
        backButton.click();
        Thread.sleep(1000);
        logoutButton.click();
        Thread.sleep(1000);
        homeButton.click();
        Thread.sleep(800);
        Assert.assertTrue(driver.getCurrentUrl().contains("login"));
    }
}
