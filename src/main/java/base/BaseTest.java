package base;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import enumfiles.Browsers;
import enumfiles.OS;
import helper.ExtentReportHelper;
import helper.WaitHelper;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;
import pages.*;


public class BaseTest {

    public static WebDriver driver;
    public ExtentReports extent;
    public ExtentReportHelper extentReportHelper;
    public ExtentTest test;
    public LoginPage loginPage;
    public InventoryPage inventoryPage;
    public CartPage cartPage;
    public CheckoutOnePage checkout;
    public CheckoutTwoPage checkoutTwoPage;
    public WaitHelper waitHelper = new WaitHelper(driver);



    public void setup(){
        extentReportHelper = new ExtentReportHelper();
        extent = extentReportHelper.extentSetup();
    }


    public WebDriver selectBrowser(String browser) {
        if (System.getProperty("os.name").toLowerCase().contains(OS.WINDOW.name().toLowerCase())) {
            if (browser.equalsIgnoreCase(Browsers.CHROME.name())) {
                WebDriverManager.chromedriver().setup();
                driver = new ChromeDriver();
                driver.manage().window().maximize();
            } else if (browser.equalsIgnoreCase(Browsers.FIREFOX.name())) {
                WebDriverManager.firefoxdriver().setup();
                driver = new FirefoxDriver();
            }
        } else if (System.getProperty("os.name").toLowerCase().contains(OS.MAC.name().toLowerCase())) {
            if (browser.equalsIgnoreCase(Browsers.CHROME.name())) {
                WebDriverManager.chromedriver().setup();
                driver = new ChromeDriver();
                driver.manage().window().maximize();
            } else if (browser.equalsIgnoreCase(Browsers.SAFARI.name())) {
                WebDriverManager.safaridriver().setup();
                driver = new SafariDriver();
            }
        }
        return driver;
    }


    public void teardown(){
        driver.quit();
        extent.flush();
    }

}



