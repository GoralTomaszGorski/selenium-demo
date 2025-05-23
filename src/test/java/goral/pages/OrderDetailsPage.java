package goral.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OrderDetailsPage {

    @FindBy( xpath = ("//p[@class='woocommerce-notice woocommerce-notice--success woocommerce-thankyou-order-received']"))
    private WebElement orderNotice;

    @FindBy( xpath = ("//td[contains (@class, 'product-name')]//a"))
    private WebElement productName;

    public OrderDetailsPage(WebDriver driver){
        PageFactory.initElements(driver, this);
    }

    public WebElement getOrderNotice() {
        return orderNotice;
    }

    public WebElement getProductName() {
        return productName;
    }


}