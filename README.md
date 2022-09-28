# WebAutomationSeleniumCucumber
This is repository of selenium automationi testing framework. The website is used https://www.saucedemo.com/ . This framework is developed using Selenium library and Cucumber BDD approach for web Automatioin testing.

# Technologies/Tools used in building the framework
1. Selenium
2. Cucumber
3. Java
4. Junit
5. Page Object Model
6. IntelliJ
7. GitHub
8. Maven
9. Extent Report

# Framework implements below best practices
1. Scalable and extensible
2. Reusable Selenium Methods
3. Cucumber BDD framework
4. Easy readable feature files
5. All scripted spec files
6. Single click Run execution from Runner class
7. POM pattern for each page
8. Extend reporting function with screenshot attached
9. Automate positive and negative scenarios
10. Support parallel execution
11. Maven command line execution
12. Integration with Git
13. Integration with Jenkins

# How to run the tests?
1. First way Open the terminal and code the project location and run mvn command - mvn test
2. Second way right-click on the "TestRunner" inside runner package
3. Third way right-click on the OrderProduct feature file inside features package

#Scenarios Covered
1. Positive Flow:
    * Verify login with valid login username and password
    * Verify filter functionality results with high to low
    * Verify user able to select first item in product view
    * Verify the field validation for displayed product
    * Verify add to cart page
    * Verify the cart page with add product
    * Verify the checkout page with user details
    * Verify the final check out page with valid detils
    * Verify the thank-you for order page
2. Negative Flow:
    * Verify the invalid login with wrong username and password 
    * Verify the error message for invalid login
    * Verify the error message for blank username and blank password fields
    * Verify the error message for blank fields in checkout page firstname, lastname, and post code

#Reports
   * Extent reports stored in the Reports folder on every run
   * Screenshots are stored in the Screenshots folder

