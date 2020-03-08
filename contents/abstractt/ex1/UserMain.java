package contents.abstractt.ex1;

import java.util.Scanner;

public class UserMain {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		System.out.print("출력할 프린터를 선택하세요(1. LG  2. Samsung) : ");
		int no = sc.nextInt();
		
		Menu menu = new Menu();
		menu.print(no);
	}
}
