package 클래스와객체;

import java.util.Scanner;

class Util{
	public static final Scanner sc = new Scanner(System.in);
	public static String inputStr(String msg){
		System.out.print(msg);
		return sc.nextLine().trim();
	}
	public static int inputInt(String msg){
		int num;
		while(true){
			try{
				System.out.print(msg);
				num = Integer.parseInt(sc.nextLine());
			}catch(Exception e){ continue;}
			break;
		}
		return num;
	}
}
class Player1 {
	private String name;
	private String word;
	public void sayWord(){ this.word = Util.inputStr(this.name + ">>");}
	public boolean succeed(char word){ return (this.word.charAt(0) == word) ? true : false;}
	public String getName(){return name;}
	public String getWord(){return word;}
	public Player1(String name){this.name = name;}
}

public class 동규_끝말잇기 {
	public static void main(String[] args) {
		int numOfPlayer = Util.inputInt("게임에 참가하는 인원은 몇명입니까?>>");
		Player1[] players = new Player1[numOfPlayer];
		for(int i=0;i<numOfPlayer;i++) players[i] = new Player1(Util.inputStr("참가자의 이름을 입력하세요>>"));
		
		System.out.println("시작하는 단어는 아버지 입니다.");
		int playerIdx = 0;
		String word = "아버지 이제야 깨달아요";
		while(true){
			players[playerIdx].sayWord();
			if(!players[playerIdx].succeed(word.charAt(word.length()-1))){
				System.out.println(players[playerIdx].getName() + "이 졌습니다.");
				break;
			}
			word = players[playerIdx].getWord();
			playerIdx = (playerIdx+1)%numOfPlayer;
		}
	}
}
