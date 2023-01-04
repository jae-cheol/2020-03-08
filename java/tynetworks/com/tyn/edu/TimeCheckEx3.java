package com.tyn.edu;

public class TimeCheckEx3 {
	
	private static String BASE_STRING = "ABCDE";
	private static int LOOP_CNT = 10000;
	
	public static void main(String[] args) {
		long startNano = System.nanoTime();
		
		makeString();
		
		long endNano = System.nanoTime();
		double nanoTime = (endNano - startNano) / 1000000.0;
		System.out.println("String : " + nanoTime);
		
		startNano = System.nanoTime();
		
		makeStringBuffer();
		
		endNano = System.nanoTime();
		nanoTime = (endNano - startNano) / 1000000.0;
		
		System.out.println("StringBuffer : " + nanoTime);
		
	}

	public static void makeString() {
		String string = new String();
		for (int i=0; i<LOOP_CNT; i++) {
			string += BASE_STRING;
		}
	}
	
	public static void makeStringBuffer() {
		StringBuffer buffer = new StringBuffer();
		for (int i=0; i<LOOP_CNT; i++) {
			buffer.append(BASE_STRING);
		}
	}
}
