
package com.sampledemo.pageobjectmodel.testcase;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.sampledemo.project.utility.browser;
import com.sampledemo.project.pageobjects.homePage;
import com.sampledemo.project.utility.propertyClass;
import com.sampledemo.project.utility.validation;

import io.github.bonigarcia.wdm.WebDriverManager;
import okio.Timeout;

public class loginPageTestcase extends propertyClass {
	WebDriver driver;
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

	@Test(priority = 1)
	public void validLogin() {
		homePage.userName(driver).sendKeys(propertyClass.returnValue("username"));
		homePage.password(driver).sendKeys(propertyClass.returnValue("password"));
		homePage.submitbtn(driver).click();
		validation.valid(driver.getTitle(), propertyClass.returnValue("expectedtitleofFlightfinderpage"),
				"PASSED: Login Success and Navigate to Flight findder Page",
				"FAILED: Login unSuccess and Navigate to ");

	}

	@Test(priority = 2)
	public void dataVerificationinLogin() {

		String actualKeyData = homePage.Specialkey(driver).getText();
		String actualValueData = homePage.Specialdata(driver).getText();

		validation.valid(actualKeyData, propertyClass.returnValue("expectedKeyData"),
				"PASSED: KeyData is matched with expected", "FAILED: KeyData is mismatched. Actual KeyData is  ");

		validation.valid(actualValueData, propertyClass.returnValue("expectedValueData"),
				"PASSED: ValueData is matched with expected", "FAILED: ValueData is mismatched. Actual ValueData is  ");

	}

}
