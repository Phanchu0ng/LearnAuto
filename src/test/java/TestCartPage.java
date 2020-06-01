//import Page.*;
//import Ultility.TestBasePage;
//import Ultility.ReadProductdata;
//import Ultility.readCustomerdata;
//import data.Calculation;
//import data.Product;
//import io.qameta.allure.Step;
//import org.testng.Assert;
//import org.testng.annotations.BeforeClass;
//import org.testng.annotations.Test;
//import org.testng.asserts.SoftAssert;
//
//import java.util.ArrayList;
//import java.util.List;
//
//public class TestCartPage extends TestBasePage {
//    Homepage homePage;
//    LoginPage loginPage;
//    ProductDetailPage productDetailPage;
//    ShippingPage shippingPage;
//    PaymentPage paymentPage;
//    OrderSuccessPage orderSuccessPage;
//    AddToCart addToCart;
//    Product product1, product2;
//    data.customerInfor customerInfor;
//    String shippingMethod="Fixed";
//    List<Product> listProduct;
//    Float subTotal;
//    int qty =2;
//    String strqty=Integer.toString(qty);
//    @BeforeClass
//    public void data() {
//        homePage = new Homepage(driver);
//        loginPage = new LoginPage(driver);
//        productDetailPage = new ProductDetailPage(driver);
//        addToCart = new AddToCart(driver);
//        shippingPage = new ShippingPage(driver);
//        paymentPage = new PaymentPage(driver);
//        orderSuccessPage = new OrderSuccessPage(driver);
//        ReadProductdata readProductdata = new ReadProductdata();
//        product1 = readProductdata.getProduct("product1");
//        product2 = readProductdata.getProduct("product2");
//        readCustomerdata readCustomerdata = new readCustomerdata();
//        customerInfor = readCustomerdata.getCustomer("customer");
//        listProduct = new ArrayList();
//        listProduct.add(product1);
//        listProduct.add(product2);
//        // calculate sub total
//        subTotal = Calculation.getSubTotal(listProduct);
//
//        // Precondition: clear cart
//        cleatCart();
//    }
//    public void cleatCart() {
//        // go to login page
//        homePage.Open().clickOnSignin();
//
//        // login
//        loginPage.login("chuongpt@maillinator.com", "123456a@");
//
//        // check user log in successfully
//        Assert.assertTrue(homePage.checkUserLoggedIn(), "Log in unsucessfully.Plz check!");
//
//        // clear cart
//        addToCart.openCart();
//        addToCart.removeAllProductInCart();
//    }
//    @Test
//    public void testUpdateQuantity() throws InterruptedException {
//        SoftAssert soft = new SoftAssert();
//        // add product 1
//        addProductToCart();
//        veryFyAddProductSuccess();
//goToCartPage();
//updateQuantity();
//verifyUpdate();
//        // add product 2
//        productDetailPage.addProductToCart(product2);
//        Assert.assertTrue(productDetailPage.messageSuccessDisplay(), "Add to cart unsucessfully.Plz check!");
//        addToCart.openCart();
//        String strqty=Integer.toString(qty);
//        addToCart.updatequantity(product1.getName(),strqty);
//        Thread.sleep(500);
//        Assert.assertEquals(strqty,addToCart.getQty(product1.getName()));
//    }
//    @Step("Add 1st product to cart")
//    public void addProductToCart(){
//        productDetailPage.addProductToCart(product1);
//    }
//    @Step("Check Add product to cart Success")
//    public void veryFyAddProductSuccess(){
//        Assert.assertTrue(productDetailPage.messageSuccessDisplay(), "Add to cart unsucessfully.Plz check!");
//    }
//    @Step("Open Cart Page")
//    public  void goToCartPage(){
//        addToCart.openCart();
//    }
//    @Step("update quantity")
//    public void updateQuantity(){
//
//        addToCart.updatequantity(product1.getName(),strqty);
//        try {
//            Thread.sleep(500);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
//    }
//    @Step("verify after Update")
//    public void verifyUpdate(){
//        Assert.assertEquals(strqty,addToCart.getQty(product1.getName()));
//    }
//
//}
