package tests;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

//import org.testng.annotations.AfterClass;
//import org.testng.annotations.BeforeClass;
//import org.testng.annotations.Test;
//
//import com.aventstack.extentreports.ExtentReports;
//import com.aventstack.extentreports.ExtentTest;
//import com.aventstack.extentreports.Status;
//import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class Reports{
	
	public void loging(String log1) 
	{
	ExtentReports extent = new ExtentReports();
	ExtentSparkReporter spark = new ExtentSparkReporter("./test-output/Reports_results/SparkFail.html");
	extent.attachReporter(spark);
	extent.createTest("MyFirstTest")
	  .log(Status.PASS, log1);
	extent.flush();
	
//    ExtentSparkReporter sparkReporter = new ExtentSparkReporter("test-output/ExtentReport.html");
//
//    // Create ExtentReports instance
//    extent = new ExtentReports();
//
//    // Attach the reporter
//    extent.attachReporter(sparkReporter);
	}

}
