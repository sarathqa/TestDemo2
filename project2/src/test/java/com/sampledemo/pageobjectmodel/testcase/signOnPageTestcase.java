package com.sampledemo.pageobjectmodel.testcase;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.sampledemo.project.utility.browser;
import com.sampledemo.project.pageobjects.homePage;
import com.sampledemo.project.utility.propertyClass;
import com.sampledemo.project.pageobjects.signOnPage;
import com.sampledemo.project.utility.validation;

public class signOnPageTestcase {
	WebDriver driver;
	String userdir = System.getProperty("user.dir");

	@BeforeMethod
	public void browserAndHomePagelanding() {
		propertyClass.propfiles(userdir + "/utility/config.properties");
		driver=browser.browserSelection(propertyClass.returnValue("browser"));
		driver.get(propertyClass.returnValue("url"));
		homePage.Signonlink(driver).click();
	}
	@AfterMethod
	public void closingBrowser() {
		driver.close();
	}

	@Test(priority = 1)
	public void navigationOfSignOnPage() {

		String actualSignonPageTitle = driver.getTitle();
		Assert.assertEquals(actualSignonPageTitle, propertyClass.returnValue("expectedSignonPageTitle"));
		System.out.println("Navigated to Sign-On Page");
	}

	@Test(priority = 2)
	public void lengthOfTextbox() {

		String lenofusername = signOnPage.userName(driver).getAttribute("maxlength");
		validation.valid(lenofusername,"60","PASSED: Length of the username text box is 60","FAILED: Length of the username text box is not matched with expected and Actual length is ");
		
		String lenofpswd = signOnPage.password(driver).getAttribute("maxlength");
        validation.valid(lenofpswd,"60","PASSED: Length of the password text box is 60","FAILED: Length of the password text box is not matched with expected and Actual length is ");

	
	}

	@Test(priority = 3)
	public void contentVerification() {

		String Actualcontent = driver.findElement(By.xpath("/html/body/div/table/tbody/tr/td[2]/table/tbody/tr[4]/td/table/tbody/tr/td[2]/table/tbody/tr[3]/td/p/font")).getText();
		
		validation.valid(Actualcontent,propertyClass.returnValue("expectedContent"),"PASSED: Content displayed in Sign-on page is matched with requirement","FAILED: Content displayed in Sign-on page is not matched with requirement ");


		
	}

	@Test(priority = 4)
	public void formatOfContent() {

		String boldcontent = driver.findElement(By.xpath(
				"/html/body/div/table/tbody/tr/td[2]/table/tbody/tr[4]/td/table/tbody/tr/td[2]/table/tbody/tr[3]/td/p/font/b"))
				.getCssValue("font-weight");
		
		String Actuallinkcontent = driver.findElement(By.xpath(
				"/html/body/div/table/tbody/tr/td[2]/table/tbody/tr[4]/td/table/tbody/tr/td[2]/table/tbody/tr[3]/td/p/font/a"))
				.getText();

		validation.valid(boldcontent,"700","PASSED: Content displayed is in bold","FAILED: Content displayed is not in bold ");

        validation.valid(Actuallinkcontent,propertyClass.returnValue("expectedLinkContent"),"PASSED: Content displayed is in link","FAILED: Content displayed is not in link ");

		
		
		
		
	}
}
