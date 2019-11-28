package com.sampledemo.project.pagefactory.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

import com.sampledemo.project.utility.selectCls;

public class flightFinderPage extends selectCls {

	@FindBy(xpath="//*[@name='tripType' and @value='roundtrip']")
	public static WebElement roundtype;
	@FindBy(xpath="//*[@name='tripType' and @value='oneway']")
	public static WebElement onewaytype;
	@FindBy(name="passCount")
	public static WebElement Passengers;
	@FindBy(name="fromPort")
	public static WebElement Departingfrom;
	@FindBy(name="fromMonth")
	public static WebElement Departingon;
	@FindBy(name="toPort")
	public static WebElement Arrivingin;
	@FindBy(name="toMonth")
	public static WebElement Returning;
	@FindBy(name="servClass")
	public static WebElement Serviceclass;
	@FindBy(name="airline")
	public static WebElement airline;
	@FindBy(name="findFlights")
	public static WebElement ctnbtn;
	static selectCls sel;

	
	
	
	public static void selectPassengers(WebDriver driver, String selectOption, String dropdownValue) {
		
		sel.selectClass(Passengers, selectOption, dropdownValue);
	}

	public static void selectDepartingFrom(WebDriver driver, String selectOption, String dropdownValue) {

		sel.selectClass(Departingfrom, selectOption, dropdownValue);
	}
	
	public static void selectDepartingOn(WebDriver driver, String selectOption, String dropdownValue) {

		sel.selectClass(Departingon, selectOption, dropdownValue);
	}

	public static void selectArrivingIn(WebDriver driver, String selectOption, String dropdownValue) {

		sel.selectClass(Arrivingin, selectOption, dropdownValue);
	}

	public static void selectReturning(WebDriver driver, String selectOption, String dropdownValue) {

		sel.selectClass(Returning, selectOption, dropdownValue);
	}

	
}
