package ultility;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ultilities {
    WebDriver driver;
    int WAITING_TIME = 60;
    public ultilities(WebDriver driver){
        this.driver=driver;
    }
    public void waitUntilExist(By locator, long waitingTime) {
        WebDriverWait wait = new WebDriverWait(this.driver,waitingTime);
        wait.until(ExpectedConditions.presenceOfElementLocated(locator));
    }

    public void waitUntilVisibility(By locator) {
        WebDriverWait wait = new WebDriverWait(this.driver, (long)this.WAITING_TIME);
        wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }


    public void waitUntilVisibility(By locator, int waitingTime) {
        WebDriverWait wait = new WebDriverWait(this.driver, (long)waitingTime);
        wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

    public void waitUntilClickable(By locator) {
        WebDriverWait wait = new WebDriverWait(this.driver, (long)this.WAITING_TIME);
        wait.until(ExpectedConditions.elementToBeClickable(locator));
    }


    public void waitUntilExist(By xpath) {
    }
}
