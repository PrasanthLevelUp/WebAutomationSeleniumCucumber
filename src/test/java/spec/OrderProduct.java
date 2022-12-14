package spec;

import base.BaseTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import enumfiles.Browsers;
import helper.WaitHelper;
import io.cucumber.java.AfterAll;
import io.cucumber.java.Before;
import io.cucumber.java.BeforeAll;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.jetbrains.annotations.NotNull;
import org.junit.Assert;
import pages.*;

import static helper.Constants.*;

public class OrderProduct extends BaseTest {

    @BeforeAll
    public static void before_all(){
        setup();
    }


    @Before
    public void beforeScenario(@NotNull Scenario scenario) {
        selectBrowser(Browsers.CHROME.name());
        test = extent.createTest(scenario.getName());
        test.pass("Browser Opened", MediaEntityBuilder.createScreenCaptureFromBase64String(extentReportHelper.takeScreenshotBase64()).build());
    }

    @Given("^Open the Browser and go to URL$")
    public void open_the_Browser_and_go_to_URL() {
        try {
            driver.get(getUrl());
            test.pass("Url Entered", MediaEntityBuilder.createScreenCaptureFromBase64String(extentReportHelper.takeScreenshotBase64()).build());
            waitHelper = new WaitHelper(driver);
            loginPage = new LoginPage(driver);
        } catch (Exception e) {
            test.fail(e.getMessage(), MediaEntityBuilder.createScreenCaptureFromBase64String(extentReportHelper.takeScreenshotBase64()).build());
        }
    }

    @Then("^Verify user see Sign In Page$")
    public void verify_user_see_Sign_In_Page() {
        try {
            Assert.assertEquals(driver.getCurrentUrl(), getUrl());
            test.pass("Sign Page displayed", MediaEntityBuilder.createScreenCaptureFromBase64String(extentReportHelper.takeScreenshotBase64()).build());
        } catch (Exception e) {
            test.fail(e.getMessage(), MediaEntityBuilder.createScreenCaptureFromBase64String(extentReportHelper.takeScreenshotBase64()).build());
        }
    }

    @When("^User enter username and password$")
    public void user_enter_username_and_password() {
        try {
            loginPage.entervaloidLogin(getUsername(), getPassword());
            test.pass("Entered username and password", MediaEntityBuilder.createScreenCaptureFromBase64String(extentReportHelper.takeScreenshotBase64()).build());
        } catch (Exception e) {
            test.fail(e.getMessage(), MediaEntityBuilder.createScreenCaptureFromBase64String(extentReportHelper.takeScreenshotBase64()).build());
        }
    }

    @When("^User Click on Continue button$")
    public void user_Click_on_Continue_button() {
        try {
            loginPage.clickLoginButton();
            test.pass("Clicked on Login Button", MediaEntityBuilder.createScreenCaptureFromBase64String(extentReportHelper.takeScreenshotBase64()).build());
        } catch (Exception e) {
            test.fail(e.getMessage(), MediaEntityBuilder.createScreenCaptureFromBase64String(extentReportHelper.takeScreenshotBase64()).build());
        }
    }

    @Then("^Verify user logged in$")
    public void verify_user_logged_in() {
        try {
            Assert.assertEquals(driver.getCurrentUrl(), "https://www.saucedemo.com/inventory.html");
            test.pass("Inventory page displayed", MediaEntityBuilder.createScreenCaptureFromBase64String(extentReportHelper.takeScreenshotBase64()).build());
        } catch (Exception e) {
            test.fail(e.getMessage(), MediaEntityBuilder.createScreenCaptureFromBase64String(extentReportHelper.takeScreenshotBase64()).build());
        }
    }

    @When("User filter high to low")
    public void user_filter_high_to_low() throws InterruptedException {
        try {
            Thread.sleep(2000);
            inventoryPage = new InventoryPage(driver);
            inventoryPage.setSelectDropdown("Price (high to low)");
            test.pass("Select Price (high to low)", MediaEntityBuilder.createScreenCaptureFromBase64String(extentReportHelper.takeScreenshotBase64()).build());
        } catch (Exception e) {
            test.fail(e.getMessage(), MediaEntityBuilder.createScreenCaptureFromBase64String(extentReportHelper.takeScreenshotBase64()).build());
        }
    }

    @Then("Verify results to match with your query")
    public void verify_results_to_match_with_your_query() {
        try {
            Assert.assertTrue(inventoryPage.validatePriceOrder());
            test.pass("Result displayed as per query", MediaEntityBuilder.createScreenCaptureFromBase64String(extentReportHelper.takeScreenshotBase64()).build());
        } catch (Exception e) {
            test.fail(e.getMessage(), MediaEntityBuilder.createScreenCaptureFromBase64String(extentReportHelper.takeScreenshotBase64()).build());
        }
    }

    String productName;
    float productPrice;

    @When("User Select the first listed product")
    public void user_select_the_first_listed_product() {
        try {
            productName = inventoryPage.getProductName();
            productPrice = inventoryPage.getProductPrice();
            inventoryPage.selectFirstProduct();
            test.pass("Select First Prouduct", MediaEntityBuilder.createScreenCaptureFromBase64String(extentReportHelper.takeScreenshotBase64()).build());
        } catch (Exception e) {
            test.fail(e.getMessage(), MediaEntityBuilder.createScreenCaptureFromBase64String(extentReportHelper.takeScreenshotBase64()).build());
        }
    }

    @Then("Verify Product name and Price details")
    public void verify_product_name_and_price_details() {
        try {
            Assert.assertTrue(inventoryPage.verifyProductName(productName));
            Assert.assertTrue(inventoryPage.verifyProductPrice(productPrice));
            test.pass("Product name and Price are verified", MediaEntityBuilder.createScreenCaptureFromBase64String(extentReportHelper.takeScreenshotBase64()).build());
        } catch (Exception e) {
            test.fail(e.getMessage(), MediaEntityBuilder.createScreenCaptureFromBase64String(extentReportHelper.takeScreenshotBase64()).build());
        }
    }

    @When("User click add to cart button")
    public void user_click_add_to_cart_button() {
        try {
            inventoryPage.addProducttoCart();
            test.pass("Add product to cart", MediaEntityBuilder.createScreenCaptureFromBase64String(extentReportHelper.takeScreenshotBase64()).build());
        } catch (Exception e) {
            test.fail(e.getMessage(), MediaEntityBuilder.createScreenCaptureFromBase64String(extentReportHelper.takeScreenshotBase64()).build());
        }
    }

    @When("Click on Cart Icon")
    public void click_on_cart_icon() {
        try {
            inventoryPage.clickCartIcon();
            cartPage = new CartPage(driver);
            test.pass("Clicked on cart icon", MediaEntityBuilder.createScreenCaptureFromBase64String(extentReportHelper.takeScreenshotBase64()).build());
        } catch (Exception e) {
            test.fail(e.getMessage(), MediaEntityBuilder.createScreenCaptureFromBase64String(extentReportHelper.takeScreenshotBase64()).build());
        }
    }

    @Then("Verify cart page is displayed")
    public void verify_cart_page_is_displayed() {
        try {
            Assert.assertEquals("https://www.saucedemo.com/cart.html", driver.getCurrentUrl());
            test.pass("Cart page displayed", MediaEntityBuilder.createScreenCaptureFromBase64String(extentReportHelper.takeScreenshotBase64()).build());
        } catch (Exception e) {
            test.fail(e.getMessage(), MediaEntityBuilder.createScreenCaptureFromBase64String(extentReportHelper.takeScreenshotBase64()).build());
        }
    }

    @Then("Verify selected product displayed")
    public void verify_selected_product_displayed() {
        try {
            Assert.assertTrue(cartPage.verifyProductName(productName));
            Assert.assertTrue(cartPage.verifyProductPrice(productPrice));
            test.pass("Product name and price validated in the cart page", MediaEntityBuilder.createScreenCaptureFromBase64String(extentReportHelper.takeScreenshotBase64()).build());
        } catch (Exception e) {
            test.fail(e.getMessage(), MediaEntityBuilder.createScreenCaptureFromBase64String(extentReportHelper.takeScreenshotBase64()).build());
        }
    }

    @When("User click on checkout button")
    public void user_click_on_checkout_button() {
        try {
            cartPage.clickOnCheckout();
            checkout = new CheckoutOnePage(driver);
            test.pass("Clicked on checkout page", MediaEntityBuilder.createScreenCaptureFromBase64String(extentReportHelper.takeScreenshotBase64()).build());
        } catch (Exception e) {
            test.fail(e.getMessage(), MediaEntityBuilder.createScreenCaptureFromBase64String(extentReportHelper.takeScreenshotBase64()).build());
        }
    }

    @Then("Verify checkout page is displayed")
    public void verify_checkout_page_is_displayed() {
        try {
            Assert.assertEquals("https://www.saucedemo.com/checkout-step-one.html", driver.getCurrentUrl());
            test.pass("Check out one page displayed", MediaEntityBuilder.createScreenCaptureFromBase64String(extentReportHelper.takeScreenshotBase64()).build());
        } catch (Exception e) {
            test.fail(e.getMessage(), MediaEntityBuilder.createScreenCaptureFromBase64String(extentReportHelper.takeScreenshotBase64()).build());
        }
    }

    @When("User enter firstname, lastname and pincode")
    public void user_enter_firstname_lastname_and_pincode() {
        try {
            checkout.fillUserDetails("standard_user", "password", "603110");
            test.pass("Entered the details in checkout page", MediaEntityBuilder.createScreenCaptureFromBase64String(extentReportHelper.takeScreenshotBase64()).build());
        } catch (Exception e) {
            test.fail(e.getMessage(), MediaEntityBuilder.createScreenCaptureFromBase64String(extentReportHelper.takeScreenshotBase64()).build());
        }
    }

    @When("User Click on Continue button to checkout")
    public void user_click_on_continue_button_to_checkout() {
        try {
            checkout.clickonContinue();
            test.pass("Clicked on continue button", MediaEntityBuilder.createScreenCaptureFromBase64String(extentReportHelper.takeScreenshotBase64()).build());
        } catch (Exception e) {
            test.fail(e.getMessage(), MediaEntityBuilder.createScreenCaptureFromBase64String(extentReportHelper.takeScreenshotBase64()).build());
        }
    }

    @When("User click add to finish button")
    public void user_click_add_to_finish_button() {
        try {
            checkoutTwoPage = new CheckoutTwoPage(driver);
            checkoutTwoPage.clickonFinish();
            test.pass("Clicked on Finish button", MediaEntityBuilder.createScreenCaptureFromBase64String(extentReportHelper.takeScreenshotBase64()).build());
        } catch (Exception e) {
            test.fail(e.getMessage(), MediaEntityBuilder.createScreenCaptureFromBase64String(extentReportHelper.takeScreenshotBase64()).build());
        }
    }

    @Then("Verify thank you for order displayed")
    public void verify_thank_you_for_order_displayed() {
        try {
            Assert.assertEquals("THANK YOU FOR YOUR ORDER", checkoutTwoPage.ThankYou());
            test.pass("Order Status verified", MediaEntityBuilder.createScreenCaptureFromBase64String(extentReportHelper.takeScreenshotBase64()).build());
        } catch (Exception e) {
            test.fail(e.getMessage(), MediaEntityBuilder.createScreenCaptureFromBase64String(extentReportHelper.takeScreenshotBase64()).build());
        }
    }

    @Then("Close the browser")
    public void close_the_browser() {
        try {
            teardown();
            test.pass("Browser closed");
        } catch (Exception e) {
            test.fail(e.getMessage(), MediaEntityBuilder.createScreenCaptureFromBase64String(extentReportHelper.takeScreenshotBase64()).build());
        }
    }

    @When("User enter invalid username {string} and password {string}")
    public void user_enter_invalid_username_and_password(String username, String password) {
        try {
            loginPage.entervaloidLogin(username, password);
            test.pass("Entered username and password", MediaEntityBuilder.createScreenCaptureFromBase64String(extentReportHelper.takeScreenshotBase64()).build());
        } catch (Exception e) {
            test.fail(e.getMessage(), MediaEntityBuilder.createScreenCaptureFromBase64String(extentReportHelper.takeScreenshotBase64()).build());
        }
    }

    @Then("Verify user not able to login and erroe message dispalyed {string}")
    public void verify_user_not_able_to_login_and_erroe_message_dispalyed(String expectedErrorMsg) {

        try {
            Assert.assertEquals(expectedErrorMsg, loginPage.errorMessageTxt());
            test.pass("Error message is displayed: " + loginPage.errorMessageTxt(), MediaEntityBuilder.createScreenCaptureFromBase64String(extentReportHelper.takeScreenshotBase64()).build());
        } catch (Exception e) {
            test.fail(e.getMessage(), MediaEntityBuilder.createScreenCaptureFromBase64String(extentReportHelper.takeScreenshotBase64()).build());
        }
    }

    @Then("Verify the error Message {string}")
    public void verify_the_error_message(String errorMassage) {
        try {
            Assert.assertEquals(errorMassage, loginPage.errorMessageTxt());
            test.pass("Error message is displayed: " + loginPage.errorMessageTxt(), MediaEntityBuilder.createScreenCaptureFromBase64String(extentReportHelper.takeScreenshotBase64()).build());
        } catch (Exception e) {
            test.fail(e.getMessage(), MediaEntityBuilder.createScreenCaptureFromBase64String(extentReportHelper.takeScreenshotBase64()).build());
        }
    }

    @When("User Enter username")
    public void user_enter_username() {

        try {
            loginPage.enterUserName(getUsername());
            test.pass("Username is Entered ", MediaEntityBuilder.createScreenCaptureFromBase64String(extentReportHelper.takeScreenshotBase64()).build());
        } catch (Exception e) {
            test.fail(e.getMessage(), MediaEntityBuilder.createScreenCaptureFromBase64String(extentReportHelper.takeScreenshotBase64()).build());
        }
    }

    @When("User enter firstname {string}")
    public void user_enter_firstname(String firstname) {
        try {
            checkout.enterUserName(firstname);
            test.pass("Entered firstname in checkout page", MediaEntityBuilder.createScreenCaptureFromBase64String(extentReportHelper.takeScreenshotBase64()).build());
        } catch (Exception e) {
            test.fail(e.getMessage(), MediaEntityBuilder.createScreenCaptureFromBase64String(extentReportHelper.takeScreenshotBase64()).build());
        }
    }
    @Then("Verify the error Message in checkout page {string}")
    public void verify_the_error_message_in_checkout_page(String errorMessage) {
        try {
            Assert.assertEquals(errorMessage, checkout.errorMessageTxt());
            test.pass("Error message is displayed: " + loginPage.errorMessageTxt(), MediaEntityBuilder.createScreenCaptureFromBase64String(extentReportHelper.takeScreenshotBase64()).build());
        } catch (Exception e) {
            test.fail(e.getMessage(), MediaEntityBuilder.createScreenCaptureFromBase64String(extentReportHelper.takeScreenshotBase64()).build());
        }
    }
    @When("User enter lastname {string}")
    public void user_enter_lastname(String lastname) {
        try {
            checkout.enterLastname(lastname);
            test.pass("Entered lastname in checkout page", MediaEntityBuilder.createScreenCaptureFromBase64String(extentReportHelper.takeScreenshotBase64()).build());
        } catch (Exception e) {
            test.fail(e.getMessage(), MediaEntityBuilder.createScreenCaptureFromBase64String(extentReportHelper.takeScreenshotBase64()).build());
        }
    }

    @AfterAll
    public static void after_all(){
        extent.flush();
    }
}

