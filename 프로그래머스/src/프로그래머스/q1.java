package 프로그래머스;

import java.util.Scanner;

public class q1 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		// 자연수 N이 주어짐
		
		String str = Integer.toString(n);
		// 정수를 String으로 변환
		
		int sum = 0;
		
		for (int i=0; i<str.length(); i++) {
			sum += Integer.parseInt(str.charAt(i) + "");
		}
		System.out.println(sum);
	}
}

/*
import java.util.*;

public class Solution {
	public int solution(int n) {
        String str = Integer.toString(n);
		int answer = 0;
		
		for (int i=0; i<str.length(); i++) {
			answer += Integer.parseInt(str.charAt(i) + "");
		}
		return answer;
	}
}
*/