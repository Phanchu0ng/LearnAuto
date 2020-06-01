package Step;

import Page.ProductListingPage;
import Ultility.TestBasePage;
import cucumber.api.java.en.And;
import cucumber.api.java.en.When;

public class ProductListingStep {
    ProductListingPage productListingPage;
    public ProductListingStep(){
        productListingPage=new ProductListingPage(TestBasePage.getDriver());
    }
    @When("^Go to Product Listing Page (.+?)$")
    public void goToProductListingPage(String url){
        productListingPage.openProductListingPage(url);
    }
    @And("click on list display")
    public void clickOnListDisplay(){
        productListingPage.clickOnListView();
    }
    @And("^click on Sort by (.+?)$")
    public void clickOnSortBy(String value){
        productListingPage.chooserMethodSortBy(value);
    }
    @And ("Get List Price")
    public void getListPrice(){
        productListingPage.listPrice();
    }
}
