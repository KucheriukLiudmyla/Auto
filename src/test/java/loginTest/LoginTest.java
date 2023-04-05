package loginTest;

import baseTest.BaseTest;
import junitparams.JUnitParamsRunner;
import junitparams.Parameters;
import junitparams.naming.TestCaseName;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith(JUnitParamsRunner.class)
public class LoginTest extends BaseTest {

    private final String USERNAME = "Lusi";

    @Test
    public void validLogin(){
        mainPage.openMainPage();
        mainPage.clickOnMyProfileButton();
        loginPage.checkIsRedirectLoginPage();
        loginPage.enterEmailInToInputEmail("nixariy161@terkoer.com");
        loginPage.enterPasswordInToInputPassword("Qwerty12!@");
        loginPage.clickOnButtonLogin();
        homePage.checkUserName(USERNAME);

        Assert.assertTrue("Tab info is not displayed",
                homePage.isTabInfoUserDisplayed());
    }
    @Test
    @Parameters(method = "provideParameters")
    @TestCaseName("inValidLoginWithParameters: login = {0}, password = {1}")
    public void invalidLoginWithParameters(String login, String password){
        mainPage.openMainPage();
        mainPage.clickOnMyProfileButton();
        loginPage.checkIsRedirectLoginPage();
        loginPage.enterEmailInToInputEmail(login);
        loginPage.enterPasswordInToInputPassword(password);
        loginPage.clickOnButtonLogin();

        Assert.assertFalse("Tab info is displayed", homePage.isTabInfoUserDisplayed());
        Assert.assertTrue("Button is not displayed", loginPage.isButtonLoginDisplayed());
    }
    public static Object[][] provideParameters() {
        return new Object[][]{
                new Object[]{"nixariy161@terkoer.com", "!@"},
                new Object[]{"@nhg.vi", "Qwerty12!@"},
                new Object[]{"", ""},
        };
    }
}
