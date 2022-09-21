package helper;

import base.BaseTest;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import org.apache.commons.io.FileUtils;
import org.apache.commons.io.IOUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.Base64;

import static helper.Constants.*;
import static helper.Utils.*;

public class ExtentReportHelper extends BaseTest {

    public ExtentReports extentSetup() {
        ExtentReports extent = new ExtentReports();
        try {
            ExtentSparkReporter spark = new ExtentSparkReporter(getExtentConfig() + File.separator + "ExtentReport_" + getTimeStamp() + ".html");
            extent.attachReporter(spark);
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage());
        }
        return extent;
    }


    public String takeScreenshotBase64() {
        String screenShot = null;
        try {
            File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
            String path = System.getProperty("user.dir") + "/Screenshots/screenshpt_" + getTimeStamp() + ".png";
            File desFile = new File(path);
            FileUtils.copyFile(scrFile, desFile);

            InputStream is = new FileInputStream(path);
            byte[] bytes = IOUtils.toByteArray(is);
            screenShot = Base64.getEncoder().encodeToString(bytes);
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage());
        }

        return screenShot;
    }


}
