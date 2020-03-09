package com.tyn.edu;

public class TimeCheckEx1 {
	public static void main(String[] args) {
		for(int runCnt = 0; runCnt < 10; runCnt++) {
			long startMilli = System.currentTimeMillis();
			
			doHardWork(100, 100);
			
			long endMilli = System.currentTimeMillis();
			long milliTime = endMilli - startMilli;
			System.out.println("milliTime : " + milliTime);
			
			long startNano = System.nanoTime();
			
			doHardWork(100, 100);
		
			long endNano = System.nanoTime();
			double nanoTime = (endNano - startNano) / 1000000.0;
			System.out.println("nanoTime : " + nanoTime);
		}
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
}