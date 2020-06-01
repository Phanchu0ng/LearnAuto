package Page;

import com.sun.org.apache.bcel.internal.generic.ARETURN;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import static org.openqa.selenium.By.id;
import static org.openqa.selenium.By.xpath;

public class LoginPage extends BasePage {
    String ID_email="email";
    String ID_pass="pass";
    String XPath_btnSubmitLogin="//div[@class='primary']//button[@class='action login primary']";
    String XPATH_MESSAGE_WHEN_LOGIN_FAILED="//div[@class='page messages']//div[@class='messages']//div[@data-bind='html: message.text']";
    String XPATH_MESSAGE_EMAIL_ERROR="//div[@id='email-error']";
    String XPATH_MESSAGE_PASS_ERROR="//div[@id='pass-error']";
    String ID_CAPTCHA_EMAIL_LOGIN="captcha_user_login";
    String ID_CAPTCHA_USER_LOGIN_ERROR ="captcha_user_login-error";
    public  LoginPage(WebDriver driver){
        super(driver);
    }
public void login(String email, String pass){
        this.actionHelper.sendKeys(By.id(this.ID_email),email);
        this.actionHelper.sendKeys(By.id(this.ID_pass),pass);

}
public void enterEmail(String email){
        this.actionHelper.sendKeys(By.id(ID_email),email);
}
    public void enterPass(String pass){
        this.actionHelper.sendKeys(By.id(ID_pass),pass);
    }
public void clickBtn(){
        this.actionHelper.click(xpath(this.XPath_btnSubmitLogin));
}
public String getMessage(){
        this.waitUltility.waitUntilVisibility(By.xpath(XPATH_MESSAGE_WHEN_LOGIN_FAILED),120);
        String loginInErrorMsg = driver.findElement(By.xpath(XPATH_MESSAGE_WHEN_LOGIN_FAILED)).getText();
        return loginInErrorMsg;
}
public String getMessageEmailerror() {
    this.waitUltility.waitUntilVisibility(xpath(XPATH_MESSAGE_EMAIL_ERROR));
    String emailErrorMsg =driver.findElement(By.xpath(XPATH_MESSAGE_EMAIL_ERROR)).getText();
    return  emailErrorMsg;
}
public  String getMessagePassError() {
        this.waitUltility.waitUntilVisibility(xpath(XPATH_MESSAGE_PASS_ERROR));
        String passErrorMsg =driver.findElement(By.xpath(XPATH_MESSAGE_PASS_ERROR)).getText();
        return passErrorMsg;
}
public boolean checkCaptchaEmailLoginDisplay(){
    return this.actionHelper.checkElementDisplay(By.xpath(ID_CAPTCHA_USER_LOGIN_ERROR));
}
    public  String getMessageCaptchaError() {
        this.waitUltility.waitUntilVisibility((xpath(ID_CAPTCHA_EMAIL_LOGIN)));
        String captchaErrorMsg =driver.findElement(By.id(ID_CAPTCHA_EMAIL_LOGIN)).getText();
        return captchaErrorMsg;
    }
}
