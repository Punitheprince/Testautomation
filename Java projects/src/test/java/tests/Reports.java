package tests;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.AfterTest;

public class Reports {

    // Shared ExtentReports object
    protected static ExtentReports extent;
    
    @BeforeTest
    public void setUp() {
        if (extent == null) {
            // Initialize ExtentReports only once
        	BaseClass base = new BaseClass();
            String reportPath = "./test-output/Reports_results/"+base.timestampprinter()+"/extent.html";
            ExtentSparkReporter sparkReporter = new ExtentSparkReporter(reportPath);
            
            // Initialize the ExtentReports object
            extent = new ExtentReports();
            extent.attachReporter(sparkReporter);
        }
    }
    
    @AfterTest
    public void tearDown() {
        if (extent != null) {
            extent.flush();
        }
    }
}
