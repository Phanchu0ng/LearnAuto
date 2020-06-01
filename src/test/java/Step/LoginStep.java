package Step;

import Page.Homepage;
import Page.LoginPage;
import Ultility.TestBasePage;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.cucumber.datatable.DataTable;
import org.testng.Assert;
import sun.rmi.runtime.Log;

import java.util.Map;

public class LoginStep {
    public  LoginPage  login;
    public Homepage homepage;
public LoginStep(){
    homepage = new Homepage(TestBasePage.getDriver());
    login = new LoginPage(TestBasePage.getDriver());
}
    @And("^input Email as (.+?)$")
    public void inputEmailAs(String email) {
        login.enterEmail(email);
    }

    @And("^input Password as (.+?)$")
    public void inputPassAs(String pass) {
        login.enterPass(pass);
    }

    @And("click on SignIn button")
    public void clickOnSignInButton() {
        login.clickBtn();
    }

    @Then("verify user is logged in successfully")
    public void verifyUserIsLoggedInSuccessfully() {
        // check user log in successfully
        Assert.assertTrue(homepage.checkUserLoggedIn(),"Login Successfully successfull");
    }
    @When("Login to website with username and password")
    public void Login(DataTable table) {
        while (homepage.checkUserLoggedIn() == false) {
            Map<String, String> map = (Map) table.asMaps(String.class, String.class).get(0);
//            homepage.Open().clickOnSignin();
            login.enterEmail(map.get("email"));
            login.enterPass(map.get("pass"));
            login.clickBtn();
        }
    }
}

