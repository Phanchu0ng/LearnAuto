package Step;

import Page.WishListPage;
import Ultility.ReadProductdata;
import Ultility.TestBasePage;
import cucumber.api.java.en.And;
import data.Product;
import io.cucumber.datatable.DataTable;
import org.testng.Assert;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class WishListPageStep {
    WishListPage wishListPage;
    Product product1, product2;
    List<Product> listProduct;
    ReadProductdata readProductdata = new ReadProductdata();
    public WishListPageStep(){
        wishListPage = new WishListPage(TestBasePage.getDriver());
    }
    @And("Verify Product in Wish-List Page")
    public void  verifyProductInWishListPage(DataTable table){
        List <Map<String,String>> mapList = table.asMaps(String.class, String.class);
        for (Map<String, String> map:mapList){
            Product product = readProductdata.getProduct(map.get("product"));
           Assert.assertTrue(wishListPage.checkProductNameDisplayInWishList(product), "Product " + product.getName() + " is not added to wishlist!");
            Assert.assertEquals(product.getPrice(), wishListPage.getSummaryProductPriceInWishList(product), "Price of product " + product.getName() + " is not correct");
        }

        }
    }

