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

    public CheckoutOnePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
        waitHelper = new WaitHelper(driver);
    }

    public void fillUserDetails(String firstname,String lastname,String pincode) {
        try {
           firstName.sendKeys(firstname);
           lastName.sendKeys(lastname);
           postalCode.sendKeys(pincode);
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage());
        }
    }

    public void clickonContinue() {
        try {
            continueBtn.click();
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage());
        }
    }

}
