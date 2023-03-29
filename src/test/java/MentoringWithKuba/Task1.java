package MentoringWithKuba;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;
import utils.BrowserUtils;

import java.time.Duration;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Task1 {
    @Test
    public void task1() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://www.lambdatest.com/selenium-playground/");
        Thread.sleep(3000);
        WebElement tablePagination = driver.findElement(By.xpath("//a[.='Table Pagination']"));
        tablePagination.click();
        WebElement selectMyRows = driver.findElement(By.cssSelector("#maxRows"));
        BrowserUtils.selectBy(selectMyRows,"5000","value");
        List<WebElement> allNames = driver.findElements(By.xpath("//tr//td[2]"));
        List<WebElement> allEmails = driver.findElements(By.xpath("//tr//td[3]"));
        List<WebElement> allNumber = driver.findElements(By.xpath("//tr//td[4]"));
        for (int i = 0; i < allNames.size(); i++) {
            Map<String ,String> allInfo = new HashMap<>();
            allInfo.put(allNames.get(i).getText(),allEmails.get(i).getText());
            System.out.println(allInfo);
        }
        for (int i = 0; i < allNumber.size(); i++) {
            Map<String,Long> map = new HashMap<>();
            map.put(allNames.get(i).getText(),Long.parseLong(allNumber.get(i).getText().replace("-","")));
            System.out.println(map);
        }
    }
}
