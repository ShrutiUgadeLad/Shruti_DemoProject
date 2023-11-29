package pages;

import locatorConstant.LoginPageLocatorConstant;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends PageObject {
    @FindBy(xpath = LoginPageLocatorConstant.USERNAME)
    WebElementFacade userName;

    @FindBy(xpath = LoginPageLocatorConstant.PASSWORD)
    WebElementFacade passWord;

    @FindBy(xpath = LoginPageLocatorConstant.LOGIN_BUTTON)
    WebElementFacade loginButton;

    @FindBy(xpath = LoginPageLocatorConstant.ERROR_MESSAGE)
    WebElementFacade errorMessage;

    @FindBy(xpath = LoginPageLocatorConstant.SWAG_LAB_HEADER_TITLE)
    WebElementFacade swagHeaderTitle;

    @FindBy(xpath = LoginPageLocatorConstant.ADD_TO_CART_PRODUCT)
    WebElementFacade addToCartProduct;

    @FindBy(xpath = LoginPageLocatorConstant.CART_PRODUCT)
    WebElementFacade cartProduct;

    @FindBy(xpath = LoginPageLocatorConstant.CHECKOUT_BUTTON)
    WebElementFacade checkoutButton;

    @FindBy(xpath = LoginPageLocatorConstant.FIRST_NAME)
    WebElementFacade firstName;

    @FindBy(xpath = LoginPageLocatorConstant.LAST_NAME)
    WebElementFacade lastName;

    @FindBy(xpath = LoginPageLocatorConstant.POSTAL_CODE)
    WebElementFacade postalCode;

    @FindBy(xpath = LoginPageLocatorConstant.CONTINUE_BUTTON)
    WebElementFacade continueButton;

    @FindBy(xpath = LoginPageLocatorConstant.FINISH_BUTTON)
    WebElementFacade finishButton;

    @FindBy(xpath = LoginPageLocatorConstant.PAYMENT_INFORMATION)
    WebElementFacade paymentInformation;

    @FindBy(xpath = LoginPageLocatorConstant.ORDER_SUCCESSFUL)
    WebElementFacade orderSuccessful;

    public void launchUrl(String url) {
        openUrl(url);
    }

    public LoginPage enterUserName(String username) {
        userName.waitUntilVisible().sendKeys(username);
        return this;
    }

    public LoginPage enterPassword(String password) {
        passWord.waitUntilVisible().sendKeys(password);
        return this;
    }

    public LoginPage clickOnLoginButton() {
        loginButton.click();
        return this;
    }

    public boolean isUsernamePresent() {
        return userName.waitUntilVisible().isPresent();
    }

    public boolean isPasswordPresent() {
        return passWord.waitUntilVisible().isPresent();
    }

    public boolean isUsernameEnable() {
        return userName.waitUntilVisible().isEnabled();
    }

    public boolean isPasswordEnable() {
        return passWord.waitUntilVisible().isEnabled();
    }

    public boolean isLoginButtonClickable() {
        return loginButton.waitUntilVisible().isClickable();
    }

    public boolean isLoginButtonPresent() {
        return loginButton.waitUntilVisible().isPresent();
    }

    public String getErrorMessage() {
        return errorMessage.waitUntilVisible().getText();
    }

    public String getSwagLabHeaderTitle() {
        return swagHeaderTitle.waitUntilVisible().getText();
    }

    public LoginPage addProductInCart() {
        addToCartProduct.waitUntilVisible().click();
        return this;
    }

    public LoginPage clickOnCart() {
        cartProduct.waitUntilVisible().click();
        return this;
    }

    public LoginPage clickOnCheckoutButton() {
        checkoutButton.waitUntilVisible().click();
        return this;
    }

    public LoginPage enterDetailsForCheckout(String postalcode, String firstname, String lastname) {
        firstName.sendKeys(firstname);
        lastName.sendKeys(lastname);
        postalCode.sendKeys(postalcode);
        return this;
    }

    public LoginPage clickOnContinueButton() {
        continueButton.waitUntilVisible().click();
        return this;
    }

    public String getPaymentDetails() {
        return paymentInformation.waitUntilVisible().getText();
    }

    public LoginPage clickOnFinishButton() {
        finishButton.waitUntilVisible().click();
        return this;
    }

    public String getOrderSuccessfulText() {
        return orderSuccessful.waitUntilVisible().getText();
    }
}