package goral.tests;

import goral.pages.OrderDetailsPage;
import org.testng.Assert;
import org.testng.annotations.Test;
import goral.pages.HomePage;

public class AddProductTest extends BaseTest {
    private OrderDetailsPage orderDetailsPage;

    //rename login test
    //add selenium helepr
    //add browser checker
    //add logs and raports

    @Test(priority = 1)
    public void addProductTest() {
        new HomePage(driver)
                .openShopPage()
                .openProduct("Java Selenium WebDriver")
                .addProductToCart()
                .viewCart()
                .openAddressDetails();
    }

    @Test(priority = 2)
    public void sendBillingDetailsTest() throws InterruptedException {
        new HomePage(driver)
                .openShopPage()
                .openProduct("BDD Cucumber")
                .addProductToCart()
                .viewCart()
                .openAddressDetails()
                .sendBillingDetails();
    }

    @Test(priority = 3)
    public void checkoutTest() throws InterruptedException {
        OrderDetailsPage orderDetailsPage = new HomePage(driver)
                .openShopPage()
                .openProduct("Java Selenium WebDriver")
                .addProductToCart()
                .viewCart()
                .openAddressDetails()
                .sendBillingDetails();
        Assert.assertEquals(
                        "Thank you. Your order has been received.",
                orderDetailsPage.getOrderNotice().getText()
        );
        Assert.assertEquals(
                        "Java Selenium WebDriver",
                orderDetailsPage.getProductName().getText()
        );
    }

}