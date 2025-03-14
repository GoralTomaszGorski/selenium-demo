package goral.tests;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import goral.pages.HomePage;
import goral.utils.yamReader.YamlData;
import goral.utils.yamReader.YamlReader;

public class LogInTest extends BaseTest {

        YamlReader reader = new YamlReader();
        YamlData dataYaml = reader.getYamlData();

    @Test
    public void logInTest() {
        WebElement dashboardLink = new HomePage(driver)
                .openMyAccountPage()
                .logInValidData(dataYaml.getUsername(), dataYaml.getPassword())
                .getDashboardLink();
        Assert.assertEquals(dashboardLink.getText(), "Dashboard");

    }

    @Test
    public void logInInvalidTest() {
        WebElement dashboardLink = new HomePage(driver)
                .openMyAccountPage()
                .logInInvalidData("tomekeeee@testowy.pl", "tomeeeek@testowy.pl")
                .getError();
        // Assert.assertTrue(error.getText().contains("Error: An account is already
        // registered with your email address. Please log in."));

    }
}
