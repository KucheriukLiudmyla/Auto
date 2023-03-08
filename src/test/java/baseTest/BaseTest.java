package baseTest;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.log4j.Logger;
import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.HomePage;
import pages.LoginPage;
import pages.MainPage;


import java.time.Duration;

public class BaseTest {
    protected WebDriver webDriver;
    protected Logger logger = Logger.getLogger(getClass());
    protected MainPage mainPage;
    protected LoginPage loginPage;
    protected HomePage homePage;

    @Before
    public void setUp(){
        WebDriverManager.chromedriver().setup();
        webDriver = new ChromeDriver();
        webDriver.manage().window().maximize();
        webDriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        mainPage = new MainPage(webDriver);
        homePage = new HomePage(webDriver);
    }

    @After
    public void tearDown(){
        webDriver.quit();
        logger.info("Browser was closed");

    }
}
