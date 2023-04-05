package pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ProductInfoPage extends ParentPage {

    @FindBy(xpath = ".//button[@id='pd-buy-button']")
    private WebElement cartButton;

    @FindBy(xpath = ".//button[@class='sc-iveFHk crAZVn sc-1io4v49-3 icYEbE']")
    private WebElement goToCartButton;

    public ProductInfoPage(WebDriver webDriver) {
        super(webDriver);
    }

    public ProductInfoPage clickOnCartButton() {
            JavascriptExecutor js = (JavascriptExecutor) webDriver;

                js.executeScript("javascript:window.scrollBy(250,350)");
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        clickOnElementWithWait(cartButton);
        return this;
    }

    public ShoppingCartPage clickOnGoToCart() {
        clickOnElementWithWait(goToCartButton);
        return new ShoppingCartPage(webDriver);
    }
}
