package pages;

import helper.Utils;
import helper.WaitHelper;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CartPage {

    private WebDriver driver;

    WaitHelper waitHelper;

    Utils utils = new Utils();

    @FindBy(xpath = "//div[@class='inventory_item_name']")
    public WebElement productNameEle;

    @FindBy(xpath = "//div[@class='inventory_item_price']")
    public WebElement productPriceEle;

    @FindBy(xpath = "//button[@id='checkout']")
    public WebElement checkout;

    public CartPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
        waitHelper = new WaitHelper(driver);
    }

    public boolean verifyProductName(String productName) {
        try {
            if (!productName.equalsIgnoreCase(productNameEle.getText())) {
                return false;
            }
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage());
        }
        return true;
    }

    public boolean verifyProductPrice(float productPrice) {
        try {
            if (productPrice != utils.removeDollor(productPriceEle.getText())) {
                return false;
            }
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage());
        }
        return true;
    }

    public void clickOnCheckout() {
        try {
            checkout.click();
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage());
        }
    }

}
