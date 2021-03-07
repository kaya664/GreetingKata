package com.kaya.service;

public class CharMatcher {
	public static boolean isStringAllUppercase(String text) {
		if(text == null || text.trim().length() == 0) {
			return false;
		}
		
		boolean isUpperCase = true;
		for(int i = 0; i < text.length(); i++) {
			isUpperCase = isUpperCase && Character.isUpperCase(text.charAt(i));
		}
		return isUpperCase;
	}
}
