package com.sampledemo.project.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class homePage {

	private static String Uname = "userName";
	private static String pswd = "password";
	private static String signonlink = "SIGN-ON";
	private static String registerlink = "REGISTER";
	private static String supportlink = "SUPPORT";
	private static String contactLink = "CONTACT";
	private static String Specialkey = "/html/body/div/table/tbody/tr/td[2]/table/tbody/tr[4]/td/table/tbody/tr/td[2]/table/tbody/tr[2]/td[1]/table[1]/tbody/tr[3]/td/table/tbody/tr[1]/td[1]";
	private static String Specialdata = "/html/body/div/table/tbody/tr/td[2]/table/tbody/tr[4]/td/table/tbody/tr/td[2]/table/tbody/tr[2]/td[1]/table[1]/tbody/tr[3]/td/table/tbody/tr[1]/td[2]";

	
	public static String getContactLink() {
		return contactLink;
	}

	public static String getSpecialkey() {
		return Specialkey;
	}

	public static String getSpecialdata() {
		return Specialdata;
	}

	public static String getSignonlink() {
		return signonlink;
	}

	public static String getRegisterlink() {
		return registerlink;
	}

	public static String getSupportlink() {
		return supportlink;
	}

	public static String getContactlink() {
		return contactLink;
	}

	public static String getUname() {
		return Uname;
	}

	public static String getPswd() {
		return pswd;
	}

	public static WebElement userName(WebDriver driver) {

		return driver.findElement(By.name(getUname()));
	}

	public static WebElement password(WebDriver driver) {

		return driver.findElement(By.name(getPswd()));
	}

	public static WebElement submitbtn(WebDriver driver) {

		return driver.findElement(By.name("login"));
	}

	public static WebElement Signonlink(WebDriver driver) {

		return driver.findElement(By.partialLinkText(getSignonlink()));
	}

	public static WebElement Registerlink(WebDriver driver) {

		return driver.findElement(By.partialLinkText(getRegisterlink()));
	}

	public static WebElement Supportlink(WebDriver driver) {

		return driver.findElement(By.partialLinkText(getSupportlink()));
	}

	public static WebElement Contactlink(WebDriver driver) {

		return driver.findElement(By.partialLinkText(getContactlink()));
	}

	public static WebElement Specialkey(WebDriver driver) {

		return driver.findElement(By.xpath(getSpecialkey()));
	}
	
	public static WebElement Specialdata(WebDriver driver) {

		return driver.findElement(By.xpath(getSpecialdata()));
	}
}
