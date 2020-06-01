//import Page.Homepage;
//import Page.LoginPage;
//import Ultility.TestBasePage;
//import io.qameta.allure.Description;
//import io.qameta.allure.Step;
//import org.testng.Assert;
//import org.testng.annotations.*;
//
//public class TestLogin extends TestBasePage {
////   static WebDriver driver;
//    static Homepage homePage;
//    public LoginPage loginPage;
//    String message ="The account sign-in was incorrect or your account is disabled temporarily. Please wait and try again later.";
//    String messageRequired ="This is a required field.";
//    String massageInvalidEmailFormat = "Please enter a valid email address (Ex: johndoe@domain.com).";
//
////    public TestLogin(WebDriver driver) {
//  //      super(driver);
//   // }
//
//    @BeforeClass
//    public void setting(){
////        WebDriverManager.chromedriver().setup();
////        ChromeOptions option = new ChromeOptions();
////        option.addArguments(new String[]{"--no-sandbox"});
////        this.driver = new ChromeDriver(option);
////        this.driver.manage().window().maximize();
//        homePage = new Homepage(driver);
//        loginPage = new LoginPage(driver);
//    }
//
////    @Test(priority = 0)
////    public void loginWithoutUsernamePass() throws InterruptedException {
////        SoftAssert soft = new SoftAssert();
////        homePage.Open().clickOnSignin();
////        loginPage.login(" "," ");
////        Thread.sleep(5000);
////        loginPage.clickBtn();
////        soft.assertEquals(messageRequired,loginPage.getMessageEmailerror());
////        soft.assertEquals(messageRequired,loginPage.getMessagePassError());
////        if (loginPage.checkCaptchaEmailLoginDisplay()) {
////            Assert.assertEquals(loginPage.getMessageCaptchaError(), messageRequired);
////        }
////        soft.assertAll();
////    }
////    @Test(priority = 1)
////    public void loginWithoutUserName(){
////        homePage.Open().clickOnSignin();
////        loginPage.login(" ","12345678a@");
////        loginPage.clickBtn();
////        Assert.assertEquals(messageRequired, loginPage.getMessageEmailerror() );
////    }
////    @Test(priority = 2)
////    public void  loginWithoutPass(){
////        homePage.Open().clickOnSignin();
////        loginPage.login("ptchuong1@gmail.com"," ");
////        loginPage.clickBtn();
////        Assert.assertEquals(messageRequired,loginPage.getMessagePassError());
////    }
////    @Test(dataProvider = "InvalidEmailFormat", priority = 3)
////    public void loginWithInvalidFormatEmail(String email, String password) {
////        homePage.Open().clickOnSignin();
////        loginPage.login(email, password);
////        loginPage.clickBtn();
////        if (loginPage.checkCaptchaEmailLoginDisplay()) {
////            Assert.assertEquals(loginPage.getMessageCaptchaError(), messageRequired);
////        } else {
////            Assert.assertEquals(loginPage.getMessageEmailerror(), massageInvalidEmailFormat);
////        }
////    }
////        @Test(dataProvider = "LoginData",dataProviderClass= DatainvalidUserPassIncorrect.class,priority = 4)
////    public void loginUserOrPassInvalid(String email, String password) {
////            homePage.Open().clickOnSignin();
////            loginPage.login(email, password);
////            loginPage.clickBtn();
////            if (loginPage.checkCaptchaEmailLoginDisplay()) {
////                Assert.assertEquals(loginPage.getMessageCaptchaError(), messageRequired);
////            } else {
////                Assert.assertEquals(loginPage.getMessage(), message);
////            }
////        }
//    @Test
//    @Description("Test Description: Login Successfull!")
//    public void loginSuccessfull() {
//        homePage.Open().clickOnSignin();
//        enterUserNamePass();
//        clickButtonLogin();
//        verifyData();
////        Assert.assertTrue(homePage.checkUserLoggedIn(), "Log in unsucessfully.Plz check!");
//    }
//
//    @DataProvider(name = "InvalidEmailFormat")
//    public static Object[][] testDataProvider() {
//        return new Object[][]{
//                {"chuongpt1", "12345687"},
//                {"Chuongpt10@@gmail.com", "1233456789"},
//                {"Chuongpt10@gmail", "1233456789"},
//                {"Chuongpt10@gmail..com", "1233456789"}
//        };
//    }
//    @Step("Login with username {0} and password {1}")
//    public void enterUserNamePass(){
//        loginPage.login("chuongpt@maillinator.com", "123456a@");
//    }
//   @Step("Click buttonLogin")
//    public  void clickButtonLogin(){
//        loginPage.clickBtn();
//   }
//   @Step("verify after Login")
//    public  void verifyData(){
//        Assert.assertFalse(homePage.checkUserLoggedIn(),"Invalid message");
//   }
//
//}
