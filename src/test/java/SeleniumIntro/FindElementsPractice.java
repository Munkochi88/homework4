package SeleniumIntro;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.List;

public class FindElementsPractice {
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", "chromedriver");
        WebDriver driver = new ChromeDriver();
        driver.get("https://the-internet.herokuapp.com/");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        List<WebElement> links = driver.findElements(By.tagName("li"));
        int counter = 0;
        int counter1 = 0;
        for (WebElement link : links) {
            counter++;
            System.out.println(link.getText());

        }
        System.out.println("====================");
        for (WebElement link12 : links) {
            if ((link12.getText().length() >= 12)) {
                counter1++;
                System.out.println(link12.getText());
            }
        }
        System.out.println("Tolal: " + counter);
        System.out.println("length more than 12: " + counter1);
        driver.close();


    }
}
