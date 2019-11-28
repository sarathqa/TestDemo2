
package com.sampledemo.pagefactory.testcase;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.sampledemo.project.utility.browser;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.sampledemo.project.pagefactory.pageobjects.homePage;
import com.sampledemo.project.pagefactory.pageobjects.screenShot;
import com.sampledemo.project.utility.propertyClass;
import com.sampledemo.project.utility.validation;

import io.github.bonigarcia.wdm.WebDriverManager;
import okio.Timeout;

public class loginPageTestcase extends setupClass {
	
	@Test(priority = 1)
	public void validLogin() {
		
		test = extent.createTest("Valid login details");
		PageFactory.initElements(driver, homePage.class);
		homePage.username.sendKeys(propertyClass.returnValue("username"));
		homePage.password.sendKeys(propertyClass.returnValue("password"));
		homePage.submit.click();
		Assert.assertEquals(driver.getTitle(), propertyClass.returnValue("expectedtitleofFlightfinderpage"));
		
	}

	@Test(priority = 2)
	public void dataVerificationinLogin() {
		
		test = extent.createTest("Valid lst data under Special");
		PageFactory.initElements(driver, homePage.class);
		String actualKeyData = homePage.Specialkey.getText();
		String actualValueData = homePage.Specialdata.getText();
		softAssert.assertEquals(actualKeyData, propertyClass.returnValue("expectedKeyData"));
		softAssert.assertEquals(actualValueData, propertyClass.returnValue("expectedValueData"));
		softAssert.assertAll();

		
	}

}
