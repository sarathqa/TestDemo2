package com.sampledemo.pageobjectmodel.testcase;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.sampledemo.project.utility.browser;
import com.sampledemo.project.pageobjects.flightFinderPage;
import com.sampledemo.project.pageobjects.homePage;
import com.sampledemo.project.utility.propertyClass;
import com.sampledemo.project.utility.validation;

public class flightFinderPageTestcase {
	static WebDriver driver;
	String userdir = System.getProperty("user.dir");

	@BeforeMethod
	public void browserAndHomePagelanding() {
		propertyClass.propfiles(userdir + "/utility/config.properties");
		driver = browser.browserSelection(propertyClass.returnValue("browser"));
		driver.get(propertyClass.returnValue("url"));
		driver.manage().timeouts().implicitlyWait(1000, TimeUnit.MILLISECONDS);
	}

	@AfterMethod
	public void closingBrowser() {
		driver.close();
	}

	@Test
	public static void defaultValidation() {
		homePage.userName(driver).sendKeys(propertyClass.returnValue("username"));
		homePage.password(driver).sendKeys(propertyClass.returnValue("password"));
		homePage.submitbtn(driver).click();
		boolean roundtrip=flightFinderPage.roundTrip(driver).isSelected();
		boolean onewaytrip=flightFinderPage.oneWayTrip(driver).isSelected();
		validation.valid(roundtrip, "true", "Passed: Given round trip button is selected", "Failed: Given round trip button is not selected ");
		validation.valid(onewaytrip, "false", "Passed: Given oneway trip button is not selected", "Failed: Given oneway trip button is selected ");
		
	}
	
	@Test
	public static void selection() {
		homePage.userName(driver).sendKeys(propertyClass.returnValue("username"));
		homePage.password(driver).sendKeys(propertyClass.returnValue("password"));
		homePage.submitbtn(driver).click();
		flightFinderPage.roundTrip(driver).click();
		flightFinderPage.oneWayTrip(driver).click();
		flightFinderPage.selectPassengers(driver, "index","3");
		flightFinderPage.selectDepartingFrom(driver, "visibleText", "London");
		flightFinderPage.selectArrivingIn(driver, "value", "Portland");
		
	}
	
	
	
}

