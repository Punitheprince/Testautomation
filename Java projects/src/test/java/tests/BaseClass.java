package tests;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.Reporter;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import com.aventstack.extentreports.MediaEntityBuilder;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.Date;

public class BaseClass extends Reports {
    protected AppiumDriver driver;
    protected ExtentTest test;  

    @BeforeTest
    public void testsetUp() throws Exception {
        try {
            DesiredCapabilities caps = new DesiredCapabilities();
            caps.setCapability("platformName", "Android");
            caps.setCapability("platformVersion", "14");
            caps.setCapability("deviceName", "Android_test_device");
            caps.setCapability("appActivity", "com.flipkart.android.SplashActivity");
            caps.setCapability("appPackage", "com.flipkart.android");
            caps.setCapability("automationName", "UiAutomator2");

            URL appiumServerUrl = new URL("http://127.0.0.1:4723/wd/hub");
            driver = new AndroidDriver(appiumServerUrl, caps);  // Initialize driver

            System.out.println("Driver initialized and ready for the test.");
        } catch (Exception e) {
            e.printStackTrace();
            throw new Exception("Failed to initialize the Appium driver.", e);
        }
    }

    @AfterTest
    public void teardown() {
        if (driver != null) {
            driver.quit();
        }
        System.out.println("Driver session ended.");
    }

    public void Logger_start(String testName, String description) {
        test = extent.createTest(testName, description);
        test.log(Status.PASS, "Test started.");
        
    }

    public String timestampprinter() {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd_HHmmss");
        String timestamp1 = sdf.format(new Date());
        return timestamp1;
    }

    // Screenshot method
    public File screenshot() throws IOException {
        File screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        File destination = new File("./test-output/screenshots/" + timestampprinter() + ".png");
        FileUtils.copyFile(screenshot, destination);
        return destination;
    }

    // Method to attach screenshot in the report
    public void attachscreenshot() throws IOException {
        File screenshot1 = screenshot();
//        Reporter.log("<br><img src='screenshots/" + screenshot1 + "' height='300' width='300'/><br>");
        test.info("Screenshot attached", MediaEntityBuilder.createScreenCaptureFromPath(screenshot1.getAbsolutePath()).build());
    }
}
