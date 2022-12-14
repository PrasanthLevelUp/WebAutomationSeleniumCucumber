Feature: As a user I should be able to login and order a item in saucedemo

  @ValidOrder  @OrderProduct
  Scenario: Login into the application with valid credentials
  	Given Open the Browser and go to URL
    Then Verify user see Sign In Page
    When User enter username and password
    And User Click on Continue button
    Then Verify user logged in
    When User filter high to low
    Then Verify results to match with your query
    When User Select the first listed product
    Then Verify Product name and Price details
    When User click add to cart button
    And Click on Cart Icon
    Then Verify cart page is displayed
    And Verify selected product displayed
    When User click on checkout button
    Then Verify checkout page is displayed
    When User enter firstname, lastname and pincode
    And User Click on Continue button to checkout
    When User click add to finish button
    Then Verify thank you for order displayed
    And Close the browser

  @InValidLogin  @OrderProduct
  Scenario Outline: Verify user not able to Login with invalid credentials
    Given Open the Browser and go to URL
    Then Verify user see Sign In Page
    When User enter invalid username "<testuser>" and password "<testpassword>"
    And User Click on Continue button
    Then Verify user not able to login and erroe message dispalyed "<errormessage>"
    And Close the browser
    Examples:
      | testuser | testpassword|errormessage|
      |test1     |password1    |Epic sadface: Username and password do not match any user in this service|

  @ErrorMessageValidation  @OrderProduct
  Scenario: Verify the blank error messages
    Given Open the Browser and go to URL
    Then Verify user see Sign In Page
    When User Click on Continue button
    Then Verify the error Message "Epic sadface: Username is required"
    When User Enter username
    And User Click on Continue button
    Then Verify the error Message "Epic sadface: Password is required"
    And Close the browser

  @ValidateCheckoutErrorMsg   @OrderProduct
  Scenario: Verify the checkout page error massages
    Given Open the Browser and go to URL
    Then Verify user see Sign In Page
    When User enter username and password
    And User Click on Continue button
    Then Verify user logged in
    When User filter high to low
    Then Verify results to match with your query
    When User Select the first listed product
    Then Verify Product name and Price details
    When User click add to cart button
    And Click on Cart Icon
    Then Verify cart page is displayed
    And Verify selected product displayed
    When User click on checkout button
    Then Verify checkout page is displayed
    When User Click on Continue button to checkout
    Then Verify the error Message in checkout page "Error: First Name is required"
    When User enter firstname "TestUser"
    And User Click on Continue button to checkout
    Then Verify the error Message in checkout page "Error: Last Name is required"
    When User enter lastname "User"
    And User Click on Continue button to checkout
    Then Verify the error Message in checkout page "Error: Postal Code is required"
    And Close the browser


