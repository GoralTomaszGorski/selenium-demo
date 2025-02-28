package goral.tests;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import goral.pages.HomePage;
import goral.utils.DateUtil;

public class RegisterTest extends BaseTest{


    String ganerateEmail = "Tomek" + DateUtil.getCurrentDateTime()+ "@testowy.pl";

    @Test
    public void registerTest(){
        System.out.println("Mock");
        System.out.println(DateUtil.getCurrentDateTime());
    }

    @Test
    public void registerUserTest(){
       WebElement dashboardLink =  new HomePage(driver).openMyAccountPage()
               .registerUser(ganerateEmail, ganerateEmail).getDashboardLink();

               Assert.assertTrue(dashboardLink.isDisplayed());
               Assert.assertEquals(dashboardLink.getText(), "Dashboard");  
    }

}
