package goral.tests;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import goral.pages.HomePage;
import goral.utils.DateUtil;

public class RegisterTest extends BaseTest{

    String generateEmail = "Tomek" + DateUtil.getCurrentDateTime()+ "@testowy.pl";

    @Test
    public void registerTest(){
        System.out.println("Mock");
        System.out.println(DateUtil.getCurrentDateTime());
        System.out.println(DateUtil.generateRandomNumber(1, 100));
    }

    @Test
    public void registerUserTest(){
       WebElement dashboardLink =  new HomePage(driver).openMyAccountPage()
               .registerUserValidData(generateEmail, generateEmail).getDashboardLink();
               Assert.assertTrue(dashboardLink.isDisplayed());
               Assert.assertEquals(dashboardLink.getText(), "Dashboard");  
    }

    @Test
    public void registerUserWithSameTest() {
        WebElement error = new HomePage(driver).openMyAccountPage()
                .registerUserInvalidData("tomek@testowy.pl", "tomek@testowy.pl").getError();

        Assert.assertTrue(error.getText().contains("Error: An account is already registered with your email address. Please log in."));
    }
}
