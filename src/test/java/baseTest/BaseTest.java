package baseTest;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.log4j.Logger;
import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import pages.*;


import java.time.Duration;

public class BaseTest {
    protected WebDriver webDriver;
    protected Logger logger = Logger.getLogger(getClass());
    protected MainPage mainPage;
    protected LoginPage loginPage;
    protected HomePage homePage;
    protected ShoppingCartPage shoppingCardPage;
    protected ProductInfoPage productInfoPage;
    protected SearchResultPage searchResultPage;

    @Before
    public void setUp(){
        ChromeOptions ops = new ChromeOptions();
        ops.addArguments("--remote-allow-origins=*");
        WebDriverManager.chromedriver().setup();
        webDriver = new ChromeDriver(ops);
        webDriver.manage().window().maximize();
        webDriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        mainPage = new MainPage(webDriver);
        homePage = new HomePage(webDriver);
        loginPage = new LoginPage(webDriver);
        shoppingCardPage = new ShoppingCartPage(webDriver);
        productInfoPage = new ProductInfoPage(webDriver);
        searchResultPage = new SearchResultPage(webDriver);
    }

    @After
    public void tearDown(){
        webDriver.quit();
        logger.info("Browser was closed");
    }
}
