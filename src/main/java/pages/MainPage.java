package pages;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MainPage extends ParentPage{
    @FindBy(xpath = ".//a[@class='o2UbUNbK1LzoVuoBzSeA']")
    private WebElement myProfileButton;

    public MainPage(WebDriver webDriver) {
        super(webDriver);
    }

    public void openMainPage(){
        try{
            webDriver.get("https://www.notino.ua/");
            logger.info("Main Page was opened");
        }catch(Exception e){
            logger.error("Can not open Main Page" + e);
            Assert.fail("Can not open Main Page" + e);
        }
    }

    public void clickOnMyProfileButton() {
        clickOnElement(myProfileButton);
    }
}
