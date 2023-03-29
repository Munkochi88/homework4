package HomeworkSelenium;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class titletest {
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver","chromedriver");
        WebDriver driver =new ChromeDriver();
        WebDriver driver1 = new ChromeDriver();
        WebDriver driver2 = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.facebook.com/");
        driver1.get("https://twitter.com/");
        driver2.get("https://www.nba.com/");
        String actualTitle= driver.getTitle();
        String actualTitle1= driver1.getTitle();
        String actualTitle2= driver2.getTitle();
        String expectedTitle = "Facebook - log in or sign up";
        String expectedTitle1 = "Explore / Twitter";
        String expectedTitle2 = "The official site of the NBA for the latest NBA Scores, Stats & News. | NBA.com";
        System.out.println(actualTitle.equals(expectedTitle)?"Passed":"Failed");
        System.out.println(actualTitle1.equals(expectedTitle1)?"Passed":"Failed");
        System.out.println(actualTitle2.equals(expectedTitle2)?"Passed":"Failed");
        driver.close();
    }
}
