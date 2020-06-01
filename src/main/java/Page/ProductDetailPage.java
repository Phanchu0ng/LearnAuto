package Page;

import data.Product;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.util.List;

public class ProductDetailPage extends BasePage {
    String XPATH_CHOOSE_SIZE = "//div[@class='swatch-option text'][@option-label='%s']";
    String XPATH_CHOOSE_COLOR = "//div[@class='swatch-option color'][@option-label='%s']";
    String ID_INPUT_QTY = "qty";
    String ID_BUTTON_ADD_TO_CART = "product-addtocart-button";
    String XPATH_MESSAGE_SUCCESS = "//div[@role='alert'][./div[@data-ui-id='message-success']]";
    String XPATH_ADD_TO_WISHLIST="//div[@class='product-addto-links']//span[text()='Add to Wish List']";
    String XPATH_ADD_PRODUCT_TO_COMPARE="//div[@class='product-info-main']//span[text()='Add to Compare']";
    String XPATH_ADD_TO_COMPARELIST_SUCCESS="//div[@data-ui-id='message-success'][.//a[text()='comparison list']]";
    static WishListPage wishListPage ;
    List<Product> list;
    public ProductDetailPage(WebDriver driver) {
        super(driver);
        wishListPage = new WishListPage(driver);
    }

    public void open(String url) {
        this.driver.get(url);
    }

    public void chooseSize(String size) {
        this.actionHelper.click(By.xpath(String.format(this.XPATH_CHOOSE_SIZE, size)));
    }

    public void chooseColor(String color) {
        this.actionHelper.click(By.xpath(String.format(this.XPATH_CHOOSE_COLOR, color)));
    }

    public void inputQty(int qty) {
        this.actionHelper.sendKeys(By.id(this.ID_INPUT_QTY), String.valueOf(qty));
    }

    public void addToCart() {
        this.actionHelper.click(By.id(this.ID_BUTTON_ADD_TO_CART));
    }
    public void addProductToCart(Product product){
        open(product.getUrl());
        chooseSize(product.getSize());
        chooseColor(product.getColor());
        addToCart();
    }

    public boolean messageSuccessDisplay() {
        return actionHelper.checkElementDisplay(By.xpath(XPATH_MESSAGE_SUCCESS));
    }
    public void clickBtnAddToWishList(){
        this.actionHelper.click(By.xpath(XPATH_ADD_TO_WISHLIST));
    }
    public void addListOfProductToWishList(Product product){ {
        driver.get(product.getUrl());
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        clickBtnAddToWishList();
    }
    }
public void clickAddProductToComparee(){
        this.actionHelper.click(By.xpath(XPATH_ADD_PRODUCT_TO_COMPARE));
}
public void addProductToCompareList(Product product){
        driver.get(product.getUrl());
    try {
        Thread.sleep(2000);
    } catch (InterruptedException e) {
        e.printStackTrace();
    }
    clickAddProductToComparee();

}
    public boolean msgSuccessAddToCompareDisplay(){
        return actionHelper.checkElementDisplay(By.xpath(XPATH_ADD_TO_COMPARELIST_SUCCESS));

    }

}


