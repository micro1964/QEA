package com.poc;

import static org.junit.Assert.assertEquals;

import org.junit.Test;


public class Junit_Poc2 {
	
	@Test
	public void addTwoNumbers() {
		int num1 =2,num2=4;
		
		int results = num1 + num2;
		
		assertEquals(results, 6);
	}

}
