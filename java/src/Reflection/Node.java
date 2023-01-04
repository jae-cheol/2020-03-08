package Reflection;

public class Node {
	private String data;

	// 생성자
	public Node() {
	}
	public Node(String data) {
		this.data = data;
	}

	// Example1
	// 함수 생성
	public void print() {
		// 콘솔 출력
		System.out.println("[print] Hello world");
	}

	// Example2
	// 함수를 재정의 했다.
	@Override
	public String toString() {
		// 콘솔 출력
		System.out.println("[toString] Hello world");
		return null;
	}
}
