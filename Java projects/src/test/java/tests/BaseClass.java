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
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.Date;

public class BaseClass {
    protected AppiumDriver driver; 
    
    @BeforeTest
    public void testsetUp() throws Exception {
        try {
            DesiredCapabilities caps = new DesiredCapabilities();
            caps.setCapability("platformName", "Android");
            caps.setCapability("platformVersion", "14");
            caps.setCapability("deviceName", "Android_test_device");
            caps.setCapability("appActivity", "com.flipkart.android.SplashActivity"); // Correct activity name
            caps.setCapability("appPackage", "com.flipkart.android"); // Add appPackage capability
            caps.setCapability("automationName", "UiAutomator2");
            

            // Initialize the driver with Appium server URL and desired capabilities
            URL appiumServerUrl = new URL("http://127.0.0.1:4723/wd/hub");
            driver = new AndroidDriver(appiumServerUrl, caps);  // Assigning driver to the class-level variable

            System.out.println("Driver initialized and ready for the test.");

        } catch (Exception e) {
            e.printStackTrace();
            throw new Exception("Failed to initialize the Appium driver.", e); // Throw exception if initialization fails
        }
    }

    // Tear down method to quit the driver after the test
    @AfterTest
    public void teardown() {
        if (driver != null) {
            driver.quit();
        }
        System.out.println("Driver session ended.");
    }
    
    public String timestampprinter() {
    	SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd_HHmmss");
        
        // Get the current date and time
        String timestamp1 = sdf.format(new Date());
        
        return timestamp1;
    }
    
    public File screenshot() throws IOException {
        File screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
//        File destination = new File("C:\\Users\\Admin\\Desktop\\SeleniumWorkspace\\TestAutomation\\Java projects\\test-output\\screenshots\\"+timestampprinter()+".png");

        File destination = new File("./test-output/screenshots/"+timestampprinter()+".png");
        FileUtils.copyFile(screenshot, destination);

        return destination;
    }

    public void attachscreenshot() throws IOException
    {
        File screenshot1 =screenshot();        

        Reporter.log("<br><img src='screenshots/" + screenshot1 + "' height='300' width='300'/><br>");

    }
    
}
