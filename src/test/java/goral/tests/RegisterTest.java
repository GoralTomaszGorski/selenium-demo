package goral.tests;

import goral.pages.HomePage;
import goral.yamReader.YamlData;
import goral.yamReader.YamlReader;

import org.testng.annotations.Test;

public class RegisterTest extends BaseTest {

    YamlReader reader = new YamlReader();
    YamlData dataYaml = reader.getYamlData();

    @Test
    public void registerTest() {
        System.out.println("Mock");
    }

    @Test
    public void registerUserTest() {
        new HomePage(driver)
                .openMyAccountPage()
                .registerUser((dataYaml.getUsername()), (dataYaml.getPassword()));
    }

}
