package addProductTest;

import baseTest.BaseTest;
import org.junit.After;
import org.junit.Test;

public class AddProductTest extends BaseTest {

    @Test
    public void addProductToShoppingCard(){
        mainPage.openMainPage();
        mainPage.addFirstProduct();
        productInfoPage.clickOnCartButton();
        productInfoPage.clickOnGoToCart();
        shoppingCardPage.checkIsRedirectToShoppingCartPage();
        shoppingCardPage.checkProductAddedToCart();
    }

    @After
    public void deleteProductFromCart(){
        mainPage.openMainPage();
        mainPage.clickOnShoppingCartButton();
        shoppingCardPage.checkIsRedirectToShoppingCartPage();
        shoppingCardPage.deleteProduct();

    }
}
