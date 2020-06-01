//import Page.*;
//import Ultility.TestBasePage;
//import Ultility.ReadProductdata;
//import data.Calculation;
//import data.customerInfor;
//import io.qameta.allure.Step;
//import org.testng.Assert;
//import org.testng.annotations.*;
//import data.Product;
//import org.testng.asserts.SoftAssert;
//
//import java.math.BigDecimal;
//import java.math.RoundingMode;
//import java.util.ArrayList;
//import java.util.List;
//
//public class TestAddToCart extends TestBasePage {
////    static WebDriver driver;
//     Homepage homePage;
//     LoginPage loginPage;
//     ProductDetailPage productDetailPage;
//     ShippingPage shippingPage;
//     PaymentPage paymentPage;
//     OrderSuccessPage orderSuccessPage;
//     AddToCart addToCart;
//     Product product1, product2;
//     customerInfor customerInfor;
//    String shippingMethod="Fixed";
//    List<Product> listProduct;
//    Float subTotal;
//    String shippingFee;
//    @BeforeClass
//    public void data() {
//        System.out.println("driver: "+ driver);
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
//        Ultility.readCustomerdata Ultility.readCustomerdata = new Ultility.readCustomerdata();
//        customerInfor = Ultility.readCustomerdata.getCustomer("customer");
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
//        loginPage.clickBtn();
//
//        // check user log in successfully
//        Assert.assertTrue(homePage.checkUserLoggedIn(), "Log in unsucessfully.Plz check!");
//
//        // clear cart
//        addToCart.openCart();
//        addToCart.removeAllProductInCart();
//    }
//
//    @Test
////@Description("Test and verify information in the Payment page")
//    public void PlaceorderSuccess() throws Exception {
//        SoftAssert soft = new SoftAssert();
//       addProductToCart();
//       goToShippingPage();
//       fillShippingInformation();
//       chooseShippingMethod();
//       getShippingFee();
//       clickOnNextButton();
//       verifySubTotal();
//       verifyProductInformation();
//       verifyShippingInFormation();
//       verifyShippingFee();
////                if (shippingPage.checkShippingAddressFormDisplay()) {
////                    shippingPage.fillShippingAddress(customerInfor.getFirstName(), customerInfor.getLastName(), customerInfor.getStress_address(), customerInfor.getCity(), customerInfor.getState(), customerInfor.getZip_code(), customerInfor.getCountry(), customerInfor.getPhone_number());
////                } else if (shippingPage.checkBtnNewAddressDisplay()) {
////                }
////                shippingPage.chooseShippingMethod(shippingMethod);
////                shippingPage.clickOnNextButton();
////                paymentPage.waitloading();
////        BigDecimal bd = new BigDecimal(subTotal).setScale(2, RoundingMode.FLOOR);
////        Assert.assertEquals(paymentPage.getSummarySubTotal(), "$" + bd, "Sub total is not correct");
////
////        // verify products info are correct
////        for (Product product : listProduct) {
////            Assert.assertTrue(paymentPage.checkProductNameDisplay(product), "Product " + product.getName() + " is not added to cart!");
////            Assert.assertEquals(product.getPrice(), paymentPage.getSummaryProductPrice(product), "Price of product " + product.getName() + " is not correct");
////            Assert.assertEquals(product.getSize(), paymentPage.getSummaryProductSize(product), "Size of product " + product.getName() + " is not correct");
////            Assert.assertEquals(product.getColor(), paymentPage.getSummaryProductColor(product), "Color of product " + product.getName() + " is not correct");
////        }
////                paymentPage.clickBtnPlaceOrder();
////                if (orderSuccessPage.checkOrderNumberDisplay()) {
////                    System.out.println("Place order successfully!");
////                    driver.quit();
////                } else {
////                    throw new Exception("Error!! Please check!!");
////                }
//            }
//
//
//            @Step("Check Add Product to Cart")
//            public void addProductToCart() {
//                for (Product product : listProduct) {
//                    productDetailPage.addProductToCart(product);
//                    Assert.assertTrue(productDetailPage.messageSuccessDisplay(), "add To Cart SuccessFul");
//                }
//            }
//            @Step("Go to Shipping page")
//                    public void goToShippingPage(){
//                addToCart.clikOnMiniCart();
//                addToCart.clickOnCheckout();
//
//                }
//                @Step("Fill Shipping information")
//    public void fillShippingInformation(){
//                    if (shippingPage.checkShippingAddressFormDisplay()) {
//                        shippingPage.fillShippingAddress(customerInfor.getFirstName(), customerInfor.getLastName(), customerInfor.getStress_address(), customerInfor.getCity(), customerInfor.getState(), customerInfor.getZip_code(), customerInfor.getCountry(), customerInfor.getPhone_number());
//                    } else if (shippingPage.checkBtnNewAddressDisplay()) {
//                    }
//                }
//    @Step("Choose Shipping method")
//                public void chooseShippingMethod(){
//        shippingPage.chooseShippingMethod(shippingMethod);
//    }
//    @Step("Get Shipping fee from Shipping Page")
//    public String getShippingFee(){
//        shippingFee= shippingPage.getShippingFeeInShippingPage(shippingMethod);
//        return shippingFee;
//    }
//    @Step("Click On Button Next to go to Payment page and waitting gor payment page load")
//    public void clickOnNextButton(){
//        shippingPage.clickOnNextButton();
//        paymentPage.waitloading();
//    }
//    @Step("Verify SubTotal")
//    public void verifySubTotal(){
//        BigDecimal bd = new BigDecimal(subTotal).setScale(2, RoundingMode.FLOOR);
//        String strbd = bd.toString().replace(".",",");
//        Assert.assertEquals(paymentPage.getSummarySubTotal(), strbd +" US$", "Sub total is not correct");
//    }
//    @Step("Verify product information")
//    public void verifyProductInformation() {
//        for (Product product : listProduct) {
//            Assert.assertTrue(paymentPage.checkProductNameDisplay(product), "Product " + product.getName() + " is not added to cart!");
//            Assert.assertEquals(product.getPrice(), paymentPage.getSummaryProductPrice(product), "Price of product " + product.getName() + " is not correct");
//            Assert.assertEquals(product.getSize(), paymentPage.getSummaryProductSize(product), "Size of product " + product.getName() + " is not correct");
//            Assert.assertEquals(product.getColor(), paymentPage.getSummaryProductColor(product), "Color of product " + product.getName() + " is not correct");
//        }
//    }
//    @Step("Verify Shipping Fee")
//        public void verifyShippingFee(){
//            Assert.assertEquals(shippingFee,paymentPage.getShippingFeePaymentPage());
//        }
//        @Step("Verify Shipping information")
//    public void verifyShippingInFormation(){
//        Assert.assertTrue(paymentPage.checkShippingInformationDisplay(customerInfor.getFirstName()), customerInfor.getFirstName()+"is exists");
//            Assert.assertTrue(paymentPage.checkShippingInformationDisplay(customerInfor.getLastName()));
//            Assert.assertTrue(paymentPage.checkShippingInformationDisplay(customerInfor.getPhone_number()));
//            Assert.assertTrue(paymentPage.checkShippingInformationDisplay(customerInfor.getStress_address()));
//            Assert.assertTrue(paymentPage.checkShippingInformationDisplay(customerInfor.getCity()));
//            Assert.assertTrue(paymentPage.checkShippingInformationDisplay(customerInfor.getCountry()));
//            Assert.assertTrue(paymentPage.checkShippingInformationDisplay(customerInfor.getZip_code()));
//        }
//
//}
