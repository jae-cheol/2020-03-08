package 클래스와객체;

public class Player {
	private String name;
	
	public Player() { }
	public Player(String name) { this.name = name; }

	public String getName() { return name; }
	public void setName(String name) { this.name = name; }

	public char sayWord(String word) {
		int lastIndex = word.length() - 1; // 마지막 문자에 대한 인덱스
		char lastChar = word.charAt(lastIndex); // 마지막 문자
		
		return lastChar;
	}
	
	public boolean succeed(String name){
		
		return true;
	}
}
