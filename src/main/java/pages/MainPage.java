package pages;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MainPage extends ParentPage {
    @FindBy(xpath = ".//a[@class='o2UbUNbK1LzoVuoBzSeA']")
    private WebElement myProfileButton;

    @FindBy(xpath = ".//div[@id='customProductsRow1'][1]")
    private WebElement product;

    @FindBy(xpath = ".//div[@class='XJ3KJskEeT0X4eLdNq44 tjVi7L2TI345nUB24SDE xDumRK8pnrDVsc7gXpFp']")
    private WebElement shoppingButton;

    @FindBy(xpath = ".//input[@class='lFucXz0sT__aBdEeeFBH UboKf8LW6MNCJHmZXVcT']")
    private WebElement searchFields;

    @FindBy(xpath = ".//a[@data-testid='search-icon']")
    private WebElement searchButton;

    @FindBy(xpath = ".//div[@class='brand-links']")
    private WebElement brandLinks;

    public MainPage(WebDriver webDriver) {
        super(webDriver);
    }

    public void openMainPage() {
        try {
            webDriver.get("https://www.notino.ua/");
            logger.info("Main Page was opened");
        } catch (Exception e) {
            logger.error("Can not open Main Page" + e);
            Assert.fail("Can not open Main Page" + e);
        }
    }

    public LoginPage clickOnMyProfileButton() {
        clickOnElementWithWait(myProfileButton);
        return new LoginPage(webDriver);
    }

    public ProductInfoPage addFirstProduct() {
        clickOnElement(product);
        return new ProductInfoPage(webDriver);
    }

    public ShoppingCartPage clickOnShoppingCartButton() {
        clickOnElementWithWait(shoppingButton);
        return new ShoppingCartPage(webDriver);
    }

    public MainPage enterNameProductCategories(String categories) {
        enterTextInToElement(searchFields, categories);
        return this;
    }

    public SearchResultPage clickOnSearchButton() {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        clickOnElement(searchButton);
        return new SearchResultPage(webDriver);
    }

    public MainPage checkIsRedirectMainPage() {
        checkURLContainsRelative();
        Assert.assertTrue("The brand links not displayed", isElementDisplayed(brandLinks));
        return this;
    }
}
