package HomeworkSelenium.Homework4.TestingControl.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import utils.BrowserUtils;

import java.util.List;

public class MainPage {
    public MainPage(WebDriver driver){
        PageFactory.initElements(driver, this);
    }
    @FindBy(css = "#countriesSingle")
    WebElement countriesSingleSelection;
    @FindBy(xpath = "//select[@id='countriesMultiple']")
    WebElement countriesMultipleSelection;
    @FindBy(xpath = "//select[@id='countriesMultiple']//option[@value='india']")
    WebElement india;
    @FindBy(xpath = "//select[@id='countriesMultiple']//option[@value='usa']")
    WebElement usa;
    @FindBy(xpath = "//select[@id='countriesMultiple']//option[@value='china']")
    WebElement china;
    @FindBy(xpath = "//select[@id='countriesMultiple']//option[@value='england']")
    WebElement england;
    @FindBy(xpath = "//div[@id='result']")
    WebElement selectedCountries;
    public void testCase1(String expectedDefaultSelectedCountry,Integer expectedSize,List<String> expectedValues,List<String> expectedValues1,WebDriver driver) throws InterruptedException {
        Select select = new Select(countriesSingleSelection);
        Assert.assertEquals(select.getFirstSelectedOption().getText(),expectedDefaultSelectedCountry);
        Assert.assertEquals(select.getOptions().size(),expectedSize);
        List<WebElement> actualValues = select.getOptions();
        for (int i = 0;i< actualValues.size();i++){
            Assert.assertEquals(BrowserUtils.getText(actualValues.get(i)),expectedValues.get(i));
        }
        BrowserUtils.selectBy(countriesSingleSelection,"2","index");
        Thread.sleep(1000);
        BrowserUtils.selectBy(countriesSingleSelection,"england","value");
        Thread.sleep(1000);
        BrowserUtils.selectBy(countriesSingleSelection,"United states of America","text");

        Select select1 = new Select(countriesMultipleSelection);
        List<WebElement> actualValues1 = select1.getOptions();
        for (int i = 0;i<actualValues1.size();i++){
            Assert.assertEquals(BrowserUtils.getText(actualValues1.get(i)),expectedValues1.get(i));
        }
        Actions actions = new Actions(driver);
        actions.clickAndHold(china).moveToElement(england).release().perform();
        Assert.assertEquals(BrowserUtils.getText(selectedCountries),"China England");
        select1.deselectAll();
        actions.clickAndHold(india).moveToElement(england).release().perform();
        Assert.assertEquals(BrowserUtils.getText(selectedCountries),"India United states of America China England");
        select1.deselectByIndex(2);
        select1.deselectByValue("england");
    }

}
