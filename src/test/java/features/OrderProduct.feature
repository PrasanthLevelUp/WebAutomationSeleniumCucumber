Feature: As a user I should be able to login and order a item in saucedemo

  @ValidOrder
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
    Then Close the broswer


