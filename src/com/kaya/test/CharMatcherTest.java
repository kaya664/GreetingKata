package com.kaya.test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import com.kaya.service.CharMatcher;

class CharMatcherTest {
	CharMatcher charMatcher = new CharMatcher();
	@Test
	void testIsStringAllUppercaseTrue() {
		assertTrue(charMatcher.isStringAllUppercase("UPPERCASE"));
	}
	
	@Test
	void testIsStringAllUppercaseFalse() {
		assertFalse(charMatcher.isStringAllUppercase("UpperCase"));
	}

}
