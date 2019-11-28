package com.sampledemo.pagefactory.testcase;

import org.openqa.selenium.WebDriver;

import com.sampledemo.project.pageobjects.flightFinderPage;

public class testcase2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
       WebDriver driver = null;
	flightFinderPage.selectPassengers(driver,"Visibletext","drop");
	}

}
