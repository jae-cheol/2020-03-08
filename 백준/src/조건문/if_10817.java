package Á¶°Ç¹®;

import java.util.Scanner;

public class if_10817 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int num1 = sc.nextInt();
		int num2 = sc.nextInt();
		int num3 = sc.nextInt();
		int max, min, middle;
		if(num1 >= num2 && num1 >= num3) {
			max = num1;
			if(num2 > num3) {
				middle = num2;
				System.out.println(middle);
			} else {
				middle = num3;
				System.out.println(middle);
			}
		} else if(num2 >= num1 && num2 >= num3) {
			max = num2;
			if(num1 > num3) {
				middle = num1;
				System.out.println(middle);
			} else {
				middle = num3;
				System.out.println(middle);
			}
		} else {
			max = num3;
			if(num1 > num2) {
				middle = num1;
				System.out.println(middle);
			} else {
				middle = num2;
				System.out.println(middle);
			}
		}
	}
}
