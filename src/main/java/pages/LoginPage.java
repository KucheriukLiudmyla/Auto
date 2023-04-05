package pages;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;


public class LoginPage extends ParentPage {
    @FindBy(xpath = ".//input[@class='inp-text']")
    private WebElement inputEmail;

    @FindBy(xpath = ".//input[@type='password']")
    private WebElement inputPassword;

    @FindBy(xpath = ".//button[@class='g-recaptcha btn btn--full-width']")
    private WebElement buttonLogin;


    public LoginPage(WebDriver webDriver) {
        super(webDriver);
    }

    protected MainPage mainPage = new MainPage(webDriver);

    public void enterEmailInToInputEmail(String email) {
        enterTextInToElement(inputEmail, email);
    }

    public void enterPasswordInToInputPassword(String password) {
        enterTextInToElement(inputPassword, password);
    }

    public void clickOnButtonLogin() {
        clickOnElement(buttonLogin);
    }

    @Override
    String getRelativeURL() {
        return "/account/login";
    }

    public LoginPage checkIsRedirectLoginPage() {
        checkURL();
        Assert.assertTrue("LoginPage is not loaded"
                , isElementDisplayed(buttonLogin));
        return this;
    }

    public boolean isButtonLoginDisplayed() {
        try {
            return buttonLogin.isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }
}

