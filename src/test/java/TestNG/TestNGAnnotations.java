package TestNG;

import org.testng.annotations.*;

public class TestNGAnnotations {
    @BeforeSuite // It will run before everything --> clear the cookies and caches
    public void beforeSuite(){
        System.out.println("I am beforeSuite annotation");
    }
    @BeforeTest
    public void beforeTest(){
        System.out.println("I am BeforeTest annotation");
    }
    @BeforeClass // It runs before every class and people use to launch their browser. driver=DriverHelper.getDriver()
    public void beforeClass(){
        System.out.println("I am before Class annotation");
    }
    @BeforeMethod //It runs before every test annotation, and it is good to use for setting up your automation
                  //TestBase Class
    public void beforeMethod(){
        System.out.println("I am before Method annotation");
    }
    @Test //It executes the code
    public void test(){
        System.out.println("I am test annotation");
    }
    @Test
    public void test1(){
        System.out.println("I am secont test annotation");
    }
    @AfterMethod //It runs after every test annotation, and is it good use for screenshot and quit your driver.
    public void afterMethod(){
        System.out.println("I am after Method annotation");
    }
    @AfterClass
    public void afterClass(){
        System.out.println("I am after Class annotation");
    }
    @AfterTest
    public void afterTest(){
        System.out.println("I am afterTest annotation");
    }
    @AfterSuite
    public void afterSuite(){
        System.out.println("I am afterSuite annotation");
    }

}
