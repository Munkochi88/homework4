package SeleniumIntro;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class GetAttributePractice1 {
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", "chromedriver");
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.navigate().to("https://katalon-demo-cura.herokuapp.com/");
        driver.manage().window().maximize();
        WebElement makeAppointmentButton = driver.findElement(By.xpath("//a[@href='./profile.php#login']"));
        makeAppointmentButton.click();

        WebElement demoUsername= driver.findElement(By.xpath("//input[@aria-describedby='demo_username_label']"));
        System.out.println(demoUsername.getText());//John Doe //This will not work
        System.out.println(demoUsername.getAttribute("value"));
        System.out.println(demoUsername.getAttribute("placeholder"));
    }
}
