//import Page.Homepage;
//import Page.LoginPage;
//import Page.ProductDetailPage;
//import Page.CompareProductPage;
//import Ultility.TestBasePage;
//import Ultility.ReadProductdata;
//import data.Product;
//import io.qameta.allure.Step;
//import org.testng.Assert;
//import org.testng.annotations.BeforeTest;
//import org.testng.annotations.Test;
//
//import java.util.ArrayList;
//import java.util.List;
//
//public class testAddToCompare extends TestBasePage {
//    Homepage homepage;
//    LoginPage loginPage;
//    ProductDetailPage productDetailPage;
//    Product product1, product2,product3;
//    List<Product> listProduct;
//    CompareProductPage compareProductPage;
//
//    @BeforeTest
//    public void data(){
//        homepage = new Homepage(driver);
//        loginPage = new LoginPage(driver);
//        productDetailPage = new ProductDetailPage(driver);
//        compareProductPage = new CompareProductPage(driver);
//        ReadProductdata readProductdata= new ReadProductdata();
//        product1= readProductdata.getProduct("product1");
//        product2= readProductdata.getProduct("product2");
//        product3=readProductdata.getProduct("product3");
//        listProduct = new ArrayList();
//        listProduct.add(product1);
//        listProduct.add(product2);
//        listProduct.add(product3);
//        compareProductPage = new CompareProductPage(driver);
//        clearCompareList();
//
//
//    }
//    public void clearCompareList(){
//        //Open Homepage then click on sign in button
//        homepage.Open().clickOnSignin();
//        //Filter login information
//        loginPage.login("chuongpt@maillinator.com", "123456a@");
//        //Click on login button
//        loginPage.clickBtn();
//        compareProductPage.openCoparePage();
//        compareProductPage.removeAllProductFromCompareList();
//    }
////    @Test
//    public void testAddProductToCompareList(){
//        addProductToCompareList();
//        compareProductPage.openCoparePage();
//        checkInformationProductInCompareList();
//    }
//
//
//    @Step(" Go to product detail Page , add to compare list then check add scuess")
//    public void addProductToCompareList(){
//        for (Product product:listProduct){
//            productDetailPage.open(product.getUrl());
//            productDetailPage.clickAddProductToComparee();
//            Assert.assertTrue(productDetailPage.msgSuccessAddToCompareDisplay(), "add Product"+ product.getName()+"to compare list success!");
//        }
//    }
//  @Step(" Compare information of product in compare list")
//    public void checkInformationProductInCompareList(){
//        for(Product product:listProduct){
//            Assert.assertTrue(compareProductPage.checkProductNameExistInCompareList(product),"product" + product.getName() + "added to compare list success!");
//            Assert.assertEquals(compareProductPage.getProductPrice(product),product.getPrice(),"the prices is correctly!");
//        }
//    }
//
//}
