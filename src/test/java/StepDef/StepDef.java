package StepDef;

import Locators.LoginPage;
import Locators.NewSavingAccountLocators;
import Utils.Config;
import Utils.Driver;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.Alert;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class StepDef {

    Driver driver = new Driver();
    LoginPage loginPage = new LoginPage(driver.getDriver());
    NewSavingAccountLocators savingPage = new NewSavingAccountLocators(driver.getDriver());
    Actions actions;
    Select select;
    Set<String> windowIds;
    List<String> listWindow;



    @Given("I Navigate to TNB Login Page")
    public void i_navigate_to_tnb_login_page() {
        driver.getDriver().get(Config.getProperty("url"));
    }

    @When("User Enters Username as {string}")
    public void user_enters_username_as(String username) {
        loginPage.EnterUserName(username);
    }

    @When("User Enters Password as {string}")
    public void user_enters_password_as(String password) {
        loginPage.EnterPassword(password);
    }

    @When("User Clicks Login Button")
    public void user_clicks_login_button() {
        loginPage.setLoginButton();
    }

    @Then("User Should Successfully Login")
    public void user_should_successfully_login() {
        Assert.assertEquals(driver.getDriver().getTitle(),"Bank Home Page");
        driver.closeDriver();
    }


    @Given("User On TNB Home Page")
    public void userOnTNBHomePage() {
        driver.getDriver().get(Config.getProperty("url"));
        loginPage.username.sendKeys(Config.getProperty("username"));
        loginPage.password.sendKeys(Config.getProperty("password"));
        loginPage.loginButton.click();
    }

    @When("User Hover Over Open New Account")
    public void userHoverOverOpenNewAccount() {
        actions = new Actions(driver.getDriver());
        actions.moveToElement(savingPage.NewAccountButton).perform();

    }

    @And("User Clicks The New Saving Account")
    public void userClicksTheNewSavingAccount() {
        savingPage.SaveAccount.click();
    }

    @Then("User Should be Redirected to Business Account Page in New Window")
    public void userShouldBeRedirectedToBusinessAccountPageInNewWindow() {
        windowIds = driver.getDriver().getWindowHandles();
        listWindow = new ArrayList<>(windowIds);

        driver.getDriver().switchTo().window(listWindow.get(1));
        Assert.assertTrue(savingPage.newBusinessAccountTitle.isDisplayed());
    }

    @When("User Enters Firstname and Lastname")
    public void userEntersFirstnameAndLastname() {
        savingPage.firstName.sendKeys(Config.getProperty("firstname"));
        savingPage.lastName.sendKeys(Config.getProperty("lastname"));
    }

    @And("User Enters Email and Business Name")
    public void userEntersEmailAndBusinessName() {
        savingPage.email.sendKeys(Config.getProperty("email"));
        savingPage.businessName.sendKeys(Config.getProperty("business_name"));
    }

    @And("User Enters Business Type and Business Address")
    public void userEntersBusinessTypeAndBusinessAddress() {

        savingPage.businessType.sendKeys(Config.getProperty("business_type"));
        savingPage.businessAddress.sendKeys(Config.getProperty("business_address"));

    }

    @And("User Enter Tax ID and Selected Business State")
    public void userEnterTaxIDAndSelectedBusinessState() {

        savingPage.taxId.sendKeys(Config.getProperty("taxId"));
        select = new Select(savingPage.SelectState);
        select.selectByVisibleText(Config.getProperty("business_state"));
    }

    @When("User Clicks the Submitted Button")
    public void userClicksTheSubmittedButton() {

        savingPage.SubmitButton.click();

    }

    @Then("User Should See Success Message on alert and Accepts")
    public void userShouldSeeSuccessMessageOnAlertAndAccepts() {

        Alert alert = driver.getDriver().switchTo().alert();
        String message = alert.getText();
        Assert.assertEquals(message, Config.getProperty("message"));

        alert.accept();
    }

    @Then("User Should be Redirected To Home Page")
    public void userShouldBeRedirectedToHomePage() {

        windowIds = driver.getDriver().getWindowHandles();
        listWindow = new ArrayList<>(windowIds);

        driver.getDriver().switchTo().window(listWindow.get(0));
        Assert.assertEquals(driver.getDriver().getTitle(),"Bank Home Page");
        driver.closeDriver();

    }
}
