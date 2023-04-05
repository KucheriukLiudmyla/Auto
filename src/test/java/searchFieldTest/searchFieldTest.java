package searchFieldTest;

import baseTest.BaseTest;
import org.junit.Test;

public class searchFieldTest extends BaseTest {
    final String TEXT = "Тіло";

    @Test
    public void searchByNameProductCategories(){
        mainPage.openMainPage();
        mainPage.enterNameProductCategories("Тіло");
        mainPage.clickOnSearchButton();
        searchResultPage.checkIsRedirectToSearchResultPage();
        searchResultPage.checkSearchResults(TEXT);

    }
}
