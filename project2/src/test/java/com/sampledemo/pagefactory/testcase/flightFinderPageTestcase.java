package com.sampledemo.pagefactory.testcase;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.sampledemo.project.utility.browser;
import com.sampledemo.project.pagefactory.pageobjects.flightFinderPage;
import com.sampledemo.project.pagefactory.pageobjects.homePage;
import com.sampledemo.project.utility.propertyClass;
import com.sampledemo.project.utility.validation;

public class flightFinderPageTestcase extends setupClass {
	

	@Test(priority=1)
	public static void defaultValidation() {
		test = extent.createTest("Valid the default selection of trip type radio button");
		PageFactory.initElements(driver, homePage.class);
		homePage.username.sendKeys(propertyClass.returnValue("username"));
		homePage.password.sendKeys(propertyClass.returnValue("password"));
		homePage.submit.click();
		PageFactory.initElements(driver, flightFinderPage.class);
		boolean roundtrip=flightFinderPage.roundtype.isSelected();
		boolean onewaytrip=flightFinderPage.onewaytype.isSelected();
		softAssert.assertTrue(roundtrip);
		softAssert.assertFalse(onewaytrip);
		softAssert.assertAll();
	}
	
	@Test(priority=2)
	public static void selection() {
		test = extent.createTest("Selecting the drop down value and radio button ");
		PageFactory.initElements(driver, homePage.class);
		homePage.username.sendKeys(propertyClass.returnValue("username"));
		homePage.password.sendKeys(propertyClass.returnValue("password"));
		homePage.submit.click();
		PageFactory.initElements(driver, flightFinderPage.class);
		
		flightFinderPage.onewaytype.click();
		flightFinderPage.selectPassengers(driver, "index","3");
		flightFinderPage.selectDepartingFrom(driver, "visibleText", "London");
		flightFinderPage.selectArrivingIn(driver, "value", "Portland");
		
	}
	
	
	
}

