package ����;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

class MethodExam {
	
	// 1 ~ 100 ������ ������ 10�� �߻����� �迭 ����
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
	 * 1 ~ max������ ������ size�� �����Ͽ� �迭 ���� 
	 * @param �迭����
	 * @param 1~����ɹ���
	 * @return �迭
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
		System.out.println("< �� " + nums.length + "�� ���� ��� >");
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
		
		// 1 ~ 100 ������ ������ 10�� �����Ͽ� �迭�� ����
		int[] arr = exam.getNums();
		exam.displayArr(arr);
		// 1 ~ 100 ������ ������ size����ŭ �����Ͽ� �迭�� ����
		int size = exam.getInt("�迭�� ���Ұ��� �Է� : ");
		arr = exam.getNums(size);
		exam.displayArr(arr);
		int max = exam.getInt("1 ~ ������ ������ �ִ������ �Է� : ");
		arr = exam.getNums(size, max);	// 1 ~ max������ ������ size����ŭ �����Ͽ� �迭�� ����
		exam.displayArr(arr);
	}
}