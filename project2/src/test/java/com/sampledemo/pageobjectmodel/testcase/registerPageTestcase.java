package com.sampledemo.pageobjectmodel.testcase;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.sampledemo.project.utility.browser;
import com.sampledemo.project.utility.excelFunction;
import com.sampledemo.project.pageobjects.homePage;
import com.sampledemo.project.utility.propertyClass;
import com.sampledemo.project.pageobjects.registerPage;

public class registerPageTestcase {

	static WebDriver driver;
	static String userdir = System.getProperty("user.dir");

	@BeforeMethod
	public void browserAndHomePagelanding() {

		propertyClass.propfiles(userdir + "/utility/config.properties");

		driver = browser.browserSelection(propertyClass.returnValue("browser"));
		driver.get(propertyClass.returnValue("url"));
		driver.manage().timeouts().implicitlyWait(1000, TimeUnit.MILLISECONDS);
	}

	/*
	 * @AfterMethod public void closingBrowser() { driver.close(); }
	 */

	@DataProvider
	public static Object[][] data() {

		String Filename = userdir + "/utility/testdata.xlsx";
		excelFunction.loadWorkbook(Filename);
		int lastCellNumb = excelFunction.getcol("Testdata");
		int rowC = excelFunction.getrows("Testdata");
		Object[][] obj = new Object[rowC][1];
		for (int k = 0; k < rowC; k++) {
			HashMap<Object, Object> datamap = new HashMap<>();
			for (int j = 0; j < lastCellNumb; j++) {
				datamap.put(excelFunction.getdata("Testdata", 0, j), excelFunction.getdata("Testdata", k + 1, j));

			}
			obj[k][0] = datamap;

		}

		return obj;
	}

	@Test(dataProvider = "data")
	public void registration(Map<Object, Object> mp) {
		homePage.Registerlink(driver).click();
		registerPage.userName(driver).sendKeys((String) mp.get("username"));
		registerPage.password(driver).sendKeys((String) mp.get("password"));
		registerPage.confirmpassword(driver).sendKeys((String) mp.get("confirmpassword"));
		registerPage.submitbtn(driver);
	}

}
