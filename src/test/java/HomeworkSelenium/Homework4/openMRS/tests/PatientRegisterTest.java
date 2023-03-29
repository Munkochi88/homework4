package HomeworkSelenium.Homework4.openMRS.tests;

import HomeworkSelenium.Homework4.openMRS.pages.LoginPage;
import HomeworkSelenium.Homework4.openMRS.pages.RegisterAPatient;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.util.Arrays;
import java.util.List;

public class PatientRegisterTest extends TestBaseOpenMRS{
    @Parameters({"username","password","givenName","familyName","day","year","address","city","state","country","postalCode","phoneNumber","patientFullName","expectedName"})
    @Test
    public void registerPatientFunctionality(String username, String password, String givenName, String familyName, String day, String year, String address1,
                                             String city, String state, String country, String postalCode, String phoneNumber,
                                             String patientFullName,String expectedName) throws InterruptedException {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.validateAdminLoginFunctionality(username,password);
        RegisterAPatient registerAPatient = new RegisterAPatient(driver);
        registerAPatient.registerAPatientFunctionality(givenName,familyName,day,year,address1,city,state,country,postalCode,phoneNumber, Arrays.asList(expectedName,"Gender: Male","Birthdate: 30, April, 1991",
                "Address: 1 facebook dr, Des Plaines, IL, USA, 60018","Phone Number: 9876543210"),patientFullName);
    }
}
