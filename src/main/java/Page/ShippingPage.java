package Page;

import com.sun.javafx.binding.StringFormatter;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import ultility.Helper;
import ultility.ultilities;

import java.security.PublicKey;

public class ShippingPage  extends BasePage{
    String XPATH_BUTTON_NEW_ADDRESS = "//div[@class='new-address-popup']/button";
    String XPATH_BUTTON_SHIP_HERE = "//button[@class='action primary action-save-address']";
    String NAME_INPUT_FIRST_NAME = "firstname";
    String NAME_INPUT_LAST_NAME = "lastname";
    String NAME_INPUT_STREET = "street[0]";
    String NAME_INPUT_CITY = "city";
    String NAME_INPUT_STATE = "region_id";
    String NAME_INPUT_ZIPCODE = "postcode";
    String NAME_INPUT_COUNTRY = "country_id";
    String NAME_INPUT_PHONE_NUMBER = "telephone";
    String XPATH_SHIPPING_METHOD = "//tr[.//td[text()='%s']]//input";
    String XPATH_BUTTON_NEXT = "//button[@data-role='opc-continue']";
    String XPATH_SHIPPING_AMOUNT="//td[@class='col col-price']/span/span[@class='price']";
    public ShippingPage(WebDriver driver){
        super(driver);
    }
    public boolean checkShippingAddressFormDisplay(){
        return this.actionHelper.checkElementDisplay(By.name(this.NAME_INPUT_FIRST_NAME));
    }
    public  boolean checkBtnNewAddressDisplay(){
        return this.actionHelper.checkElementDisplay(By.xpath(this.XPATH_BUTTON_NEW_ADDRESS));
    }
    public void clickOnNewAddressButton() {
        this.actionHelper.click(By.xpath(this.XPATH_BUTTON_NEW_ADDRESS));
    }
    public void clickOnShipHereButton() {
        this.actionHelper.click(By.xpath(this.XPATH_BUTTON_SHIP_HERE));
    }
    public void fillShippingAddress(String firstName, String lastName, String streetAddress, String city, String state, String zipCode, String country, String phoneNumber) {
        this.actionHelper.sendKeys(By.name(this.NAME_INPUT_FIRST_NAME), firstName);
        this.actionHelper.sendKeys(By.name(this.NAME_INPUT_LAST_NAME), lastName);
        this.actionHelper.sendKeys(By.name(this.NAME_INPUT_STREET), streetAddress);
        this.actionHelper.sendKeys(By.name(this.NAME_INPUT_CITY), city);
        this.actionHelper.selectItem(By.name(this.NAME_INPUT_STATE), state);
        this.actionHelper.sendKeys(By.name(this.NAME_INPUT_ZIPCODE), zipCode);
        this.actionHelper.selectItem(By.name(this.NAME_INPUT_COUNTRY), country);
        this.actionHelper.sendKeys(By.name(this.NAME_INPUT_PHONE_NUMBER), phoneNumber);
    }
    public void chooseShippingMethod(String method){
        this.actionHelper.click(By.xpath(String.format(this.XPATH_SHIPPING_METHOD,method)));

    }
    public  void clickOnNextButton(){
//        this.waitLoadingInvisibility();
        this.actionHelper.click(By.xpath(this.XPATH_BUTTON_NEXT));
    }
    public String getShippingFeeInShippingPage(String method){
        return  this.actionHelper.getText(By.xpath(String.format(XPATH_SHIPPING_AMOUNT,method)));
    }

}
