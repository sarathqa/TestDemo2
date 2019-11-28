package com.sampledemo.project.pagefactory.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class signOnPage {
	
	//Locators Name
	@FindBy(name="userName")
     public  static WebElement username;
	@FindBy(name="password")
     public  static WebElement password;
	@FindBy(name="login")
     public  static WebElement loginbtn;
     
     
    /* public static String getUname() {
		return Uname;
	}

	public static String getPswd() {
		return pswd;
	}
	public static String getsubbtn() {
		return subbtn;
	}

	public static WebElement userName(WebDriver driver) {

		return driver.findElement(By.name(getUname()));
	}

	public static WebElement password(WebDriver driver) {

		return driver.findElement(By.name(getPswd()));
	}

	public static WebElement submitbtn(WebDriver driver) {

		return driver.findElement(By.name(getsubbtn()));
	}
*/
}
