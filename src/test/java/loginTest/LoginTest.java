package loginTest;

import baseTest.BaseTest;
import org.junit.Assert;
import org.junit.Test;


public class LoginTest extends BaseTest {
    @Test
    public void validLogin(){
        mainPage.openMainPage();
        mainPage.clickOnMyProfileButton();
        loginPage.enterEmailInToInputEmail("nixariy161@terkoer.com");
        loginPage.enterPasswordInToInputPassword("Qwerty12!@");
        loginPage.clickOnButtonLogin();

        Assert.assertTrue("Button is not displayed",
                homePage.isTabInfoUserDisplayed());
    }
}
