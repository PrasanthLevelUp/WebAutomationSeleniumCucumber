package pages;

import helper.Utils;
import helper.WaitHelper;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class InventoryPage {

    private WebDriver driver;

    @FindBy(xpath = "//select[@class='product_sort_container']")
    public WebElement selectDropdown;

    @FindBy(xpath = "//div[@class='inventory_details_name large_size']")
    public WebElement productNameEle;

    @FindBy(xpath = "//div[@class='inventory_details_price']")
    public WebElement productPriceEle;

    @FindBy(xpath = "//button[text()='Add to cart']")
    public WebElement addtocart;

    @FindBy(xpath = "//a[@class='shopping_cart_link']")
    public WebElement addIcon;

    @FindBys(@FindBy(xpath = "//div[@class='inventory_item_price']"))
    List<WebElement> prices;

    @FindBys(@FindBy(xpath = "//div[@class='inventory_item_label']/a"))
    List<WebElement> names;

    WaitHelper waitHelper;
    Utils utils = new Utils();

    public InventoryPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
        waitHelper = new WaitHelper(driver);
    }

    public void setSelectDropdown(String dropdown) {
        try {
            Select select = new Select(selectDropdown);
            select.selectByVisibleText(dropdown);
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage());
        }
    }

    public boolean validatePriceOrder() {
        try {
            for (int i = 0; i < prices.size() - 1; i++) {
                if (utils.removeDollor(prices.get(i).getText()) < utils.removeDollor(prices.get(i + 1).getText())) {
                    return false;
                }
            }
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage());
        }
        return true;
    }

  public String getProductName(){
        return names.get(0).getText();
  }

  public float getProductPrice(){
        return utils.removeDollor(prices.get(0).getText());
  }

    public void selectFirstProduct() {
        try {
            names.get(0).click();
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage());
        }
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

    public void addProducttoCart() {
        try {
            addtocart.click();
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage());
        }
    }

    public void clickCartIcon() {
        try {
            addIcon.click();
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage());
        }
    }

}
