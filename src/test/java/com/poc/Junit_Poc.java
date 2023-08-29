package com.poc;

import static org.junit.Assert.*;

public class Junit_Poc {

	public static int addNumbers(int num1,int num2) {
		return num1 + num2;
	}
	
	public static void main(String[] args) {
		//Junit_Poc jp = new Junit_Poc();
		//jp.addNumbers(2, 4);
		
		assertEquals(6, Junit_Poc.addNumbers(2, 4));
		System.out.println("123...");

	}

}
