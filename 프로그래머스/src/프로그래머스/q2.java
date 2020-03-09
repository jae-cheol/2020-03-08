package 프로그래머스;

import java.util.ArrayList;
import java.util.List;

public class q2 {
	public static void main(String[] args) {
		int[] arr = {1, 2, 3, 4};
		
		for(int i=0; i<arr.length; i++) {
			for(int j=0; j<i; j++) {
				if(arr[i] == arr[j]) {	// 중복있는지 하나하나 비교
					System.out.println("중복값있음");
//					return false;
				}
				if(arr.length < arr[j]) {
//					return false;
				}
			}
		}
	}
}
/*
class Solution {
    public boolean solution(int[] arr) {
        boolean answer = true;
        for(int i=0; i<arr.length; i++) {
			for(int j=0; j<i; j++) {
				if(arr.length < arr[j] || arr[i] == arr[j]) {
					answer = false;
				}
			}
		}
        return answer;
    }
}
*/