package HomeworkSelenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class TestCase1 {
    public static void main(String[] args) throws InterruptedException {
        /*
        Navigate to "https://demoqa.com/text-box"
        Enter your full name, email, current and permanent address Click submit button.
        Validate that all of your information is displayed and matching correctly.
        TIPS:Think about if conditions.
        Example:
        Name:David
        Email: david@gmail.com
        Current Address :Random Address Permananet Address : different address
        */
        System.setProperty("webdriver.chrome.driver", "chromedriver");
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
        driver.navigate().to("https://demoqa.com/text-box");
        WebElement fullName = driver.findElement(By.xpath("//input[@id='userName']"));
        fullName.sendKeys("Tuvshuu Ochirbat");
        Thread.sleep(3000);
        WebElement eMail = driver.findElement(By.xpath("//input[@id='userEmail']"));
        eMail.sendKeys("tuvshuu@gmail.com");
        WebElement currentAddress = driver.findElement(By.xpath("//textarea[@id='currentAddress']"));
        currentAddress.sendKeys("2200 Random Address");
        WebElement permanentAddress = driver.findElement(By.xpath("//textarea[@id='permanentAddress']"));
        permanentAddress.sendKeys("2200 Permanent Address");
        WebElement submitButton = driver.findElement(By.xpath("//button[@id='submit']"));
//        Actions at = new Actions(driver);
//        at.sendKeys(Keys.PAGE_DOWN).build().perform();
        Thread.sleep(3000);
        submitButton.click();

        WebElement actualFullName = driver.findElement(By.xpath("//p[@id='name']"));
        String printedActualFullName = actualFullName.getText().trim();
        String expectedFullName = "Name:Tuvshuu Ochirbat";
        System.out.println(printedActualFullName.equals(expectedFullName) ? "Pass" : "Fail");

        WebElement actualeMail = driver.findElement(By.xpath("//p[@id='email']"));
        String printedActualeMail = actualeMail.getText().trim();
        String expectedeMail = "Email:tuvshuu@gmail.com";
        System.out.println(printedActualeMail.equals(expectedeMail) ? "Pass" : "Fail");

        WebElement actualCurrentAddress = driver.findElement(By.xpath("//p[@id='currentAddress']"));
        String printedActualCurrentAddress = actualCurrentAddress.getText().trim();
        String expectedCurrentAddress = "Current Address :2200 Random Address";
        System.out.println(printedActualCurrentAddress.equals(expectedCurrentAddress) ? "Pass" : "Fail");

        WebElement actualPermanentAddress = driver.findElement(By.xpath("//p[@id='permanentAddress']"));
        String printedActualPermanentAddress = actualPermanentAddress.getText().trim();
        String expectedPermanentAddress = "Permananet Address :2200 Permanent Address";
        System.out.println(printedActualPermanentAddress.equals(expectedPermanentAddress) ? "Pass" : "Fail");

        driver.close();

    }
}
