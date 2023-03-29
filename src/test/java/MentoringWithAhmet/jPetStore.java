package MentoringWithAhmet;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;
import utils.BrowserUtils;

import java.time.Duration;
import java.util.*;

public class jPetStore {
    /*
    1-Navigate to the website "https://petstore.octoperf.com/actions/Catalog.action"
    2-Choose one category and put the product_id and name as a map format(Only one of the category) then print out
    3-Go to the main menu and choose 2 different category and choose one item from there
    4-Add them into the card
    5-Validate the total cost equals to the price at the bottom shows.
    6-Quit
 */
    @Test
    public void validateCostMathFunctionality(){
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://petstore.octoperf.com/actions/Catalog.action");
        driver.findElement(By.xpath("//area[@alt='Fish']")).click();
        Map<String,String> map = new HashMap<>();
        List<WebElement> productId = driver.findElements(By.xpath("//tr//a"));
        List<WebElement> names = driver.findElements(By.xpath("//td[2]"));
        for (int i = 0; i < productId.size(); i++) {
            map.put(BrowserUtils.getText(productId.get(i)), BrowserUtils.getText(names.get(i)));
        }
        System.out.println(map);
        driver.navigate().back();
        driver.findElement(By.xpath("//area[@alt='Dogs']")).click();
        driver.findElement(By.xpath("//a[.='K9-BD-01']")).click();
        driver.findElement(By.xpath("//a[.='EST-6']")).click();
        driver.findElement(By.xpath("//a[.='Add to Cart']")).click();
        driver.findElement(By.xpath("//a[.='Return to Main Menu']")).click();
        driver.findElement(By.xpath("//area[@alt='Fish']")).click();
        driver.findElement(By.xpath("//a[.='FI-FW-02']")).click();
        driver.findElement(By.xpath("//a[.='EST-20']")).click();
        driver.findElement(By.xpath("//a[.='Add to Cart']")).click();
        double cost1 = Double.parseDouble(BrowserUtils.getText(driver.findElement(By.xpath("//tr[2]//td[7]"))).replace("$",""));
        double cost2 = Double.parseDouble(BrowserUtils.getText(driver.findElement(By.xpath("//tr[3]//td[7]"))).replace("$",""));
        double total = cost1+cost2;
        System.out.println(total);
        driver.quit();
    }
}
