@LoginToSite @login
Feature:LoginToSite

  Background:
    Given launch the saucedemo url

  @TC01
  Scenario: TC01_Verify saucedemo webpage title
    Then user should be on saucedemo webpage

  @TC02
  Scenario: TC02_Verify username and password field on login page
    Then username field should be present and editable
    And password field should be present and editable
    And login button field should be present and clickable

  @TC03
  Scenario Outline: TC03_Verify error message should get displayed for invalid user name and password
    Given user enter "<invalidUserName>" value in username
    And user enter "<invalidPassword>" value in password
    When user click on login button
    Then error message should get displayed
    Examples:
      | invalidUserName   | invalidPassword  |
      | alphaNumeric      | alphaNumeric     |
      | specialCharacter  | specialCharacter |
      | blank             | blank            |

  @TC04
  Scenario : TC04_Verify error message should get displayed for blank user name and password
    Given user enter "blank" value in username
    And user enter "blank" value in password
    When user click on login button
    Then error message should get displayed for blank username

  @TC04
  Scenario : TC04_Verify user should be able to login successfully
    Given user enter "valid" value in username
    And user enter "valid" value in password
    When user click on login button
    Then user should navigate to Swag Lab main page

  @TC04
  Scenario : TC04_Verify user enter item in cart and checkout successfully
    Given user login to swag lab
    And user add "Sauce Labs Bolt T-Shirt" in cart and proceed to checkout
    And user click on checkout
    And user enter require details for checkout
    When user click on continue button
    Then user verify payment details
    When user click on finish button
    Then order should get placed successfully