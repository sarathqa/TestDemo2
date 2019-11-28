package com.sampledemo.project.utility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class selectCls {
	
	
	public static Select selectClass(WebElement driver, String selectOption, String dropdownValue) 
	{
		Select sel = new Select(driver);
		if(selectOption.equalsIgnoreCase("visibletext")) {
			 sel.selectByVisibleText(dropdownValue);
		}
		else if(selectOption.equalsIgnoreCase("value")) {
			sel.selectByValue(dropdownValue);
		}
		else if (selectOption.equalsIgnoreCase("index")) {
			int index=Integer.parseInt(dropdownValue);
			sel.selectByIndex(index);
		}
		return sel;
		
		
		

	}

	

}
