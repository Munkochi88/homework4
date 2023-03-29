package HomeworkSelenium.Homework4.openMRS.tests;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import utils.BrowserUtils;
import utils.ConfigReader;
import utils.DriverHelper;

public class TestBaseOpenMRS {
    public WebDriver driver;
    @BeforeSuite
    @BeforeMethod
    public void setup(){
        driver = DriverHelper.getDriver();
        driver.get(ConfigReader.readProperty("codeFishUrl"));
        driver.manage().deleteAllCookies();
    }
    @AfterMethod
    public void tearDown(){
        BrowserUtils.getScreenShot(driver,"openMRS");
        //driver.quit();
    }
}
