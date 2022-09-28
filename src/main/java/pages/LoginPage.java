package pages;

import helper.WaitHelper;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

    private WebDriver driver;

    @FindBy(xpath = "//input[@id='user-name']")
    public WebElement userName;

    @FindBy(xpath = "//input[@id='password']")
    public WebElement password;

    @FindBy(xpath = "//input[@id='login-button']")
    public WebElement loginButton;

    @FindBy(xpath = "//h3[@data-test='error']")
    public WebElement errorMessageButton;

    WaitHelper waitHelper;

    public LoginPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
        waitHelper = new WaitHelper(driver);
    }

    public void enterUserName(String username) {
        waitHelper.WaitForElement(userName, 60);
        this.userName.sendKeys(username);
    }

    public void enterPassword(String passwordtxt) {
        this.password.sendKeys(passwordtxt);
    }

    public void clickLoginButton() {
        waitHelper.WaitForElement(loginButton, 60);
        loginButton.click();
    }

    public void entervaloidLogin(String username, String password) {
        try {
            this.enterUserName(username);
            this.enterPassword(password);
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage());
        }
    }

    public String errorMessageTxt(){

        String errorMessage = null;
        try {
            waitHelper.WaitElementVisible(errorMessageButton,5);
            errorMessage = errorMessageButton.getText();
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage());
        }
        return errorMessage;
    }

}
