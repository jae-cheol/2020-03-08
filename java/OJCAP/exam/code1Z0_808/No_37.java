package exam.code1Z0_808;
/*
 * 정수배열은 할당 될때 0으로 초기화 된다. 
 */
public class No_37 {
	public static void main(String[] args) {
		int numbers[];
		numbers = new int[2];
		numbers[0] = 10;
		numbers[1] = 20;
		
		numbers = new int[4];
		numbers[2] = 30;
		numbers[3] = 40;
		
		for(int x : numbers) {
			System.out.print(" " + x);
		}
	}
}
