package com.sampledemo.project.pagefactory.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class registerPage {
	
	@FindBy(name="email")
    public  static WebElement Username;
	@FindBy(name="password")
	public  static WebElement password;
	@FindBy(name="confirmPassword")
	public  static WebElement confirmPassword;
	@FindBy(name="register")
	public  static WebElement submitbtn;
    
    
   
}
