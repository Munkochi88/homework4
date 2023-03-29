package SelectClass;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;
import utils.BrowserUtils;

import java.time.Duration;
import java.util.Arrays;
import java.util.List;

public class SelectPractice {
    @Test
    public void validateFirstOptoinAndPrintAllOptions() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.navigate().to("file:///Users/narmandakhsumiya/Desktop/Techtorial/Techtorialhtml.html");
        Thread.sleep(2000);
        WebElement dropDown = driver.findElement(By.xpath("//select[@name='country']"));
        dropDown.click();
        Select options = new Select(dropDown);
        String actualFirstOption = options.getFirstSelectedOption().getText().trim(); //UNITED STATES
        String expectedFirstOption = "UNITED STATES";
        Assert.assertEquals(actualFirstOption, expectedFirstOption);
        List<WebElement> allTheOptions = options.getOptions();
        int counter = 0;
        for (WebElement countryName : allTheOptions) {
            System.out.println(countryName.getText().trim());
            counter++;
        }
        options.selectByValue("11");
        Thread.sleep(2000);
        options.selectByIndex(10);
        Thread.sleep(2000);
        options.selectByVisibleText("MONGOLIA ");
        Thread.sleep(2000);
    }
    @Test
    public void multiSelect() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.navigate().to("file:///Users/narmandakhsumiya/Desktop/Techtorial/Techtorialhtml.html");
        WebElement countryBox = driver.findElement(By.cssSelector(".select"));
        Select country = new Select(countryBox);
        country.selectByVisibleText("One");
        Thread.sleep(2000);
        country.selectByValue("3");
        Thread.sleep(2000);
        country.selectByIndex(4);
        Thread.sleep(2000);
        country.deselectByVisibleText("One");
        country.deselectAll();
    }
    @Test
    public void validateOrderMessage() throws InterruptedException {
        /*
        1-Navigate to the website
        2-Select one way trip button
        3-Choose 4 passangers(1 wife-1 husband-2 kids)
        4-Validate the depart from is default "Acapulco"
        5-Choose the depart from is Paris
        6-Choose the date August 15th
        7-Choose the arrive in is San Francisco
        8-Choose the date December 15th
        10-Click first class option.
        11-Validate All the options from Airline
        12-Choose the Unified option from airline list
        13-Click Continue
        14-Validate the message at the top.There is a bug here/
        "After flight finder - No Seats Avaialble"

        NOTE:Your test should fail and say available is not matching with Available.
        NOTE2:You can use any select method value,visibleText
         */
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.navigate().to("https://demo.guru99.com/test/newtours/reservation.php");
        Thread.sleep(2000);
        WebElement oneWayButton = driver.findElement(By.xpath("//input[@value='oneway']"));
        oneWayButton.click();
        WebElement passengersOption = driver.findElement(By.xpath("//select[@name='passCount']"));
        Select passengerOption1 = new Select(passengersOption);
        passengerOption1.selectByValue("4");
        WebElement departingFromOption = driver.findElement(By.xpath("//select[@name='fromPort']"));
        Select departingFromOptions1 = new Select(departingFromOption);
        String actualDepartDefault = departingFromOptions1.getFirstSelectedOption().getText().trim();
        String expectedDepartDefault = "Acapulco";
        Assert.assertEquals(actualDepartDefault,expectedDepartDefault);
        departingFromOptions1.selectByVisibleText("Paris");
        WebElement date = driver.findElement(By.xpath("//select[@name='fromMonth']"));
        Select date1 = new Select(date);
        date1.selectByIndex(7);
        WebElement dateDay = driver.findElement(By.xpath("//select[@name='fromDay']"));
        Select dateDay1 = new Select(dateDay);
        dateDay1.selectByIndex(14);
        WebElement arrivingIn = driver.findElement(By.xpath("//select[@name='toPort']"));
        Select arrivingIn1 = new Select(arrivingIn);
        arrivingIn1.selectByValue("San Francisco");
        WebElement returningDate = driver.findElement(By.xpath("//select[@name='toMonth']"));
        Select returningDate1 = new Select(returningDate);
        returningDate1.selectByValue("12");
        WebElement returningDateDay = driver.findElement(By.xpath("//select[@name='toDay']"));
        Select returningDateDay1 = new Select(returningDateDay);
        returningDateDay1.selectByValue("15");
        WebElement firstClassButton = driver.findElement(By.xpath("//input[@value='First']"));
        firstClassButton.click();
        WebElement airline = driver.findElement(By.xpath("//select[@name='airline']"));
        Select airline1 = new Select(airline);
        List<WebElement> airline1Options=airline1.getOptions();
        List<String> expectedOptions= Arrays.asList("No Preference","Blue Skies Airlines","Unified Airlines","Pangea Airlines");
        for (int i = 0; i < airline1Options.size(); i++) {
            Assert.assertEquals(airline1Options.get(i).getText(),expectedOptions.get(i));
        }
        airline1.selectByVisibleText("Unified Airlines");
        WebElement continueButton = driver.findElement(By.xpath("//input[@type='image']"));
        continueButton.click();
        String actualMessage = driver.findElement(By.xpath("//font[@size='4']")).getText().trim();
        String expectedMessage ="After flight finder - No Seats Available";
        Assert.assertEquals(actualMessage,expectedMessage);
    }
    @Test
    public void shortCutSelectClass() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.navigate().to("https://demo.guru99.com/test/newtours/reservation.php");
        Thread.sleep(2000);
        WebElement oneWayButton = driver.findElement(By.xpath("//input[@value='oneway']"));
        oneWayButton.click();
        WebElement passengersOption = driver.findElement(By.xpath("//select[@name='passCount']"));
        BrowserUtils.selectBy(passengersOption,"3","index");

        WebElement departingFromOption = driver.findElement(By.xpath("//select[@name='fromPort']"));
        Select departingFromOptions1 = new Select(departingFromOption);
        String actualDepartDefault = departingFromOptions1.getFirstSelectedOption().getText().trim();
        String expectedDepartDefault = "Acapulco";
        Assert.assertEquals(actualDepartDefault,expectedDepartDefault);
        BrowserUtils.selectBy(departingFromOption,"Paris","text");
        WebElement date = driver.findElement(By.xpath("//select[@name='fromMonth']"));
        BrowserUtils.selectBy(date,"8","value");
        WebElement dateDay = driver.findElement(By.xpath("//select[@name='fromDay']"));
        BrowserUtils.selectBy(dateDay,"14","index");
        WebElement arrivingIn = driver.findElement(By.xpath("//select[@name='toPort']"));
        BrowserUtils.selectBy(arrivingIn,"San Francisco","value");
        WebElement returningDate = driver.findElement(By.xpath("//select[@name='toMonth']"));
        BrowserUtils.selectBy(returningDate,"12","value");
        WebElement returningDateDay = driver.findElement(By.xpath("//select[@name='toDay']"));
        BrowserUtils.selectBy(returningDateDay,"15","value");
        WebElement firstClassButton = driver.findElement(By.xpath("//input[@value='First']"));
        firstClassButton.click();
        WebElement airline = driver.findElement(By.xpath("//select[@name='airline']"));
        Select airline1 = new Select(airline);
        List<WebElement> airline1Options=airline1.getOptions();
        List<String> expectedOptions= Arrays.asList("No Preference","Blue Skies Airlines","Unified Airlines","Pangea Airlines");
        for (int i = 0; i < airline1Options.size(); i++) {
            Assert.assertEquals(airline1Options.get(i).getText(),expectedOptions.get(i));
        }
        airline1.selectByVisibleText("Unified Airlines");
        WebElement continueButton = driver.findElement(By.xpath("//input[@type='image']"));
        continueButton.click();
        WebElement message = driver.findElement(By.xpath("//font[@size='4']"));
        String actualMessage=BrowserUtils.getText(message);
        String expectedMessage ="After flight finder - No Seats Available";
        Assert.assertEquals(actualMessage,expectedMessage);
    }
}
