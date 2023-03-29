package SeleniumLocators;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class LocatorsIntro {
    /*
    ID LOCATOR:
     */
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver","chromedriver");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.navigate().to("file:///Users/narmandakhsumiya/Desktop/Techtorial/Techtorialhtml.html");
        WebElement header= driver.findElement(By.id("techtorial1"));
        String actualHeader= header.getText().trim();
        String expectedHeader="Techtorial Academy";
        System.out.println(actualHeader);
        System.out.println(actualHeader.equals(expectedHeader)?"Passed":"Failed");
        WebElement p = driver.findElement(By.id("details2"));
        String actualP=p.getText().trim();
        System.out.println(actualP);

        /*
        NAME LOCATOR:
         */

        WebElement firstName= driver.findElement(By.name("firstName"));
        firstName.sendKeys("Munkhtuvshin");
        WebElement lastName= driver.findElement(By.name("lastName"));
        lastName.sendKeys("Ochirbat");
        WebElement phone= driver.findElement(By.name("phone"));
        phone.sendKeys("1234567890");
        WebElement email= driver.findElement(By.name("userName"));
        email.sendKeys("munk@gmail.com");
        WebElement address1=driver.findElement(By.name("address1"));
        address1.sendKeys("1234 techtorial dr");
        WebElement address2=driver.findElement(By.name("address2"));
        address2.sendKeys("Apt 2");
        WebElement city=driver.findElement(By.name("city"));
        city.sendKeys("Chicago");
        WebElement state=driver.findElement(By.name("state"));
        state.sendKeys("IL");
        WebElement postalCode =driver.findElement(By.name("postalCode"));
        postalCode.sendKeys("12345");

        /*
        CLASS LOCATOR:
         */

        WebElement checkboxesLabel=driver.findElement(By.className("checkboxes"));
        System.out.println(checkboxesLabel.getText());

        WebElement javaBox=driver.findElement(By.id("cond1"));
        if (javaBox.isDisplayed()&&!javaBox.isSelected()){
            javaBox.click();
        }
        WebElement seleniumBox=driver.findElement(By.id("cond2"));
        if (seleniumBox.isDisplayed()&&!seleniumBox.isSelected()){
            seleniumBox.click();
        }
        WebElement testNg = driver.findElement(By.id("cond3"));
        if (testNg.isDisplayed()&&!testNg.isSelected()){
            testNg.click();
        }
        WebElement cucumber = driver.findElement(By.id("cond4"));
        if (cucumber.isDisplayed()&&!cucumber.isSelected()){
            cucumber.click();
        }

        /*
        TAG NAME LOCATOR:
         */

        WebElement version=driver.findElement(By.tagName("u"));
        String actualVersion=version.getText().trim();
        String expectedVersion="Use Java Version";
        System.out.println(actualVersion.equals(expectedVersion)?"Validation is PASSED":"Validation is FAILED");


    }
}
