package 클래스와객체;

import java.util.Scanner;

public class WordGameApp {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String name;
		String word;
		String start = "아버지";
		char c=0;
		char firstChar;
		System.out.println("게임에 참가하는 인원은 몇명입니까>>");
		int N = Integer.parseInt(sc.nextLine());
		
		// 인원에 맞게 Player 객체 배열 생성.
		Player[] p = new Player[N];
		for(int i=0; i<N; i++){
			p[i] = new Player();
		}
		
		for(int i=0; i<N; i++){
			System.out.println("참가자의 이름을 입력하세요>>");
			name = sc.next();
			p[i].setName(name);
		}
		
		System.out.println("시작하는 단어는 " + start + "입니다.");
		int cnt = 0;
		while(true) {
			for (int i = 0; i < N; i++) {
				System.out.println(p[i].getName() + ">>");

				word = sc.next();
				firstChar = word.charAt(0); // 첫번째 문자

				if(cnt == 0){
					if (p[i].sayWord(start) == firstChar) { // 지 == 현재입력의 첫글자.
						c = p[i].sayWord(word); // 
					} else {
						System.out.println(p[i].getName() + "이 졌습니다.");
						System.exit(0);
					}
				} else {
					if(c == firstChar){
						c = p[i].sayWord(word);
					} else {
						System.out.println(p[i].getName() + "이 졌습니다.");
						System.exit(0);
					}
						
				}
				cnt++;
			}
		}
	}
}