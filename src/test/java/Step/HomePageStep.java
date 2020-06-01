package Step;

import Page.Homepage;
import Ultility.TestBasePage;
import cucumber.api.java.en.Given;


public class HomePageStep {
    public Homepage homepage;

public HomePageStep(){
homepage = new Homepage(TestBasePage.getDriver());

}
    @Given("Go to Login page")
    public void goToLoginPage() {
        homepage.Open().clickOnSignin();
    }

    @Given("Go to home page")
    public void goToHomepage() {
        homepage.Open();
    }
}
