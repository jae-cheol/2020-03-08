package Ŭ�����Ͱ�ü;

public class Player {
	private String name;
	
	public Player() { }
	public Player(String name) { this.name = name; }

	public String getName() { return name; }
	public void setName(String name) { this.name = name; }

	public char sayWord(String word) {
		int lastIndex = word.length() - 1; // ������ ���ڿ� ���� �ε���
		char lastChar = word.charAt(lastIndex); // ������ ����
		
		return lastChar;
	}
	
	public boolean succeed(String name){
		
		return true;
	}
}
