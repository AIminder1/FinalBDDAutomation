package Locators;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class NewSavingAccountLocators {
    final WebDriver driver;
    public NewSavingAccountLocators(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//h2[text()='New Business Account']")
    public WebElement newBusinessAccountTitle;

    @FindBy (xpath = "//button[text()='Open New Account']")
    public WebElement NewAccountButton;

    @FindBy(xpath = "(//a[text()='Saving'])[2]")
    public WebElement SaveAccount;


    @FindBy(id = "firstName")
    public WebElement firstName;

    @FindBy(id = "lastName")
    public WebElement lastName;

    @FindBy(id = "email")
    public WebElement email;

    @FindBy(id = "business-name")
    public WebElement businessName;

    @FindBy(id = "business-type")
    public WebElement businessType;

    @FindBy(id = "business-address")
    public WebElement businessAddress;

    @FindBy(id = "tax-id")
    public WebElement taxId;

    @FindBy(id = "state")
    public WebElement SelectState;

    @FindBy(xpath = "//button[text()='Submit']")
    public WebElement SubmitButton;
}
