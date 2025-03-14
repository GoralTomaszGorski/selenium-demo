package goral.tests;

import goral.utils.DriverFactory;
import goral.utils.yamReader.YamlData;
import goral.utils.yamReader.YamlReader;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.time.Duration;

public class BaseTest {

    protected WebDriver driver;

    YamlReader reader = new YamlReader();
    YamlData dataYaml = reader.getYamlData();

    @BeforeMethod
    public void setup() {
        driver = DriverFactory.getDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
        driver.manage().window().maximize();
        driver.get(dataYaml.getUrlString());
    }

    @AfterMethod
    public void tearDown() throws InterruptedException {
        Thread.sleep(2000);
        driver.quit();
    }

}
