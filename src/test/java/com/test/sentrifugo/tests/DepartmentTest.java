package com.test.sentrifugo.tests;

import com.test.sentrifugo.pages.DepartmentPage;
import com.test.sentrifugo.pages.HomePage;
import com.test.sentrifugo.pages.LoginPage;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.ArrayList;
import java.util.Arrays;

public class DepartmentTest {
    @Test
    public void validateDepartmentFunctionality() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("http://demo.sentrifugo.com/index.php/");
        LoginPage loginPage = new LoginPage(driver);//for pageFactory to initialize your element
        loginPage.login("EM01","sentrifugo");
        HomePage homePage = new HomePage(driver);
        homePage.clickDepartment();
        DepartmentPage departmentPage = new DepartmentPage(driver);
        departmentPage.validateDepartmentFunctionality("IT","445","Department added successfully.");
        Thread.sleep(3000);
        departmentPage.validateAllInfo(Arrays.asList("Information Technology","IT","01/05/2001","Thomas E","America/New_York [EDT]","Orange Blossom"));
    }
}
