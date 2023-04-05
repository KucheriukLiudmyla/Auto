package pages;


import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends ParentPage{

    @FindBy(xpath = ".//a[@class='sc-fbYMXx cdMTVw']")
    private WebElement logOutButton;

    @FindBy(xpath = ".//div[@class='sc-bBABsx RFVA-D']")
    private WebElement PopUpLogOutButton;

    public HomePage(WebDriver webDriver) {
        super(webDriver);
    }

    @FindBy(xpath = ".//div[@class='sc-dkcEsn gtPXIn']")
    private WebElement user;

    public boolean isTabInfoUserDisplayed(){
        try{
            return webDriver.findElement(
                    By.xpath(".//div[@class='sc-hZNxer iAaveH']")).isDisplayed();
        }catch (Exception e){
            return false;
        }
    }

    public HomePage checkUserName(String userName) {
        Assert.assertEquals("Not a valid user", userName, user.getText());
        return this;
    }

    public HomePage clickOnLogOutButton() {
        clickOnElementWithWait(logOutButton);
        return this;
    }

    public MainPage clickOnPopUpLogOutButton() {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        clickOnElementWithWait(PopUpLogOutButton);
        return new MainPage(webDriver);
    }
}
