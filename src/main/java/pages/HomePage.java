package pages;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage extends ParentPage{
    public HomePage(WebDriver webDriver) {
        super(webDriver);
    }

    public boolean isTabInfoUserDisplayed(){
        try{
            return webDriver.findElement(
                    By.xpath(".//div[@class='sc-hZNxer iAaveH']")).isDisplayed();
        }catch (Exception e){
            return false;
        }
    }
}
