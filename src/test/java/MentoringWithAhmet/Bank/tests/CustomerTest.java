package MentoringWithAhmet.Bank.tests;

import MentoringWithAhmet.Bank.pages.CustomerPage;
import MentoringWithAhmet.Bank.pages.LoginPage;
import org.testng.annotations.Test;

public class CustomerTest extends TestBaseBank {
    @Test
    public void validateBankFunctionalityForCustomer() throws InterruptedException {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.clickingCustomerLoginButton();
        CustomerPage customerPage = new CustomerPage(driver);
        customerPage.validateSelectingName();
        customerPage.validateSelectingAccount();
        customerPage.validateDepositFunctionality("1000");
        customerPage.validateWithdrawFunctionality("500");
        Thread.sleep(1000);
        customerPage.validateTransactionsFunctionality(driver);
        Thread.sleep(1000);
    }
}