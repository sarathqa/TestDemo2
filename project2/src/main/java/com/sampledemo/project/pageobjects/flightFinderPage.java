package com.sampledemo.project.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import com.sampledemo.project.utility.selectCls;

public class flightFinderPage extends selectCls {

	private static String roundtype = "//*[@name='tripType' and @value='roundtrip']";
	private static String onewaytype = "//*[@name='tripType' and @value='oneway']";
	private static String Passengers = "passCount";
	private static String Departingfrom = "fromPort";
	private static String Departingon = "fromMonth"; // fromDay
	private static String Arrivingin = "toPort";
	private static String Returning = "toMonth";// toDay
	private static String Serviceclass = "servClass";
	private static String airline = "airline";
	private static String ctnbtn = "findFlights";
	

	static selectCls sel;

	public static String getRoundType() {
		return roundtype;
	}
	public static String getOnewayType() {
		return onewaytype;
	}
	public static String getPassengers() {
		return Passengers;
	}

	public static String getDepartingfrom() {
		return Departingfrom;
	}

	public static String getDepartingon() {
		return Departingon;

	}

	public static String getArrivingin() {
		return Arrivingin;
	}

	public static String getReturning() {
		return Returning;
	}

	public static String getServiceclass() {
		return Serviceclass;
	}

	public static String getAirline() {
		return airline;
	}

	public static String getCtnbtn() {
		return ctnbtn;
	}

	public static WebElement roundTrip(WebDriver driver) {

		return driver.findElement(By.xpath(getRoundType()));
	}

	public static WebElement oneWayTrip(WebDriver driver) {

		return driver.findElement(By.xpath(getOnewayType()));
	}

	
	public static void selectPassengers(WebDriver driver, String selectOption, String dropdownValue) {
		
		sel.selectClass(driver.findElement(By.name(getPassengers())), selectOption, dropdownValue);

	}

	public static void selectDepartingFrom(WebDriver driver, String selectOption, String dropdownValue) {

		sel.selectClass(driver.findElement(By.name(getDepartingfrom())), selectOption, dropdownValue);

	}
	

	public static void selectDepartingOn(WebDriver driver, String selectOption, String dropdownValue) {

		sel.selectClass(driver.findElement(By.name(getDepartingon())), selectOption, dropdownValue);
	}

	public static void selectArrivingIn(WebDriver driver, String selectOption, String dropdownValue) {

		sel.selectClass(driver.findElement(By.name(getArrivingin())), selectOption, dropdownValue);
	}

	public static void selectReturning(WebDriver driver, String selectOption, String dropdownValue) {

		sel.selectClass(driver.findElement(By.name(getReturning())), selectOption, dropdownValue);
	}

	public static WebElement serviceClass(WebDriver driver) {

		return driver.findElement(By.name(getServiceclass()));
	}

	public static WebElement airline(WebDriver driver) {

		return driver.findElement(By.name(getAirline()));
	}

	public static WebElement ctnbtn(WebDriver driver) {

		return driver.findElement(By.name(getCtnbtn()));
	}

}
