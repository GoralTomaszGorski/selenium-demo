package goral.tests;

import org.testng.annotations.Test;

import goral.pages.HomePage;

public class AddProductTest extends BaseTest {

    @Test
    public void addProductTest() {
        new HomePage(driver)
                .openShopPage()
                .openProduct("Java Selenium WebDriver")
                .addProductToCart()
                .viewCart()
                .openAddressDetails();
    }

    @Test
    public void addProductTest2() {
        new HomePage(driver)
                .openShopPage()
                .openProduct("Java Selenium WebDriver")
                .addProductToCart()
                .viewCart()
                .openAddressDetails()
                .sendBillingDetails();
    }


}
