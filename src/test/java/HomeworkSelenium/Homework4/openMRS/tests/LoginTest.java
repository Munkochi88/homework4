package HomeworkSelenium.Homework4.openMRS.tests;

import HomeworkSelenium.Homework4.openMRS.pages.HomePage;
import HomeworkSelenium.Homework4.openMRS.pages.LoginPage;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class LoginTest extends TestBaseOpenMRS{
    @Parameters({"username","password"})
    @Test
    public void validatingLoginFunctionality(String username,String password) throws InterruptedException {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.validateAdminLoginFunctionality(username,password);
        HomePage homePage = new HomePage(driver);
        homePage.validatingHomePageFunctionality();
    }
}
