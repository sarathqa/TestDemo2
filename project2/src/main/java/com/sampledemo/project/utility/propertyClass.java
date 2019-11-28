package com.sampledemo.project.utility;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class propertyClass {

	static Properties properties = null;
	static FileInputStream fis;

	public static Properties propfiles(String filepath) {

		properties = new Properties();
		try {
			
			fis = new FileInputStream(filepath);
		} 
		
		catch (FileNotFoundException e) {

			System.out.println("File is not found in the given path");
		}
		try {
			
			properties.load(fis);
		} 
		
		catch (IOException e) {

			System.out.println("Property File is unable to load");
		}
		
		return properties;

	}
	
	public static String returnValue(String Key) {
		
		String value=properties.getProperty(Key);
		return value;
	}

}
