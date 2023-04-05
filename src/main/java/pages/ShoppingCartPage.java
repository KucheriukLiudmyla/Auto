package pages;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ShoppingCartPage extends ParentPage{

    @FindBy(xpath = ".//h1[@class='sc-bcXHqe sc-hINMOq eLmsJY cpgCau']")
    private WebElement nameHeader;

    @FindBy(xpath = ".//div[@class='sc-kkCwLU fPQirr']")
    private WebElement productCart;

    @FindBy(xpath = ".//div[@class='sc-lbVpMG fFyPDB sc-cHGmPC kUquQP remove']")
    private WebElement deleteButton;

    public ShoppingCartPage(WebDriver webDriver) {
        super(webDriver);
    }
    @Override
    String getRelativeURL() {
        return "/cart/";
    }

    public ShoppingCartPage checkIsRedirectToShoppingCartPage() {
        checkURL();
        Assert.assertTrue("Shopping cart page is not loaded"
                , isElementDisplayed(nameHeader));
        return this;
    }

    public ShoppingCartPage checkProductAddedToCart() {
        Assert.assertTrue("Product not added", isElementDisplayed(productCart));
        return this;
    }

    public ShoppingCartPage deleteProduct() {
        clickOnElementWithWait(deleteButton);
        return this;
    }
}
