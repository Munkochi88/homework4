package SeleniumLocators;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class XpathRealHealthProject {
    /*
//THESE PARTS SHOULD BE DONE BY XPATH:
1-Navigate to the https://katalon-demo-cura.herokuapp.com/
2-Click Make an Appointment
3-Login the username and password provided and Login successfully
4-Choose the facility either HongKong or Seoul -->send keys
5-Click apply for hospital admission box if it is displayed and validate it is selected
6-Healthcare program 'Medicaid'
7-Visit date should be provided -->send keys
8-Put your command for this box -->send keys
9-Book your appointment
THESE PARTS SHOULD BE DONE BY CONTAINS or . XPATH METHOD
10-Validate the header is "Appointment confirmation" (if statement)
11-Print out the headers and values(only values) on your console.
12)Click go to homepage and print out url
13)Driver.quit or close.

     */
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", "chromedriver");
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.navigate().to("https://katalon-demo-cura.herokuapp.com/");
        driver.manage().window().maximize();
        WebElement makeAppointmentButton = driver.findElement(By.xpath("//a[@href='./profile.php#login']"));
        makeAppointmentButton.click();
        WebElement userName = driver.findElement(By.xpath("//input[@id='txt-username']"));
        userName.sendKeys("John Doe");
        WebElement password = driver.findElement(By.xpath("//input[@id='txt-password']"));
        password.sendKeys("ThisIsNotAPassword");
        WebElement loginButton = driver.findElement(By.xpath("//button[@id='btn-login']"));
        loginButton.click();
        WebElement facility = driver.findElement(By.xpath("//select[@id='combo_facility']"));
        facility.click();
        WebElement honkongSelecter = driver.findElement(By.xpath("//option[@value='Hongkong CURA Healthcare Center']"));
        honkongSelecter.click();
        //facility.sendKeys("Hongkong CURA Healthcare Center");
        WebElement apply = driver.findElement(By.xpath("//input[@id='chk_hospotal_readmission']"));
        apply.click();
        WebElement medicaid = driver.findElement(By.xpath("//input[@id='radio_program_medicaid']"));
        medicaid.click();
        WebElement date = driver.findElement(By.xpath("//input[@id='txt_visit_date']"));
        date.sendKeys("12/12/2023");
        WebElement comment = driver.findElement(By.xpath("//textarea[@id='txt_comment']"));
        comment.sendKeys("Hello");
        WebElement bookAppointment = driver.findElement(By.xpath("//button[@id='btn-book-appointment']"));
        bookAppointment.click();
        WebElement header = driver.findElement(By.xpath("//h2[contains(text(),'Appointment Confirmation')]"));
        String actualHeader = header.getText();
        String expectedHeader = "Appointment Confirmation";
        System.out.println(actualHeader.equals(expectedHeader) ? "Pass" : "Fail");
        WebElement facility1 = driver.findElement(By.xpath("//p[@id='facility']"));
        System.out.println(facility1.getText());
        WebElement yes = driver.findElement(By.xpath("//p[@id='hospital_readmission']"));
        System.out.println(yes.getText());
        WebElement medicaid1 = driver.findElement(By.xpath("//p[@id='visit_date']"));
        System.out.println(medicaid1.getText());
        WebElement comment1 = driver.findElement(By.xpath("//p[@id='comment']"));
        System.out.println(comment1.getText());
        WebElement goToHomepage = driver.findElement(By.xpath("//a[@href='https://katalon-demo-cura.herokuapp.com/']"));
        goToHomepage.click();
        String actualUrl = driver.getCurrentUrl();
        String expectedUrl = "https://katalon-demo-cura.herokuapp.com/";
        System.out.println(actualUrl.equals(expectedUrl) ? "URL Pass" : "URL Fail");
        driver.close();

    }
}
