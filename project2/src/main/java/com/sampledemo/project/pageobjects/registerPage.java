package com.sampledemo.project.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class registerPage {
	
	//Locators Name
    private  static String Uname = "email";
    private  static String pswd="password";
    private  static String confirmpswd="confirmPassword";
    private  static String subbtn="register";
    
    
    public static String getUname() {
		return Uname;
	}

	public static String getPswd() {
		return pswd;
	}
	
	public static String getConfirmpswd() {
		return confirmpswd;
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
	public static WebElement confirmpassword(WebDriver driver) {

		return driver.findElement(By.name(getConfirmpswd()));
	}

	public static WebElement submitbtn(WebDriver driver) {

		return driver.findElement(By.name(getsubbtn()));
	}

}
