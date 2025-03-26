package goral.tests;

import goral.utils.DriverFactory;
import goral.utils.SeleniumHelper;
import goral.utils.yamReader.YamlData;
import goral.utils.yamReader.YamlReader;

import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

import java.io.IOException;
import java.time.Duration;

public class BaseTest {

    protected WebDriver driver;
    protected static ExtentSparkReporter sparkReporter;
    protected static ExtentReports extentReports;
    protected ExtentTest test; // Każdy test będzie miał własny obiekt testowy



    YamlReader reader = new YamlReader();
    YamlData dataYaml = reader.getYamlData();

    @BeforeSuite
    public void setupReport() {
        sparkReporter = new ExtentSparkReporter("target/reports/ExtentReport.html");
        sparkReporter.config().setTheme(Theme.DARK);
        sparkReporter.config().setDocumentTitle("Test Automation Report");
        sparkReporter.config().setReportName("Regression Suite");

        extentReports = new ExtentReports();
        extentReports.attachReporter(sparkReporter);
        extentReports.setSystemInfo("Tester", "Góral");
        extentReports.setSystemInfo("Environment", "QA");
    }


    @BeforeMethod
    public void setup() throws IOException {
        driver = DriverFactory.getDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
        driver.manage().window().maximize();
        driver.get(dataYaml.getUrlString());


        test = extentReports.createTest(getClass().getSimpleName());
        test.info("Start Test: " + getClass().getSimpleName());
    }

    @AfterMethod
    public void tearDown(ITestResult result) throws InterruptedException {
        try {
            if (result.getStatus() == ITestResult.FAILURE) {
                test.fail("Test nie powiódł się: " + result.getThrowable(), SeleniumHelper.getScreenshot(driver));
            } else if (result.getStatus() == ITestResult.SUCCESS) {
                test.pass("Test zakończony sukcesem.");
            } else {
                test.skip("Test pominięty.");
            }
        } catch (IOException e) {
            test.warning("Błąd podczas robienia screenshota: " + e.getMessage());
        }

        Thread.sleep(2000);
        driver.quit();
        extentReports.flush();
    }

    @AfterSuite
    public void tearDownReport() {
        extentReports.flush();
    }

}