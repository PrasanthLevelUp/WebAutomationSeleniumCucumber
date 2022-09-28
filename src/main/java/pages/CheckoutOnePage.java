package pages;

import helper.Utils;
import helper.WaitHelper;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CheckoutOnePage {

    private WebDriver driver;

    WaitHelper waitHelper;

    Utils utils = new Utils();

    @FindBy(xpath = "//input[@id='first-name']")
    public WebElement firstName;

    @FindBy(xpath = "//input[@id='last-name']")
    public WebElement lastName;

    @FindBy(xpath = "//input[@id='postal-code']")
    public WebElement postalCode;

    @FindBy(xpath = "//input[@id='continue']")
    public WebElement continueBtn;

    @FindBy(xpath = "//h3[@data-test='error']")
    public WebElement errorMessageBtn;

    public CheckoutOnePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
        waitHelper = new WaitHelper(driver);
    }

    public void fillUserDetails(String firstname,String lastname,String pincode) {
        try {
          this.enterUserName(firstname);
          this.enterLastname(lastname);
          this.enterPincode(pincode);
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage());
        }
    }

    public void enterUserName(String username) {
        waitHelper.WaitForElement(firstName, 60);
        this.firstName.sendKeys(username);
    }
    public void enterLastname(String lastname) {
        waitHelper.WaitForElement(lastName, 60);
        this.lastName.sendKeys(lastname);
    }

    public void enterPincode(String pincode) {
        waitHelper.WaitForElement(postalCode, 60);
        this.postalCode.sendKeys(pincode);
    }

    public void clickonContinue() {
        try {
            continueBtn.click();
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage());
        }
    }


    public String errorMessageTxt(){

        String errorMessage = null;
        try {
            waitHelper.WaitElementVisible(errorMessageBtn,5);
            errorMessage = errorMessageBtn.getText();
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage());
        }
        return errorMessage;
    }
}
