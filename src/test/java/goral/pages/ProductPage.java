package goral.pages;

import org.checkerframework.checker.units.qual.t;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ProductPage {

    @FindBy(name = "add-to-cart")
    private WebElement addToCartButton;

    public ProductPage(WebDriver driver){
                PageFactory.initElements(driver, this);
    }

    public ProductPage addProductToCart(){
        addToCartButton.click();
        return this;
        
    }

}
