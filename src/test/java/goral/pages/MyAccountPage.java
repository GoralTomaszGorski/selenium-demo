package goral.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MyAccountPage {

    @FindBy(id = "reg_email")
    private WebElement regEmailInput;

    @FindBy(id = "reg_password")
    private WebElement regPasswordInput;

    @FindBy(name = "register")
    private WebElement registerButton;

    @FindBy(xpath = "//ul[@class = 'woocommerce-error']//li")
    private WebElement error;

    @FindBy(id = "username")
    private WebElement usernameInp;

    @FindBy(id = "password")
    private WebElement passwordInp;

    @FindBy(name = "login")
    private WebElement loginBtn;

    private WebDriver driver;

    public MyAccountPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    public LoggedUserPage registerUserValidData(String email, String password) {
        registerUser(email, password);
        return new LoggedUserPage(driver);
    }

    public MyAccountPage registerUserInvalidData(String email, String password) {
        registerUser(email, password);
        return this;
    }

    private void registerUser(String email, String password) {
        regEmailInput.sendKeys(email);
        regPasswordInput.sendKeys(password);
        registerButton.click();
    }

    public WebElement getError() {
        return error;
    }

    public LoggedUserPage logInValidData(String email, String password) {
        logIn(email, password);
        return new LoggedUserPage(driver);
    }

    public MyAccountPage logInInvalidData(String email, String password) {
        logIn(email, password);
        return this;
    }

    private void logIn(String email, String password) {
        usernameInp.sendKeys(email);
        passwordInp.sendKeys(password);
        loginBtn.click();
    }
}
