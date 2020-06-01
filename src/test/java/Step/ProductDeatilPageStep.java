package Step;

import Page.CompareProductPage;
import Page.ProductDetailPage;
import Page.WishListPage;
import Ultility.ReadProductdata;
import Ultility.TestBasePage;
import cucumber.api.java.en.And;
import data.Product;
import io.cucumber.datatable.DataTable;
import org.junit.Assert;

import javax.xml.crypto.Data;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class ProductDeatilPageStep {
    ProductDetailPage productDetailPage;
    WishListPage wishListPage;
    Product product1,product2;
    List<Product> listProduct;
    ReadProductdata readProductdata = new ReadProductdata();
    CompareProductPage compareProductPage;
    public ProductDeatilPageStep(){
        productDetailPage = new ProductDetailPage(TestBasePage.getDriver());
        wishListPage = new WishListPage(TestBasePage.getDriver());
        compareProductPage = new CompareProductPage(TestBasePage.getDriver());
        System.out.println("addProductToWishList");
    }
    @And("click add product to wishlist")
    public void addProductToWishList(DataTable dataTable){
        List<Map<String,String>> mapList= dataTable.asMaps(String.class,String.class);
        for(Map<String,String> map:mapList){
        Product product=readProductdata.getProduct(map.get("product"));
            productDetailPage.addListOfProductToWishList(product);
            Assert.assertTrue("add product"+product.getName()+ "sucessfully",wishListPage.checkMessageAddToWishListSuccess());
        }
    }
    @And("Click add product to compare list")
    public  void addProductToCompareList(DataTable table){
        List<Map<String,String>> compareList = table.asMaps(String.class,String.class);
        for(Map<String,String> map:compareList){
            Product product =readProductdata.getProduct(map.get("product"));
            productDetailPage.addProductToCompareList(product);
            Assert.assertTrue("Add product"+product.getName()+"successfull",productDetailPage.msgSuccessAddToCompareDisplay());
        }
    }
}
