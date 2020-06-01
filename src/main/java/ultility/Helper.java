package ultility;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class Helper {
WebDriver driver;
Actions actions;
public ultilities waitUltility;
public Helper(WebDriver driver){
    this.driver=driver;
    waitUltility=new ultilities(driver);
    actions = new Actions(driver);
}
    public void sendKeys(By locator, String data) {
        this.waitUltility.waitUntilVisibility(locator);
        this.driver.findElement(locator).sendKeys(data);
    }

    public void click(By locator) {
        this.waitUltility.waitUntilVisibility(locator);
        this.waitUltility.waitUntilClickable(locator);
        this.driver.findElement(locator).click();
    }

    public void selectItem(By locator, String text) {
        this.waitUltility.waitUntilVisibility(locator);
        this.waitUltility.waitUntilClickable(locator);
        Select select = new Select(this.driver.findElement(locator));
        select.selectByVisibleText(text);
    }
    public String getText(By locator){
        waitUltility.waitUntilVisibility(locator);
        return driver.findElement(locator).getText();
    }

    public String getTextByJS(By locator){
        this.waitUltility.waitUntilExist(locator,60);
        return (String) ((JavascriptExecutor) driver).executeScript("return arguments[0].innerText;",driver.findElement(locator));
    }
    public  void clickByJS(By locator){
    this.waitUltility.waitUntilExist(locator,60);
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();",driver.findElement(locator));

    }



  public  void movetoElement(By locator){
    WebElement locator1=driver.findElement(locator);
    actions.moveToElement(locator1);
  }


    public boolean checkElementDisplay(By locator) {
        try {
            this.waitUltility.waitUntilVisibility(locator);
            return true;
        } catch (Exception var3) {
            return false;
        }
    }

    public boolean checkElementDisplay(By locator, int waitingTime) {
        try {
            this.waitUltility.waitUntilVisibility(locator, waitingTime);
            return true;
        } catch (Exception var4) {
            return false;
        }
    }
    public boolean checkElementExist(By by, long waitingTime) {
        try {
            waitUltility.waitUntilExist(by, waitingTime);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

}
