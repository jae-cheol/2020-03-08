package com.tyn.edu;

public class ThreadEx4 {
	public static void main(String[] args) {
		long startTime = System.currentTimeMillis();
		for (int i=0; i<300; i++) {
			System.out.println("-");
		}
		System.out.println("�ҿ�ð�1 : " + (System.currentTimeMillis() - startTime));
		
		for (int i=0; i<300; i++) {
			System.out.println("|");
		}
		
		System.out.println();
	}
}