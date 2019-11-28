package com.sampledemo.project.utility;

public class validation {
	
	public static void valid(String Actual, String Expected, String passmessage, String failmessage) {
		
		if (Actual.equals(Expected)) {
			System.out.println(passmessage);
		} else {
			System.out.println(failmessage);
		}

	}
	
public static void valid(boolean Act, String Expected, String passmessage, String failmessage) {
		String Actual =Boolean.toString(Act);
		if (Actual.equals(Expected)) {
			System.out.println(passmessage);
		} else {
			System.out.println(failmessage);
		}

	}

}
