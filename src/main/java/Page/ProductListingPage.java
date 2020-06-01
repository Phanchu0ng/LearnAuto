package Page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import java.security.PublicKey;
import java.util.*;

public class ProductListingPage extends BasePage {
    String ID_LIST_VIEW = "mode-list";
    String XPATH_LIST_VIEW = "//div[@class='toolbar toolbar-products'][1]//a[@id='mode-list']";
    String XPATH_SORT_BY = "(//div[@class='toolbar-sorter sorter']//select[@class='sorter-options'])[1]";
    String XPATH_PRODUCT_PRICES = "//li[@class='item product product-item']//span[@class='price']";
    String XPATH_BUTTON_NEXT = "(//ul[@class='items pages-items']//a[@class='action  next'])[2]";
    String XPATH_PRODUCT_PRICE = "(//li[@class='item product product-item']//span[@class='price'])[%s]";
    String XPATH_CLICK_ON_COLOR="//div[@class='filter-options-title'][normalize-space(text())='Color']";
    String XPATH_CHOOSE_FILTER_COLOR ="//div[@class='filter-options-content']//div[@attribute-id='93']//a[@aria-label='%s']";
    String XPATH_COLOR_LIST_PRODUCT="//div[@class='product-item-info']//div[@class='swatch-attribute color']//div[@option-label='%s']";
    String XPATH_PRODUCT_COLOR="(//div[@class='product-item-info']//div[@class='swatch-attribute color']//div[@option-label='%s'])[%s]";
    public ProductListingPage(WebDriver driver) {
        super(driver);
    }

    public void openProductListingPage(String url) {
        this.driver.get(url);
    }

    public void clickOnListView() {
        while (this.actionHelper.checkElementDisplay(By.xpath(XPATH_LIST_VIEW)) == false) {
            this.actionHelper.click(By.xpath(XPATH_LIST_VIEW));
        }
    }

    public void chooserMethodSortBy(String value) {
        Select drpMethodSortBy = new Select(driver.findElement(By.xpath(XPATH_SORT_BY)));
        drpMethodSortBy.selectByValue(value);

    }

    public boolean checkButtonNextDisplay() {
        return actionHelper.checkElementDisplay(By.xpath(XPATH_BUTTON_NEXT));
    }

    public void listPrice() {
        String url =driver.getCurrentUrl();
        List<String> priceList = new LinkedList<>();
        for (int i = 1; i <= driver.findElements(By.xpath(XPATH_PRODUCT_PRICES)).size(); i++) {
            priceList.add((driver.findElement(By.xpath(String.format(XPATH_PRODUCT_PRICE, i))).getText().replace("US$", "").replace(",", ".")));
        }
        while (checkButtonNextDisplay() == true) {
            System.out.println("abc");
            actionHelper.click(By.xpath(XPATH_BUTTON_NEXT));
            String currentUrl=driver.getCurrentUrl();
             if(currentUrl!=url){
            for (int i = 1; i <= driver.findElements(By.xpath(XPATH_PRODUCT_PRICES)).size(); i++) {
                priceList.add((driver.findElement(By.xpath(String.format(XPATH_PRODUCT_PRICE, i))).getText().replace("US$", "").replace(",", ".")));
            }
                 url=currentUrl;
             }
        }
        System.out.println(priceList);
        if (this.actionHelper.checkElementDisplay(By.xpath("//a[@title='Set Ascending Direction']")) == true) {
            for (int i = 0; i < priceList.size()-1; i++) {
                if (Float.parseFloat(priceList.get(i)) >= Float.parseFloat(priceList.get(i+1))) {

                } else {
                    Assert.assertFalse(true);
                }
            }
        } else {
            for (int i = 0; i < priceList.size()-1; i++) {
                if (Float.parseFloat(priceList.get(i)) <= Float.parseFloat(priceList.get(i+1))) {
                } else {
                    Assert.assertFalse(true);
                }
            }
            System.out.println(priceList);
        }
    }
    public void clickOnColor(){
        String atr=driver.findElement(By.xpath(XPATH_CLICK_ON_COLOR)).getAttribute("aria-expanded");
        if(atr.equals(false)){
            this.actionHelper.click(By.xpath(XPATH_CLICK_ON_COLOR));
        }

    }
    public void chooseColorToFilter(String color){
        this.actionHelper.click(By.xpath(String.format(XPATH_CHOOSE_FILTER_COLOR,color)));
    }
    public void verifyListResultFilter(String color){
        List<String> listProductColor = new ArrayList<String>();
        for(int i=1;i <=driver.findElements(By.xpath(XPATH_COLOR_LIST_PRODUCT)).size();i++){
            this.actionHelper.checkElementDisplay(By.xpath(String.format(XPATH_PRODUCT_COLOR,color,i)));
            String valueStr=driver.findElement(By.xpath(String.format(XPATH_PRODUCT_COLOR,color,i))).getAttribute("aria-checked");
            if(valueStr.equals("true")){

            }else {
                Assert.assertFalse(true);
            }
        }

    }
}
