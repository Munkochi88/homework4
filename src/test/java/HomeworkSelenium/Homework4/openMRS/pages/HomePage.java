package HomeworkSelenium.Homework4.openMRS.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import utils.BrowserUtils;

import java.util.List;

public class HomePage {
    public HomePage(WebDriver driver){
        PageFactory.initElements(driver,this);
    }
    @FindBy(xpath = "//span[@id='selected-location']")
    WebElement location;
    @FindBy(tagName = "h4")
    WebElement header;
    @FindBy(xpath = "//li[.='Pharmacy']")
    WebElement pharmacy;
    @FindBy(xpath = "//a//img")
    WebElement logo;
    @FindBy(xpath = "//i[@class='icon-search']")
    WebElement findPatientRecordButton;
    @FindBy(xpath = "//tbody//tr//td[contains(text(),'100')]")
    List<WebElement> allIdentifiers;
    public void validatingHomePageFunctionality() throws InterruptedException {
        Assert.assertEquals(BrowserUtils.getText(location),"Laboratory");
        Thread.sleep(1000);
        Assert.assertEquals(BrowserUtils.getText(header),"Logged in as Super User (admin) at Laboratory.");
        Thread.sleep(1000);
        location.click();
        Thread.sleep(1000);
        pharmacy.click();
        Thread.sleep(1000);
        logo.click();
        Thread.sleep(1000);
        Assert.assertEquals(BrowserUtils.getText(header),"Logged in as Super User (admin) at Pharmacy.");
        Thread.sleep(1000);
        findPatientRecordButton.click();
        Thread.sleep(1000);
        for (int i = 0; i < allIdentifiers.size(); i++) {
            for (int j = i+1; j < allIdentifiers.size(); j++) {
                Assert.assertNotEquals(BrowserUtils.getText(allIdentifiers.get(j)), BrowserUtils.getText(allIdentifiers.get(i)));
            }
        }
        Thread.sleep(1000);
    }

}
