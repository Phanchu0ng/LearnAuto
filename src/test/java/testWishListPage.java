//import Page.*;
//import Ultility.TestBasePage;
//import Ultility.ReadProductdata;
//import Ultility.readCustomerdata;
//import data.Product;
//import io.qameta.allure.Description;
//import io.qameta.allure.Step;
//import org.testng.Assert;
//import org.testng.annotations.BeforeClass;
//import org.testng.annotations.Test;
//
//import java.util.ArrayList;
//import java.util.List;
//
//public class testWishListPage extends TestBasePage {
//    Homepage homePage;
//    LoginPage loginPage;
//    ProductDetailPage productDetailPage;
//    WishListPage wishListPage;
//    Product product1, product2,product3;
//    List<Product> listProduct;
//    Float subTotal;
//    int qty = 2;
//    String strqty = Integer.toString(qty);
//
//    @BeforeClass
//    public void data() {
//        homePage = new Homepage(driver);
//        loginPage = new LoginPage(driver);
//        productDetailPage = new ProductDetailPage(driver);
//        ReadProductdata readProductdata = new ReadProductdata();
//        product1 = readProductdata.getProduct("product1");
//        product2 = readProductdata.getProduct("product2");
//        product3=  readProductdata.getProduct("product3");
//        readCustomerdata readCustomerdata = new readCustomerdata();
//        listProduct = new ArrayList();
//        listProduct.add(product1);
//        listProduct.add(product2);
//        listProduct.add(product3);
//        wishListPage = new WishListPage(driver);
//        // Precondition: clear cart
//        cleartWishList();
//    }
//
//    public void cleartWishList() {
//        // go to login page
//        homePage.Open().clickOnSignin();
//
//        // login
//        loginPage.login("chuongpt@maillinator.com", "123456a@");
//        loginPage.clickBtn();
//
//        // check user log in successfully
//        Assert.assertTrue(homePage.checkUserLoggedIn(), "Log in unsucessfully.Plz check!");
//
//        // clear cart
//        wishListPage.openWishListPage();
//        wishListPage.removeAllProductInWishList();
//    }
//
//    @Test
//    @Description("Test and Veryfiy Add Product To Wish List")
//    public void testAddProductToWishList() throws InterruptedException {
////        SoftAssert soft = new SoftAssert();
//        // add product 1
//        addProductToWishList(listProduct);
//        verifyProductInWishList();
//    }
//
//
//    @Step("Add Product to wishlist and verify Product added successfull to wish list")
//    public void addProductToWishList(List<Product> list){
//       for (Product product:list){
//        productDetailPage.addListOfProductToWishList(product);
//       Assert.assertTrue(wishListPage.checkMessageAddToWishListSuccess());
//    }}
//    @Step("Verify product in wish list")
//    public void verifyProductInWishList(){
//        // verify products info are correct
//        for (Product product : listProduct) {
//            Assert.assertTrue(wishListPage.checkProductNameDisplayInWishList(product), "Product " + product.getName() + " is not added to wishlist!");
//            Assert.assertEquals(product.getPrice(), wishListPage.getSummaryProductPriceInWishList(product), "Price of product " + product.getName() + " is not correct");
//        }
//    }
//}