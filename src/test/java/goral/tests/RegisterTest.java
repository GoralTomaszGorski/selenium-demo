package goral.tests;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import goral.pages.HomePage;

public class RegisterTest extends BaseTest{

    @Test
    public void registerTest(){
        System.out.println("Mock");
    }

    @Test
    public void registerUserTest(){
       WebElement dashboardLink =  new HomePage(driver).openMyAccountPage()
               .registerUser("tester3e1@testowy.pl", "tester3e1@testowy.pl").getDashboardLink();

               Assert.assertTrue(dashboardLink.isDisplayed());
               Assert.assertEquals(dashboardLink.getText(), "Dashboard");
    }

}
