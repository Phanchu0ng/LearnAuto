package Page;

import data.Product;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import ultility.Helper;

import javax.crypto.interfaces.PBEKey;

public class AddToCart extends BasePage {
    String XPath_MiniCart="//div[@class='minicart-wrapper']";
    String ID_btnCheckout="top-cart-btn-checkout";
    String XPATH_GO_TO_CART="//a[@class='action viewcart']";
    String XPATH_EMPTY_CART = "//div[@class='cart-empty']";
    String XPATH_BUTTON_REMOVE_PRODUCT_CART = "//form//a[@title='Remove item']";
    String XPATH_INPUT_QUANTITY="//tbody[@class='cart item']//strong[@class='product-item-name']//a[text()='%s']//following::input[1]";
    String XPATH_BUTTON_UPDATE="//button[@class='action update']";
    public AddToCart(WebDriver driver){
   super(driver);
}
    public void openCart() {
        driver.get("https://demo.smartosc.com/checkout/cart");
    }

    public void clikOnMiniCart(){
        this.actionHelper.click(By.xpath(this.XPath_MiniCart));
     }
     public  void  clickOnCheckout(){
        this.actionHelper.click(By.id(this.ID_btnCheckout));
    }
    public void clickGoToCartDetail(){
        this.actionHelper.click(By.xpath(this.XPATH_GO_TO_CART));
    }
    public  void updatequantity(String name, String qty){
        driver.findElement(By.xpath(String.format(XPATH_INPUT_QUANTITY,name))).clear();
        this.actionHelper.sendKeys(By.xpath(String.format(XPATH_INPUT_QUANTITY,name)),qty);
        this.actionHelper.click(By.xpath(XPATH_BUTTON_UPDATE));
    }
    public String getQty(String name){
        return driver.findElement(By.xpath(String.format(XPATH_INPUT_QUANTITY,name))).getAttribute("value");
    }

    public void removeAllProductInCart() {
        while (driver.findElements(By.xpath(XPATH_EMPTY_CART)).size() == 0) {
            driver.findElement(By.xpath(XPATH_BUTTON_REMOVE_PRODUCT_CART)).click();
            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
