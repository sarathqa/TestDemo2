package com.sampledemo.pagefactory.testcase;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.asserts.SoftAssert;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.sampledemo.project.pagefactory.pageobjects.homePage;
import com.sampledemo.project.pagefactory.pageobjects.screenShot;
import com.sampledemo.project.utility.browser;
import com.sampledemo.project.utility.propertyClass;

public class setupClass {
	static WebDriver driver;
	String userdir = System.getProperty("user.dir");
	public ExtentHtmlReporter htmlReporter;
	public static ExtentReports extent;
	public static ExtentTest test;
	static SoftAssert softAssert;
	
	@ BeforeSuite
	 public void extentreportSetup() {
		 
		  htmlReporter = new ExtentHtmlReporter(System.getProperty("user.dir") + "/test-output/extentMyReport.html");
		  htmlReporter.config().setDocumentTitle("Automation Report");
		  htmlReporter.config().setReportName("Home Page");
		  extent = new ExtentReports();
		  extent.attachReporter(htmlReporter);
	}

	@BeforeMethod
	public void browserAndHomePagelanding() {
		propertyClass.propfiles(userdir + "/utility/config.properties");
		driver = browser.browserSelection(propertyClass.returnValue("browser"));
		driver.get(propertyClass.returnValue("url"));
		driver.manage().timeouts().implicitlyWait(1000, TimeUnit.MILLISECONDS);
		softAssert= new SoftAssert();
		
		
	}
	
	 @AfterSuite
	 public void endReport() {
	  extent.flush();
	 }

	@AfterMethod
	public void closingBrowserAndUpdateReport(ITestResult result) throws IOException {
		if (result.getStatus() == ITestResult.FAILURE) {
			   test.log(Status.FAIL, "Failed testcase is " + result.getName()); 
			   test.log(Status.FAIL, "Failed testcase exception is " + result.getThrowable());
			   String screenshotPath = screenShot.getScreenshot(driver, result.getName());
			   test.addScreenCaptureFromPath(screenshotPath);
			  }
		
		else if (result.getStatus() == ITestResult.SKIP) {
			   test.log(Status.SKIP, "Skipped Test Case is " + result.getName());
			  }
	    else if (result.getStatus() == ITestResult.SUCCESS) {
			   test.log(Status.PASS, "Passed Testcase is " + result.getName());
			  }
			  driver.quit();
			 }

}
