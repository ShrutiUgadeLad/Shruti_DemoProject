package dataModel;

public class LoginDataModel {
    private String userType;

    private String userNameMissing;

    private String invalidUsernamePassword;

    private String swagLabHeader;

    private String successfulCheckout;

    private String paymentConfirmation;

    public String getUserType() {
        return userType;
    }

    public void setUserType(String userType) {
        this.userType = userType;
    }

    public String getUserNameMissing() {
        return userNameMissing;
    }

    public void setUserNameMissing(String userNameMissing) {
        this.userNameMissing = userNameMissing;
    }

    public String getInvalidUsernamePassword() {
        return invalidUsernamePassword;
    }

    public void setInvalidUsernamePassword(String invalidUsernamePassword) {
        this.invalidUsernamePassword = invalidUsernamePassword;
    }

    public String getSwagLabHeader() {
        return swagLabHeader;
    }

    public void setSwagLabHeader(String swagLabHeader) {
        this.swagLabHeader = swagLabHeader;
    }

    public String getSuccessfulCheckout() {
        return successfulCheckout;
    }

    public void setSuccessfulCheckout(String successfulCheckout) {
        this.successfulCheckout = successfulCheckout;
    }

    public String getPaymentConfirmation() {
        return paymentConfirmation;
    }

    public void setPaymentConfirmation(String paymentConfirmation) {
        this.paymentConfirmation = paymentConfirmation;
    }
}