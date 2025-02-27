package goral.tests;

import goral.pages.HomePage;
import org.testng.annotations.Test;

public class RegisterTest extends BaseTest{

    @Test
    public void registerTest(){
        System.out.println("Mock");
    }

    @Test
    public void registerUserTest(){
       new HomePage(driver).openMyAccountPage()
               .registerUser("tester@testowy.pl", "tester@testowy.pl");
    }

}
