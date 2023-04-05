package pages;

import org.hamcrest.CoreMatchers;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;

public class ParentPage extends CommonActionsWithElements {
    protected String base_url = "https://www.notino.ua";

    public ParentPage(WebDriver webDriver) {
        super(webDriver);
    }

    String getRelativeURL() {
        return "";
    }

    protected void checkURL() {
        Assert.assertEquals("Invalid page"
                , base_url + getRelativeURL(), webDriver.getCurrentUrl());
    }

    protected void checkURLContainsRelative(){
        Assert.assertThat("Invalid page", webDriver.getCurrentUrl()
                , CoreMatchers.containsString(base_url + getRelativeURL()));
    }
}
