package MentoringWithAhmet;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;
import utils.BrowserUtils;

import java.time.Duration;

public class SpruceInterviewQuestion {
    @Test
    public void validateFishProduct() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.navigate().to("https://www.thespruceeats.com/");
        Actions actions = new Actions(driver);
        WebElement ingredientsButton = driver.findElement(By.xpath("//a[@class='global-nav__list-item-link']//span[contains(text(),'I')]"));
        actions.moveToElement(ingredientsButton).perform();
        WebElement fishAndSeafood = driver.findElement(By.xpath("//li[@class='global-nav__sub-list-item']//a[.='Fish & Seafood']"));
        fishAndSeafood.click();
        //actions.scrollByAmount(1000,1000).perform();
        Thread.sleep(2000);
        WebElement findARecipe = driver.findElement(By.cssSelector("#search-form-input"));
        BrowserUtils.scrollWithJS(driver,findARecipe);
        Thread.sleep(4000);
        findARecipe.sendKeys("Fish for Dinner",Keys.ENTER);
        Thread.sleep(2000);
        WebElement fourStarsButton = driver.findElement(By.xpath("//label[@for='starRating_score_4Star']"));
        fourStarsButton.click();
        Thread.sleep(1000);
        WebElement editorsChoice= driver.findElement(By.xpath("//label[@for='pop_search_editor']"));
        editorsChoice.click();
        Thread.sleep(1000);
        String actualHeader = driver.findElement(By.xpath("//span[.='6-Ingredient Roasted Salmon Fillets']")).getText().trim();
        String expectedHeader = "6-Ingredient Roasted Salmon Fillets";
        Assert.assertEquals(actualHeader,expectedHeader);

    }
}
