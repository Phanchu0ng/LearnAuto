package Page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import ultility.Helper;
import ultility.ultilities;

public class BasePage {
    String XPATH_LOADING = "//div[@class='loading-mask'][@style='display: none;']";
    public WebDriver driver;
    public Helper actionHelper;
    public ultilities waitUltility;

    public BasePage(WebDriver driver) {
        this.driver = driver;
        this.actionHelper = new Helper(driver);
        this.waitUltility = new ultilities(driver);
    }

    public void waitLoadingInvisibility() {
        this.waitUltility.waitUntilExist(By.xpath(this.XPATH_LOADING));
    }
}
