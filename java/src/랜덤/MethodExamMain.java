package 랜덤;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

class MethodExam {
	
	// 1 ~ 100 사이의 난수를 10개 발생시켜 배열 저장
	int[] getNums() {
//		int[] nums = getNums(10);
		int[] nums = getNums(10, 100);
//		int[] nums = new int[10];
//		Random r = new Random();	
//		for(int i = 0; i < nums.length; i++) {
//			int random = r.nextInt(100) + 1;
//			nums[i] = random;
//		}
		return nums;
	}
	
	int[] getNums(int size) {
		int[] nums = getNums(size, 100);
//		int[] nums = new int[size];
//		Random r = new Random();
//		for(int i = 0; i < nums.length; i++) {
//			nums[i] = r.nextInt(100) + 1;
//		}
		return nums;
	}
	
	/**
	 * 1 ~ max사이의 난수를 size개 추출하여 배열 저장 
	 * @param 배열개수
	 * @param 1~추출될범위
	 * @return 배열
	 */
	int[] getNums(int size, int max) {
		Random r = new Random();
		int[] nums = new int[size];
		for(int i = 0; i < nums.length; i++) {
			nums[i] = r.nextInt(max) + 1;
		}
		return nums;
	}
	
	void displayArr(int[] nums) {
		System.out.println("< 총 " + nums.length + "개 정수 출력 >");
//		for(int num : nums) {
//			System.out.print(num + "  ");
//		}
//		System.out.println();
		System.out.println(Arrays.toString(nums));
	}
	
	int getInt(String msg) {
		Scanner sc = new Scanner(System.in);
		System.out.print(msg);
		int num = sc.nextInt();
		return num;
	}
}

public class MethodExamMain {
	public static void main(String[] args) {
		MethodExam exam = new MethodExam();
		
		// 1 ~ 100 사이의 난수를 10개 추출하여 배열에 저장
		int[] arr = exam.getNums();
		exam.displayArr(arr);
		// 1 ~ 100 사이의 난수를 size개만큼 추출하여 배열에 저장
		int size = exam.getInt("배열의 원소개수 입력 : ");
		arr = exam.getNums(size);
		exam.displayArr(arr);
		int max = exam.getInt("1 ~ 추출한 난수의 최대범위를 입력 : ");
		arr = exam.getNums(size, max);	// 1 ~ max사이의 난수를 size개만큼 추출하여 배열에 저장
		exam.displayArr(arr);
	}
}