package pages;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SearchResultPage extends ParentPage{

    @FindBy(xpath = ".//div[@class='search-results']")
    private WebElement searchResultBlock;

    @FindBy(xpath = ".//strong['тіло'][1]")
   private WebElement element;

    public SearchResultPage(WebDriver webDriver) {
        super(webDriver);
    }

    @Override
    String getRelativeURL() {
        return "/search.asp?exps=";
    }

    public SearchResultPage checkIsRedirectToSearchResultPage() {
        checkURLContainsRelative();
        Assert.assertTrue("SearchResultPage is not loaded", isElementDisplayed(searchResultBlock));
        return this;
    }

    public SearchResultPage checkSearchResults(String testHeader) {
        Assert.assertEquals("The search results is absent", testHeader, element.getText());
        return this;
    }
}
