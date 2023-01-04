package Deque;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Deque;
import java.util.LinkedList;

public class 뱀_3190 {

	public static void main(String[] args) throws Exception {
		// 입력
		InputStream is = System.in;						// byte
		InputStreamReader isr = new InputStreamReader(is);// character
		BufferedReader br = new BufferedReader(isr);	// String
		
		// 출력
		StringBuffer sb = new StringBuffer();

		int n = Integer.parseInt(br.readLine());	// 보드의 크기
		int[][] board = new int[n+1][n+1];	// Default:0 , 사과가 있는곳:1 , 뱀의 위치:2
		board[1][1] = 2;	// 뱀의 머리 현재 위치 초기화(처음에는 머리지만 이후에는 몸의 위치)
		
		int k = Integer.parseInt(br.readLine());	// 사과의 개수
		for(int i=0; i<k; i++) {
			int k1 = Integer.parseInt(br.readLine());	// 사과의 위치(행)
			int k2 = Integer.parseInt(br.readLine());	// 사과의 위치(열)
			board[k1][k2] = 1;	// 보드안에서 사과의 위치
		}

		int l = Integer.parseInt(br.readLine());	// 뱀의 방향 변환 횟수
		for(int i=0; i<l; i++) {
			int l1 = Integer.parseInt(br.readLine());	// 뱀의 방향 변환 정보(몇초뒤 이동정보)
			String l2 = br.readLine();	// 뱀의 방향 변환 정보(L:왼쪽 , D:오른쪽)
		}
		
		int end = 0;
		String direction = "Right";	// 뱀이 나아가는 방향(초기값:Right)
		while(true) {
			end++;
			if("Right".equals(direction)) {
//				if()
			} else if("Left".equals(direction)) {
			} else if("Up".equals(direction)) {
			} else if("Down".equals(direction)) {
			}
		}
		
		
		
//		String s = "";
//		Deque<Integer> dq = new LinkedList<Integer>();
	}

}
