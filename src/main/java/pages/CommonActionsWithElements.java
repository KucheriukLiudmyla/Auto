package pages;

import org.apache.log4j.Logger;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class CommonActionsWithElements {
    WebDriver webDriver;
    Logger logger = Logger.getLogger(getClass());
    protected WebDriverWait webDriverWait10;

    public CommonActionsWithElements(WebDriver webDriver){
        this.webDriver = webDriver;
        PageFactory.initElements(webDriver, this);
        webDriverWait10 = new WebDriverWait(webDriver, Duration.ofSeconds(10));
    }
    protected void enterTextInToElement(WebElement webElement, String text){
        try {
            webElement.clear();
            webElement.sendKeys(text);
            logger.info(text + " was inputted in to element ");
        }catch (Exception e){
            printErrorAndStopTest(e);
        }
    }

    protected void printErrorAndStopTest(Exception e){
        logger.error("Can not work with element" + e);
        Assert.fail("Can not work with element" + e);
    }

    protected void clickOnElement(WebElement webElement){
        try{
            String name = getElementName(webElement);
            webElement.click();
            logger.info(name + " Element was clicked");
        }catch(Exception e){
            printErrorAndStopTest(e);
        }
    }

    protected void clickOnElementWithWait(WebElement webElement){
        try{
            webDriverWait10.until(ExpectedConditions.elementToBeClickable(webElement));
            String name = getElementName(webElement);
            webElement.click();
            logger.info(name + " Element was clicked");
        }catch (Exception e){
            printErrorAndStopTest(e);
        }
    }

    protected boolean isElementDisplayed(WebElement webElement){
        try {
            boolean state = webElement.isDisplayed();
            String message;
            if(state){
                message = getElementName(webElement) + " Element is displayed";
            }else{
                message = getElementName(webElement) + " Element is not displayed";
            }
            logger.info(message);
            return state;
        }catch(Exception e){
            logger.info("Element is not displayed");
            return false;
        }
    }
    private String getElementName(WebElement webElement){
        try{
            return webElement.getAccessibleName();
        }catch (Exception e){
            return "";
        }
    }
}
