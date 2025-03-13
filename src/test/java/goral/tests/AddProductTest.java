package goral.tests;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import goral.pages.HomePage;

public class AddProductTest extends BaseTest {

    @Test
    public void addProductTest() {
        new HomePage(driver)
                .openShopPage()
                .openProduct("Java Selenium WebDriver")
                .addProductToCart();

    }
}
