package WaitTimes;

public class ImplicitlyWait {
    /*
    * We use it under DriverHelper or @BeforeMethod
    * driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(9));
    * it will throw NOSUCHELEMENT exception if it doesn't load in 9 sec
     */
}
