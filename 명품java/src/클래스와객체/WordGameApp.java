package Ŭ�����Ͱ�ü;

import java.util.Scanner;

public class WordGameApp {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String name;
		String word;
		String start = "�ƹ���";
		char c=0;
		char firstChar;
		System.out.println("���ӿ� �����ϴ� �ο��� ����Դϱ�>>");
		int N = Integer.parseInt(sc.nextLine());
		
		// �ο��� �°� Player ��ü �迭 ����.
		Player[] p = new Player[N];
		for(int i=0; i<N; i++){
			p[i] = new Player();
		}
		
		for(int i=0; i<N; i++){
			System.out.println("�������� �̸��� �Է��ϼ���>>");
			name = sc.next();
			p[i].setName(name);
		}
		
		System.out.println("�����ϴ� �ܾ�� " + start + "�Դϴ�.");
		int cnt = 0;
		while(true) {
			for (int i = 0; i < N; i++) {
				System.out.println(p[i].getName() + ">>");

				word = sc.next();
				firstChar = word.charAt(0); // ù��° ����

				if(cnt == 0){
					if (p[i].sayWord(start) == firstChar) { // �� == �����Է��� ù����.
						c = p[i].sayWord(word); // 
					} else {
						System.out.println(p[i].getName() + "�� �����ϴ�.");
						System.exit(0);
					}
				} else {
					if(c == firstChar){
						c = p[i].sayWord(word);
					} else {
						System.out.println(p[i].getName() + "�� �����ϴ�.");
						System.exit(0);
					}
						
				}
				cnt++;
			}
		}
	}
}