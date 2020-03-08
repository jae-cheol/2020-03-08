package com.tyn.edu;

import javax.swing.JOptionPane;

public class ThreadEx7 {
	public static void main(String[] args) {
		ThreadEx7_1 th1 = new ThreadEx7_1();
		th1.start();
		
		String input = JOptionPane.showInputDialog("?•„ë¬? ê°’ì´?‚˜ ?ž…? ¥?•˜?„¸?š”.");
		System.out.println("?ž…? ¥?•˜?‹  ê°’ì? " + input + "?ž…?‹ˆ?‹¤.");
	}
}

class ThreadEx7_1 extends Thread {
	public void run() {
		for (int i=10; i>0; i--) {
			System.out.println(i);
			try {
				sleep(1000);
			} catch(Exception e) {}
		}
	}
}