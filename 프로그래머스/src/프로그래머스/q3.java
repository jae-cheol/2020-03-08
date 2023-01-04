package 프로그래머스;

public class q3 {
	public static void main(String[] args) {
		int[][] v = {{1,1}
						, {2,2}
						, {1,2}
						};
		int n1;
		int n2;
		
		if ( v[0][0] == v[1][0] ) {
			System.out.println("v[2][0] : " + v[2][0]);
			n1 = v[2][0];
		} else if (v[0][0] == v[2][0]) {
			System.out.println("v[1][0] : " + v[1][0]);
			n1 = v[1][0];
		} else {
			System.out.println("v[0][0] : " + v[0][0]);
			n1 = v[0][0];
		}
		
		if (v[0][1] == v[1][1]) {
			System.out.println("v[2][1] : " + v[2][1]);
			n2 = v[2][1];
		} else if (v[0][1] == v[2][1]) {
			System.out.println("v[2][1] : " + v[2][1]);
			n2 = v[2][1];
		} else {
			System.out.println("v[2][1] : " + v[0][1]);
			n2 = v[0][1];
		}
		
		System.out.println("-----------------");
		System.out.println(v[0][0]);
		System.out.println(v[1][0]);
		System.out.println(v[2][0]);
		System.out.println("-----------------");
		System.out.println(v[0][1]);
		System.out.println(v[1][1]);
		System.out.println(v[2][1]);
	}
}
/*
class Solution {
    public int[] solution(int[][] v) {
        int n1 = 0;
		int n2 = 0;
		
		if ( v[0][0] == v[1][0] ) {
			n1 = v[2][0];
		} else if (v[0][0] == v[2][0]) {
			n1 = v[1][0];
		} else {
			n1 = v[0][0];
		}
		
		if (v[0][1] == v[1][1]) {
			n2 = v[2][1];
		} else if (v[0][1] == v[2][1]) {
			n2 = v[2][1];
		} else {
			n2 = v[0][1];
		}
        int[] answer = {n1, n2};

        return answer;
    }
}
*/
