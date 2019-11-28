package com.sampledemo.project.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class signOnPage {
	
	//Locators Name
     private  static String Uname = "userName";
     private  static String pswd="password";
     private  static String subbtn="login";
     
     
     public static String getUname() {
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

}
