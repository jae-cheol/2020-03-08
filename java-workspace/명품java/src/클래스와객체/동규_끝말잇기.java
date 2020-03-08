package Ŭ�����Ͱ�ü;

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

public class ����_�����ձ� {
	public static void main(String[] args) {
		int numOfPlayer = Util.inputInt("���ӿ� �����ϴ� �ο��� ����Դϱ�?>>");
		Player1[] players = new Player1[numOfPlayer];
		for(int i=0;i<numOfPlayer;i++) players[i] = new Player1(Util.inputStr("�������� �̸��� �Է��ϼ���>>"));
		
		System.out.println("�����ϴ� �ܾ�� �ƹ��� �Դϴ�.");
		int playerIdx = 0;
		String word = "�ƹ��� ������ ���޾ƿ�";
		while(true){
			players[playerIdx].sayWord();
			if(!players[playerIdx].succeed(word.charAt(word.length()-1))){
				System.out.println(players[playerIdx].getName() + "�� �����ϴ�.");
				break;
			}
			word = players[playerIdx].getWord();
			playerIdx = (playerIdx+1)%numOfPlayer;
		}
	}
}
