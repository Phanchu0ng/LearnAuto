package Page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import ultility.Helper;

import java.security.PublicKey;

public class RegisterPage extends BasePage{
    WebDriver driver;
   By XPATH_CREATE=By.xpath("//div[@class='panel header']//a[text()='Create an Account']");
   By ID_FIRSTNAME=By.id("firstname");
   By ID_LASTNAME=By.id("lastname");
   By ID_EMAILADDRESS=By.id("email_address");
   By ID_PASSWORD=By.id("password");
   By ID_PASSCONFIRM=By.id("password-confirmation");
   By  XPATH_BUTTONCREATEACCOUNT=By.xpath("//button[@title='Create an Account']");
 public RegisterPage(WebDriver driver){
     super(driver);
 }
 public  void clickRegister(){
     this.actionHelper.click(this.XPATH_CREATE);
 }
 public void setFirstName(String firstName){
     this.actionHelper.sendKeys(this.ID_FIRSTNAME,firstName);
 }
 public void setLastName(String lastName){
     this.actionHelper.sendKeys(ID_LASTNAME,lastName);
 }
 public  void setEmail(String email){
     this.actionHelper.sendKeys(ID_EMAILADDRESS,email);
 }
 public  void setPassWord(String pass){
     this.actionHelper.sendKeys(ID_PASSWORD,pass);
 }
 public void reSetPassWord(String confirmPass){
     this.actionHelper.sendKeys(ID_PASSCONFIRM,confirmPass);
 }
 public void clickBtnSubmit(){
     this.actionHelper.click(XPATH_BUTTONCREATEACCOUNT);
 }
 public void register(String firstName, String lastname, String email, String  pass, String confirmPass){
     this.clickRegister();
     this.setFirstName(firstName);
     this.setLastName(lastname);
     this.setEmail(email);
     this.setPassWord(pass);
     this.reSetPassWord(confirmPass);
     this.clickBtnSubmit();
}
}
