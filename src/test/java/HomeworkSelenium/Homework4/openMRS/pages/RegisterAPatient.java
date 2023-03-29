package HomeworkSelenium.Homework4.openMRS.pages;

import com.google.j2objc.annotations.Weak;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import utils.BrowserUtils;

import java.util.List;

public class RegisterAPatient {
    public RegisterAPatient(WebDriver driver){
        PageFactory.initElements(driver,this);
    }
    @FindBy(xpath = "//i[@class='icon-user']")
    WebElement registerAPatientButton;
    @FindBy(xpath = "//input[@name='givenName']")
    WebElement givenName;
    @FindBy(xpath = "//input[@name='familyName']")
    WebElement familyName;
    @FindBy(xpath = "//span[@id='genderLabel']")
    WebElement genderButton;
    @FindBy(xpath = "//option[@value='M']")
    WebElement maleButton;
    @FindBy(xpath = "//span[@id='birthdateLabel']")
    WebElement birthdateButton;
    @FindBy(xpath = "//input[@id='birthdateDay-field']")
    WebElement birthdateDay;
    @FindBy(xpath = "//select[@id='birthdateMonth-field']")
    WebElement birthdateMonth;
    @FindBy(xpath = "//input[@id='birthdateYear-field']")
    WebElement birthdateYear;
    @FindBy(xpath = "//span[.='Address']")
    WebElement addressButton;
    @FindBy(css = "#address1")
    WebElement address1;
    @FindBy(css = "#cityVillage")
    WebElement cityVillage;
    @FindBy(css = "#stateProvince")
    WebElement stateProvince;
    @FindBy(css = "#country")
    WebElement country;
    @FindBy(css = "#postalCode")
    WebElement postalCode;
    @FindBy(xpath = "//span[.='Phone Number']")
    WebElement phoneNumberButton;
    @FindBy(xpath = "//input[@name='phoneNumber']")
    WebElement phoneNumber;
    @FindBy(css = "#confirmation_label")
    WebElement confirmButton1;
    @FindBy(css = "#submit")
    WebElement confirmButton2;
    @FindBy(xpath = "//div[@id='dataCanvas']//div//p")
    List<WebElement> patientAllInformation;
    @FindBy(xpath = "//div[@class='identifiers']")
    WebElement patientIdentifier;
    @FindBy(tagName = "h1")
    WebElement patientInfoDisplay;
    @FindBy(xpath = "//a//img")
    WebElement homeButton;
    @FindBy(xpath = "//i[@class='icon-search']")
    WebElement findPatientRecordButton;
    @FindBy(xpath = "//input[@id='patient-search']")
    WebElement searchPatient;
    @FindBy(xpath = "//tbody//tr//td[2]")
    WebElement patientName;
    @FindBy(xpath = "//ul//a//li//i[@class='icon-remove']//..")
    WebElement deletePatientButton;

    public void registerAPatientFunctionality(String givenName,String familyName,String day,String year,String address1,
                                              String city,String state,String country,String postalCode,String phoneNumber,
                                              List<String> expectedPatientInfo,String patientFullName) throws InterruptedException {
    registerAPatientButton.click();
    this.givenName.sendKeys(givenName);
    this.familyName.sendKeys(familyName);
    genderButton.click();
    maleButton.click();
    birthdateButton.click();
    this.birthdateDay.sendKeys(day);
    BrowserUtils.selectBy(birthdateMonth,"April","text");
    this.birthdateYear.sendKeys(year);
    addressButton.click();
    this.address1.sendKeys(address1);
    this.cityVillage.sendKeys(city);
    this.stateProvince.sendKeys(state);
    this.country.sendKeys(country);
    this.postalCode.sendKeys(postalCode);
    phoneNumberButton.click();
    this.phoneNumber.sendKeys(phoneNumber);
    confirmButton1.click();
        for (int i = 0; i < patientAllInformation.size(); i++) {
            Assert.assertEquals(BrowserUtils.getText(patientAllInformation.get(i)),expectedPatientInfo.get(i));
        }
    confirmButton2.click();
        Thread.sleep(2000);
    Assert.assertTrue(patientInfoDisplay.isDisplayed());
    Assert.assertTrue(patientIdentifier.isDisplayed());
    Thread.sleep(2000);
    homeButton.click();
    Thread.sleep(2000);
    findPatientRecordButton.click();
    Thread.sleep(2000);
    this.searchPatient.sendKeys(patientFullName, Keys.ENTER);
    Thread.sleep(2000);
    Assert.assertEquals(BrowserUtils.getText(patientName),patientFullName);
    Thread.sleep(2000);

    }
}
