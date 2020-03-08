package com.tyn.edu;

public class TimeCheckEx2 {
	public static void main(String[] args) {
		long startNano = System.nanoTime();
		
		doHardWork(10, 10);
	
		long endNano = System.nanoTime();
		double nanoTime = (endNano - startNano) / 1000000.0;
		
		startNano = System.nanoTime();
		
		doHardWorkWithSysout(10, 10);
		
		endNano = System.nanoTime();
		double nanoTimeWithSysout = (endNano - startNano) / 1000000.0;
		
		System.out.println("\n================");
		System.out.println("nanoTime : " + nanoTime);
		System.out.println("nanoTimeWithSysout : " + nanoTimeWithSysout);
	}

	public static int doHardWork(int n, int m) {
		int result = 1;
		for (int i=0; i<n; i++) {
			for (int j=0; j<m; j++) {
				for (int k=0; k<n+m; k++) {
					for (int l=0; l<n*m; l++) {
						result *=2;
					}
				}
			}
		}
		return result;
	}
	
	public static int doHardWorkWithSysout(int n, int m) {
		int result = 1;
		for (int i=0; i<n; i++) {
//			System.out.println("result : " + result);
			for (int j=0; j<m; j++) {
//				System.out.println("result : " + result);
				for (int k=0; k<n+m; k++) {
//					System.out.println("result : " + result);
					for (int l=0; l<n*m; l++) {
						System.out.println("result : " + result);
						result *=2;
					}
				}
			}
		}
		return result;
	}
}