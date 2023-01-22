package com.tripmaster.service;

import java.util.Random;

public class RandomString {
	
	public static String getRandomNumberString() {
		Random random = new Random();
		int num = random.nextInt(99999);
		String out = String.format("%05d",num);
		return out;
	}

}
