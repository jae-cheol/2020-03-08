package com.tyn.edu.util;

import java.util.Iterator;
import java.util.Random;
import java.util.Set;

public class RandomKeyUtil {

	
	public static String[] generateRandomSetKeysSwap(Set<String> set) {
		
		int size = set.size();
		String[] result = new String[size];
		
		Random random = new Random();
		Iterator<String> iterator = set.iterator();
		
		int resultPos = 0;
		
		while (iterator.hasNext()) {
			result[resultPos++] = (String) iterator.next();
		}

		// ?„žê¸?
		for (int loop = 0; loop < size; loop++) {
			int randomNumber1 = random.nextInt(size);
			int randomNumber2 = random.nextInt(size);
			String tmp = result[randomNumber2];
			result[randomNumber2] = result[randomNumber1];
			result[randomNumber1] = tmp;
			
		}
		

		return result;
	}
	
	
	
	public static Integer[] generateRandomSetKeysSwap(int size) {
		
		Integer[] result = new Integer[size];
		
		Random random = new Random();
		
		for (int i = 0; i < size; i++) {
			result[i] = i;
		}

		// ?„žê¸?
		for (int loop = 0; loop < size; loop++) {
			int randomNumber1 = random.nextInt(size);
			int randomNumber2 = random.nextInt(size);
			int tmp = result[randomNumber2];
			result[randomNumber2] = result[randomNumber1];
			result[randomNumber1] = tmp;
			
		}
		

		return result;
	}
}
