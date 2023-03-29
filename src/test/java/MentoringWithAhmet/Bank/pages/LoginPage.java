package MentoringWithAhmet.Bank.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
    public LoginPage(WebDriver driver){
        PageFactory.initElements(driver, this);}
    @FindBy(xpath = "//button[.='Bank Manager Login']")
    WebElement bankManagerButton;

    @FindBy(xpath = "//button[.='Customer Login']")
    WebElement customerLoginButton;
    public void clickingBankManagerButton(){
        bankManagerButton.click();
    }

    public void clickingCustomerLoginButton(){
        customerLoginButton.click();
    }
}
