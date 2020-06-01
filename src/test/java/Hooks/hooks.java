package Hooks;

import Page.CompareProductPage;
import Page.Homepage;
import Page.LoginPage;
import Page.WishListPage;
import Ultility.TestBasePage;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import io.cucumber.datatable.DataTable;
import junit.framework.Test;

import java.util.Map;


public class hooks {

        @Before("@ClearWishList")
        public void openBrowserAndClearWishList() {
            System.out.println("before");
            TestBasePage.openBrowser();
            WishListPage wishListPage=new WishListPage(TestBasePage.getDriver());
            Homepage homepage=new Homepage(TestBasePage.getDriver());
            LoginPage loginPage = new LoginPage(TestBasePage.getDriver());
            homepage.Open().clickOnSignin();
            loginPage.login("chuongpt@maillinator.com","123456a@");
            loginPage.clickBtn();
            wishListPage.openWishListPage();
            wishListPage.removeAllProductInWishList();

        }
    @Before("@ClearCompareList")
    public void openBrowserAndClearComPare() {
        System.out.println("before");
        TestBasePage.openBrowser();
        Homepage homepage=new Homepage(TestBasePage.getDriver());
        LoginPage loginPage = new LoginPage(TestBasePage.getDriver());
        CompareProductPage compareProductPage = new CompareProductPage(TestBasePage.getDriver());
        homepage.Open().clickOnSignin();
        loginPage.login("chuongpt@maillinator.com","123456a@");
        loginPage.clickBtn();
        compareProductPage.openCoparePage();
        compareProductPage.removeAllProductFromCompareList();
    }
    @Before("@Login")
    public void openBrowser() {
        System.out.println("before");
        TestBasePage.openBrowser();
        Homepage homepage=new Homepage(TestBasePage.getDriver());
        homepage.Open().clickOnSignin();
    }
    @Before
    public  void openbrowserWithoutLogin(){
        TestBasePage.openBrowser();
    }

        @After
        public void tearDown() {
            TestBasePage.saveScreenshot();
            TestBasePage.getDriver().quit();
        }

    }
