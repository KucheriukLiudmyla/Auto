package pages;

import org.openqa.selenium.WebDriver;
//import libs.TestData;
//import libs.Util;
//import org.assertj.core.api.SoftAssertions;
//import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;


public class LoginPage extends ParentPage{
    @FindBy(xpath = ".//input[@class='inp-text']")
    private WebElement inputEmail;

    @FindBy(xpath = ".//input[@type='password']")
    private WebElement inputPassword;

    @FindBy(xpath = ".//button[@class='g-recaptcha btn btn--full-width']")
    private WebElement buttonLogin;



    public LoginPage(WebDriver webDriver) {
        super(webDriver);
    }

    public void enterEmailInToInputEmail(String email) {
        enterTextInToElement(inputEmail, email);
    }

    public void enterPasswordInToInputPassword(String password) {
        enterTextInToElement(inputPassword, password);
    }

    public void clickOnButtonLogin() {
        clickOnElement(buttonLogin);
    }
}
