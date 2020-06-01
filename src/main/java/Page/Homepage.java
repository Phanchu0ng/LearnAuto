package Page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Homepage extends BasePage{

//    String URL="https://demo.smartosc.com/";
    String XPATH_LINK_SIGN_IN = "//div[@class='panel header']//li[@class='authorization-link']/a";
    String XPATH_LOGGED_IN = "//div[@class='panel header']//span[@class='logged-in']";
    public Homepage(WebDriver driver){
        super(driver);
    }
    public Homepage Open(){
        this.driver.get("https://demo.smartosc.com/");
        return this;
    }
    public Homepage clickOnSignin(){
        this.actionHelper.click(By.xpath(this.XPATH_LINK_SIGN_IN));
        return this;
    }
    public boolean checkUserLoggedIn(){
        return this.actionHelper.checkElementDisplay(By.xpath(this.XPATH_LOGGED_IN));
    }


}
