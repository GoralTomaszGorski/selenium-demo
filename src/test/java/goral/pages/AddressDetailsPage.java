package goral.pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import goral.utils.yamReader.YamlData;
import goral.utils.yamReader.YamlReader;

public class AddressDetailsPage {

    @FindBy( xpath = ("//input[@id='billing_first_name']"))
    private WebElement firstNameInp;

    @FindBy( xpath = ("//input[@id='billing_last_name']"))
    private WebElement lastNameInp;

    @FindBy(xpath = ("//input[@id='billing_company']"))
    private WebElement companyNameInp;

    @FindBy( xpath = ("//span[@id='select2-billing_country-container']"))
    private WebElement countryContainerInp;

    @FindBy( xpath = ("//input[@class='select2-search__field']"))
    private WebElement selectCountryInp;

    @FindBy( xpath = ("//input[@id='billing_address_1']"))
    private WebElement houseNbAndStreetInp;

    @FindBy( xpath = ("//input[@id='billing_address_2']"))
    private WebElement suitNbInp;

    @FindBy( xpath = ("//input[@id='billing_postcode']"))
    private WebElement billingPostcodeInp;

    @FindBy( xpath = ("//input[@id='billing_city']"))
    private WebElement billingCityInp;

    @FindBy( xpath = ("//input[@id='billing_phone']"))
    private WebElement billingPhoneInp;

    @FindBy( xpath = ("//input[@id='billing_email']"))
    private WebElement billingEmailInp;

    @FindBy( xpath = ("//textarea[@id='order_comments']"))
    private WebElement borderCommentsInp;

    @FindBy( xpath = ("//button[@name='woocommerce_checkout_place_order']"))
    private WebElement placeOrderBtn;

    private WebDriver driver;

    public AddressDetailsPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    YamlReader reader = new YamlReader();
    YamlData dataYaml = reader.getYamlData();

    public OrderDetailsPage sendBillingDetails() throws InterruptedException {
        firstNameInp.sendKeys(dataYaml.getFirstName());
        lastNameInp.sendKeys(dataYaml.getLastName());
        companyNameInp.sendKeys(dataYaml.getCompanyName());
        countryContainerInp.click();
        selectCountryInp.sendKeys(dataYaml.getCountry());
        selectCountryInp.sendKeys(Keys.ENTER);
        houseNbAndStreetInp.sendKeys(dataYaml.getStreet()+" "+dataYaml.getBuildingNb());
        Thread.sleep(500);
        suitNbInp.sendKeys(dataYaml.getSuiteNb());
        billingPostcodeInp.sendKeys(dataYaml.getPostCode());
        billingCityInp.sendKeys(dataYaml.getCity());
        billingPhoneInp.sendKeys(dataYaml.getPhone());
        billingEmailInp.sendKeys(dataYaml.getEmail());
        borderCommentsInp.sendKeys(dataYaml.getOrderComments());
        Thread.sleep(2000);
        placeOrderBtn.click();
        return new OrderDetailsPage(driver);


    }




}
