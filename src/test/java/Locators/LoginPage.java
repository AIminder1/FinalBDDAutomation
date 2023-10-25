package Locators;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
    final WebDriver driver;

    public LoginPage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(id = "UserName")
    public WebElement username;

    @FindBy(id = "password")
    public WebElement password;

    @FindBy(id = "login-btn")
    public WebElement loginButton;


    public void EnterUserName(String username){
        this.username.sendKeys(username);
    }
    public void EnterPassword(String password){
        this.password.sendKeys(password);
    }
    public void setLoginButton(){
        this.loginButton.click();
    }
    public void login(String username, String password){

        this.username.sendKeys(username);
        this.password.sendKeys(password);
        this.loginButton.click();
    }
}
