package logOutTest;

import baseTest.BaseTest;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class LogOutTest extends BaseTest {

    private final String USERNAME = "Lusi";

    @Before
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
    public void logOut(){
        homePage.clickOnLogOutButton();
        homePage.clickOnPopUpLogOutButton();
        mainPage.checkIsRedirectMainPage();
        mainPage.clickOnMyProfileButton();
        loginPage.checkIsRedirectLoginPage();

    }

}
