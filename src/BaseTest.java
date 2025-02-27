import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class BaseTest {   

    protected WebDriver driver;

    @BeforeMethod
    public void setup(){
    }

    @AfterMethod
    public void tearDown(){

        Thread.sleep(2000);
        driver.quit();
    }

}
