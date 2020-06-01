package Step;

import Page.CompareProductPage;
import Ultility.ReadProductdata;
import Ultility.TestBasePage;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import cucumber.api.java.en.Then;
import data.Product;
import io.cucumber.datatable.DataTable;
import org.testng.Assert;

import java.util.List;
import java.util.Map;

public class ComparePageStep {
    CompareProductPage compareProductPage;
    Product product1, product2;
    ReadProductdata readProductdata = new ReadProductdata();

    public ComparePageStep(){
        compareProductPage= new CompareProductPage(TestBasePage.getDriver());
    }
    @Then("Verify Product in compare page")
    public void verifyProductInComparePage(DataTable table){
        compareProductPage.openCoparePage();
        List<Map<String,String>> mapCompareProductList = table.asMaps(String.class,String.class);
        for(Map<String,String> map :mapCompareProductList){
            Product product = readProductdata.getProduct(map.get("product"));
            Assert.assertTrue(compareProductPage.checkProductNameExistInCompareList(product),"product"+product.getName()+ "exists in compare list");
            Assert.assertEquals(compareProductPage.getProductPrice(product),product.getPrice(),"the price of product" +product.getName()+"is correctly");
        }
    }
}
