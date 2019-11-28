package com.sampledemo.pagefactory.testcase;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
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
import com.sampledemo.project.pagefactory.pageobjects.screenShot;
import com.sampledemo.project.pageobjects.homePage;
import com.sampledemo.project.utility.propertyClass;
import com.sampledemo.project.pageobjects.signOnPage;
import com.sampledemo.project.utility.validation;

public class signOnPageTestcase extends setupClass {
	

	@Test(priority = 1)
	public void navigationOfSignOnPage() {
		
		test = extent.createTest("Navigate to Sign-On Page");
		PageFactory.initElements(driver, homePage.class);
		homePage.Signonlink(driver).click();
		PageFactory.initElements(driver, signOnPage.class);
		String actualSignonPageTitle = driver.getTitle();
		Assert.assertEquals(actualSignonPageTitle, propertyClass.returnValue("expectedSignonPageTitle"));
		
	}

	@Test(priority = 2)
	public void lengthOfTextbox() {
		
		test = extent.createTest("Valid the length of username and password textbox");
		PageFactory.initElements(driver, homePage.class);
		homePage.Signonlink(driver).click();
		PageFactory.initElements(driver, signOnPage.class);
		String lenofusername = signOnPage.userName(driver).getAttribute("maxlength");
		softAssert.assertEquals(lenofusername, "60");
		String lenofpswd = signOnPage.password(driver).getAttribute("maxlength");
        softAssert.assertEquals(lenofpswd,"60");
    	softAssert.assertAll();
	
	}

	@Test(priority = 3)
	public void contentVerification() {
		test = extent.createTest("Valid content in Sign-on Page");
		PageFactory.initElements(driver, homePage.class);
		homePage.Signonlink(driver).click();
		PageFactory.initElements(driver, signOnPage.class);
		String Actualcontent = driver.findElement(By.xpath("/html/body/div/table/tbody/tr/td[2]/table/tbody/tr[4]/td/table/tbody/tr/td[2]/table/tbody/tr[3]/td/p/font")).getText();
		Assert.assertEquals(Actualcontent, propertyClass.returnValue("expectedContent"));

		
	}

	@Test(priority = 4)
	public void formatOfContent() {
		
		test = extent.createTest("Valid the bold and link text in the content");
		PageFactory.initElements(driver, homePage.class);
		homePage.Signonlink(driver).click();
		PageFactory.initElements(driver, signOnPage.class);
		String boldcontent = driver.findElement(By.xpath(
				"/html/body/div/table/tbody/tr/td[2]/table/tbody/tr[4]/td/table/tbody/tr/td[2]/table/tbody/tr[3]/td/p/font/b"))
				.getCssValue("font-weight");
		
		String Actuallinkcontent = driver.findElement(By.xpath(
				"/html/body/div/table/tbody/tr/td[2]/table/tbody/tr[4]/td/table/tbody/tr/td[2]/table/tbody/tr[3]/td/p/font/a"))
				.getText();

		softAssert.assertEquals(boldcontent, "700");
		softAssert.assertEquals(Actuallinkcontent, propertyClass.returnValue("expectedLinkContent"));
		softAssert.assertAll();
		
		
		
		
	}
}
