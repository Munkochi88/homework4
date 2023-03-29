package HomeworkSelenium.Homework4.TestingControl.tests;

import HomeworkSelenium.Homework4.TestingControl.pages.MainPage;
import org.testng.annotations.Test;

import java.util.Arrays;

public class TestCountries extends TestBase{

    @Test
    public void validatingFirstTestCase1() throws InterruptedException {
        MainPage mainPage = new MainPage(driver);
        mainPage.testCase1("India",4, Arrays.asList("India","United states of America","China","England"),Arrays.asList("India","United states of America","China","England"),driver);
    }
}
