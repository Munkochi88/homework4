package MentoringWithAhmet.Bank.tests;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import utils.BrowserUtils;
import utils.DriverHelper;

public class TestBaseBank {
    public WebDriver driver;
    @BeforeMethod
    public void setup(){
        driver = DriverHelper.getDriver();
        driver.get("https://www.globalsqa.com/angularJs-protractor/BankingProject/#/login");
    }
    @AfterMethod
    public void tearDown(){
        BrowserUtils.getScreenShot(driver,"Bank");
        driver.quit();
    }
}
