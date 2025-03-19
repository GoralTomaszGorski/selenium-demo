package goral.tests;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import goral.pages.HomePage;
import goral.utils.DateUtil;

public class RegisterTest extends BaseTest{

    String generateEmail = "Tomek" + DateUtil.getCurrentDateTime()+ "@testowy.pl";

    @Test (priority = 1)
    public void registerUserTest(){
       WebElement dashboardLink =  new HomePage(driver).openMyAccountPage()
               .registerUserValidData(generateEmail, generateEmail)
               .getDashboardLink();
               Assert.assertTrue(dashboardLink.isDisplayed());
               Assert.assertEquals(dashboardLink.getText(), "Dashboard");  
    }

    @Test (priority = 2)
    public void registerUserWithSameTest() {
        WebElement error = new HomePage(driver).openMyAccountPage()
                .registerUserInvalidData(generateEmail, generateEmail)
                .getError();
        Assert.assertTrue(error.getText()
        .contains("Error: An account is already registered with your email address. Please log in."));
    }

    @Test (priority = 3)
    public void logInTest() {
        WebElement dashboardLink = new HomePage(driver)
                .openMyAccountPage()
                .logInValidData(generateEmail, generateEmail)
                .getDashboardLink();
        Assert.assertEquals(dashboardLink.getText(), "Dashboard");
    }

    @Test (priority = 4)
    public void logInInvalidTest() {
        new HomePage(driver)
                .openMyAccountPage()
                .logInInvalidData("tomekeeee@testowy.pl", "tomeeeek@testowy.pl")
                .getError();
    }
}
