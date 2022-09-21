package pages;

import helper.Utils;
import helper.WaitHelper;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CheckoutTwoPage {

    private WebDriver driver;

    WaitHelper waitHelper;

    Utils utils = new Utils();

    @FindBy(xpath = "//div[@id='checkout_complete_container']//h2")
    public WebElement thankyou;

    @FindBy(xpath = "//button[@id='finish']")
    public WebElement finishBtn;

    public CheckoutTwoPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
        waitHelper = new WaitHelper(driver);
    }


    public void clickonFinish() {
        try {
            finishBtn.click();
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage());
        }
    }

    public String ThankYou(){
        return thankyou.getText();
    }

}
