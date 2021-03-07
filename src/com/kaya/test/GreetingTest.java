package com.kaya.test;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Arrays;

import org.junit.jupiter.api.Test;

import com.kaya.service.Greeting;

class GreetingTest {
	Greeting greeting = new Greeting();

	@Test
	void testGreet() {
		assertEquals("Hello, Bob!", greeting.greet("Bob"));
	}

	@Test
	void testGreetWithNull() {
		String s = null;
		assertEquals("Hello, my friend!", greeting.greet(s));
	}
	
	@Test
	void testGreetWithShoutingName() {
		assertEquals("HELLO, JERRY!", greeting.greet("JERRY"));
	}
	
	@Test
	void testGreetWithNameArrayOfTwoNames() {
		assertEquals("Hello, Bob and Jerry!", greeting.greet(new String[]{"Bob", "Jerry"}));
	}
	
	@Test
	void testGreetWithNameArrayOfThreeNames() {
		assertEquals("Hello, Bob, Jerry and Jessica!", greeting.greet(new String[]{"Bob", "Jerry", "Jessica"}));
	}
	
	@Test
	void testGreetWithNameArrayOfThreeNamesAndOneUppercase() {
		assertEquals("Hello, Bob and Jessica! HELLO, JERRY!", greeting.greet(new String[]{"Bob", "JERRY", "Jessica"}));
	}
	
	@Test
	void testGreetWithNameArrayOfThreeNamesAndTwoUppercaseOneSplitting() {
		assertEquals("Hello, Bob and Jessica! HELLO, JERRY AND DIANA!", greeting.greet(new String[]{"Bob", "JERRY", "Jessica,DIANA"}));
	}
	
	@Test 
	void testGreetGetLowerCaseNamesOnly() {
		assertEquals(Arrays.asList("Bob","Jerry"), greeting.getOnlyLowerCaseNamesArray(new String[] {"Bob", "Jerry", "JESSICA"}));
	}
	
	@Test
	void testGreetGetUpperCaseNamesOnly() {
		assertEquals(Arrays.asList("JESSICA", "BOB"), greeting.getOnlyUpperCaseNamesArray(new String[] {"JESSICA", "Jerry", "BOB"}));
	}
	
	@Test
	void testGreetSplitStringIntoNamesWithComma() {
		assertEquals(Arrays.asList("Jessica","Jerry"), greeting.getSplittedNameList(new String[] {"Jessica,Jerry"}));
	}
}
