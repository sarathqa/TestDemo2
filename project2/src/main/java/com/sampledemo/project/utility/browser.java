package com.sampledemo.project.utility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class browser {
	static WebDriver driver;
	public static WebDriver browserSelection(String browsername) {

		if (browsername.equalsIgnoreCase("Chrome")) {

			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
			
		}

		else if (browsername.equalsIgnoreCase("Firefox")) {

			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();

		}

		else {

			System.out.println("Browser is not available");
		}
		return driver;
	}
	

}
