package com.test.sentrifugo.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import utils.BrowserUtils;

import java.util.List;

public class DepartmentPage {
    public DepartmentPage(WebDriver driver){
        PageFactory.initElements(driver, this);
    }
    @FindBy(xpath = "//input[@value='Add Record']")
    WebElement addButton;

    @FindBy(xpath = "//input[@id='deptname']")
    WebElement departmentName;

    @FindBy(css = "#s2id_unitid")
    WebElement businessUnit;

    @FindBy(xpath = "//span[.='Orange Blossom']")
    WebElement orangeBlossom;

    @FindBy(name = "deptcode")
    WebElement deptCode;

    @FindBy(id = "submitbutton")
    WebElement saveButton;

    @FindBy(css = ".ml-alert-1-success")
    WebElement message;

    @FindBy(xpath = "//tr[@class='row1'][1]//td//span")
    List<WebElement> employeeInfo;

    public void validateDepartmentFunctionality(String departmentName,String deptCode,String expectedMessage){
        addButton.click();
        this.departmentName.sendKeys(departmentName);
        businessUnit.click();
        orangeBlossom.click();
        this.deptCode.sendKeys(deptCode);
        saveButton.click();
        Assert.assertEquals(BrowserUtils.getText(message),expectedMessage);
    }
    public void validateAllInfo(List<String> expectedInfo){
        for (int i = 0; i < employeeInfo.size(); i++) {
            Assert.assertEquals(BrowserUtils.getText(employeeInfo.get(i)), expectedInfo.get(i));
        }
    }
}
