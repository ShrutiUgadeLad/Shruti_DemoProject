package stepDef;

import io.cucumber.java.en.When;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.Given;
import net.serenitybdd.annotations.Steps;
import utilities.ConfigFileReader;
import missions.LoginMisson;

public class loginStepDef {
    @Steps
    LoginMisson loginMission;

    @Given("launch the saucedemo url")
    public void launchTheSauceDemoUrl() {
        String url = ConfigFileReader.getPropertyValue("loginUrl") ;
        loginMission.launchUrl(url);
    }

    @Then("user should be on saucedemo webpage")
    public void userShouldBeOnSauceDemoWebPage() {
        loginMission.verifyTitleOfWebPage();
    }

    @Then("username field should be present and editable")
    public void usernameFieldShouldBePresentAndEditable() { loginMission.verifyUserNameField();
    }

    @And("password field should be present and editable")
    public void passwordFieldShouldBePresentAndEditable() {
        loginMission.verifyPasswordField();
    }

    @And("login button field should be present and clickable")
    public void loginButtonFieldShouldBePresentAndClickable() {
        loginMission.verifyLoginButton();
    }

    @When("user enter {string} value in username")
    public void userEnterInUsername(String dataType) {
        loginMission.enterDataInUserName(dataType);
    }

    @Then("error message should get displayed")
    public void errorMessageShouldGetDisplayed() {
        loginMission.verifyErrorMessageForInvalidUserNamePassword();
    }

    @And("user enter {string} value in password")
    public void userEnterInPassword(String dataType) {
        loginMission.enterDataInPassword(dataType);;
    }

    @When("user click on login button")
    public void userClickOnLoginButton() {
        loginMission.clickOnLoginButton();
    }

    @Then("error message should get displayed for blank username")
    public void errorMessageShouldGetDisplayedForBlankUsername() {
        loginMission.verifyErrorMessageForBlankUserNamePassword();
    }

    @Then("user should navigate to Swag Lab main page")
    public void userShouldNavigateToSwagLabMainPage() {
        loginMission.verifySwagLabMainPage();
    }

    @Given("user login to swag lab")
    public void userLoginToSwagLab() {
        loginMission.loginSwagLabs();
    }

    @And("user add {string} in cart and proceed to checkout")
    public void userAddInCartAndProceedToCheckout(String arg0) {
        loginMission.userAddProductInCart();
    }

    @And("user click on checkout")
    public void userClickOnCheckout() {
        loginMission.userClickOnCheckoutButton();
    }

    @And("user enter require details for checkout")
    public void userEnterRequireDetailsForCheckout() {
        loginMission.enterCheckoutDetails();
    }

    @When("user click on continue button")
    public void userClickOnContinueButton() {
        loginMission.clickOnContinueButton();
    }

    @Then("user verify payment details")
    public void userVerifyPaymentDetails() {
        loginMission.verifyPaymentDetails();
    }

    @When("user click on finish button")
    public void userClickOnFinishButton() {
        loginMission.clickOnFinishButton();
    }

    @Then("order should get placed successfully")
    public void orderShouldGetPlacedSuccessfully() {
        loginMission.verifyOrderSuccessfulDetails();
    }
}