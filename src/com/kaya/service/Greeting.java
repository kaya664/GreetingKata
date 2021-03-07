package com.kaya.service;

import java.util.ArrayList;
import java.util.List;

public class Greeting {
	
	public String greet(String name) {
		String greetingName = name != null ? name : "my friend";
		return !CharMatcher.isStringAllUppercase(greetingName) ? "Hello, " + greetingName + "!" : "HELLO, " + greetingName + "!";
	}

	public String greet(String[] strings) {
		String greetingNamesLowercase = "";
		String greetingNamesUppercase = " HELLO, ";
		List<String> splittedNameList = getSplittedNameList(strings);
		String[] splittedStringArray = null;
		if(splittedNameList != null)
			splittedStringArray = new String[splittedNameList.size()];
		
		splittedNameList.toArray(splittedStringArray);
		strings = splittedStringArray;
		List<String> upperCaseNames = getOnlyUpperCaseNamesArray(strings);
		List<String> lowerCaseNames = getOnlyLowerCaseNamesArray(strings);
		
		int index = 0;
		for(String name: lowerCaseNames) {
			if(index != 0) {
				if((index + 1) == lowerCaseNames.size()) {
					greetingNamesLowercase += " and ";
				} else {
					greetingNamesLowercase += ", ";
				}
			}

			greetingNamesLowercase += name;
			index++;
		}
		
		index = 0;
		for(String name: upperCaseNames) {
			if(index != 0) {
				if((index + 1) == upperCaseNames.size()) {
					greetingNamesUppercase += " AND ";
				} else {
					greetingNamesUppercase += ", ";
				}
			}

			greetingNamesUppercase += name;
			index++;
		}
		return "Hello, " + greetingNamesLowercase + "!" + (upperCaseNames != null && upperCaseNames.size() > 0 ? greetingNamesUppercase + "!" : "");
	}

	public List<String> getOnlyLowerCaseNamesArray(String[] strings) {
		List<String> lowerCaseNameList = new ArrayList<String>();
		if(strings == null || strings.length == 0)
			return null;
		
		for(String name: strings) {
			if(!CharMatcher.isStringAllUppercase(name)) {
				lowerCaseNameList.add(name);
			}
		}
		return lowerCaseNameList;
	}

	public List<String> getOnlyUpperCaseNamesArray(String[] strings) {
		List<String> upperCaseNameList = new ArrayList<String>();
		if(strings == null || strings.length == 0)
			return null;
		
		for(String name: strings) {
			if(CharMatcher.isStringAllUppercase(name)) {
				upperCaseNameList.add(name);
			}
		}
		return upperCaseNameList;
	}

	public List<String> getSplittedNameList(String[] strings) {
		// TODO Auto-generated method stub
		List<String> nameList = new ArrayList<>();
		if(strings == null || strings.length == 0)
			return null;
		
		for(String name:strings) {
			if(name.contains(",")) {
				String[] splittedString = name.split(",");
				for(String splittedName: splittedString) {
					if(splittedName.length() > 0) {
						nameList.add(splittedName);
					}
				}
			} else {
				nameList.add(name);
			}
		}
		return nameList;
	}
	
}
