package goral.tests;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import goral.pages.HomePage;

public class LogInTest extends BaseTest{

    
    @Test
    public void logInTest() {
        WebElement dashboardLink = new HomePage(driver).openMyAccountPage()
        .logInValidData("tomek@testowy.pl", "tomek@testowy.pl").getDashboardLink();
        Assert.assertEquals(dashboardLink.getText(), "Dashboard");

    }
    
    @Test
    public void logInInvalidTest(){
        WebElement dashboardLink =  new HomePage(driver).openMyAccountPage()
        .logInInvalidData("tomekeeee@testowy.pl", "tomeeeek@testowy.pl").getError();
                // Assert.assertTrue(error.getText().contains("Error: An account is already registered with your email address. Please log in."));

    }
}
