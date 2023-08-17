package com.poc;

import java.util.Random;

public class Simple {

	/*
	 * Generates a random number between 1 and the maxNumber
	 */
	public int getNumber(int maxNumber) {
		
		Random random = new Random();

        int value = random.nextInt(maxNumber + 1) + 1;
		
		return value;
		}
	
	public static void main(String[] args) {
		// 1 - Create Object of class	

		// 2 - Call getNumber method to generate a number between 1 & 6
		
		}

}
