package MentoringWithAhmet;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class techlist {
    public static void main(String[] args) throws InterruptedException {
        /*
    1-Open this link - https://www.techlistic.com/p/selenium-practice-form.html
2-Enter first and last name (textbox).
3-Select gender (radio button).
4-Select years of experience (radio button).
5-Enter date.(send keys)
6-Select Profession (Checkbox).
7-Select Automation tools you are familiar with (multiple checkboxes).
8-Select Continent(Send Keys).
9-Click on Submit button.
10-Close the webpage
Try your own logic and automate it without any help.
     */
        System.setProperty("webdriver.chrome.driver","chromedriver");
        WebDriver driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.navigate().to("https://www.techlistic.com/p/selenium-practice-form.html");
        WebElement firstName= driver.findElement(By.name("firstname"));
        firstName.sendKeys("Munkhtuvshin");
        WebElement lastName= driver.findElement(By.name("lastname"));
        lastName.sendKeys("Ochirbat");
        WebElement genderBox=driver.findElement(By.id("sex-0"));
        if (genderBox.isDisplayed() && !genderBox.isSelected()){
            genderBox.click();
        }
        WebElement experienceBox= driver.findElement(By.id("exp-5"));
        if (experienceBox.isDisplayed() && !experienceBox.isDisplayed()){
            experienceBox.click();
        }
        WebElement date= driver.findElement(By.id("datepicker"));
        date.sendKeys("2/14/2023");
        WebElement profession1Box= driver.findElement(By.id("profession-0"));
        if (profession1Box.isDisplayed() && !profession1Box.isSelected()){
            profession1Box.click();
        }
        WebElement profession2Box= driver.findElement(By.id("profession-1"));
        if (profession2Box.isDisplayed() && !profession2Box.isSelected()){
            profession2Box.click();
        }
        WebElement atBox= driver.findElement(By.id("tool-2"));
        if (atBox.isDisplayed() && !atBox.isSelected()){
            atBox.click();
        }
        WebElement continents=driver.findElement(By.id("continents"));
        continents.sendKeys("North America");
        WebElement submitButton= driver.findElement(By.className("btn-info"));
        if (submitButton.isSelected()){
            submitButton.click();
        }
        //Thread.sleep(4000);
        driver.close();
    }
}
