package exam.code1Z0_808;
/*
 * 클래스의 필드변수(멤버변수)명과 메소드 내부 변수명이 같아도 상관없다.
 */
public class No_123 {
	int x, y;
	
	public No_123(int x, int y) {
		//System.out.println("#$535");
		init(x,y);
	}
	public void init(int x, int y) {
		//System.out.println("#$535");
		this.x = x*x;
		this.y = y*y;
		//System.out.println(this.x + " " + this.y);
	}
	public static void main(String[] args) {
		int x=3, y=5;
		No_123 obj = new No_123(x,y);
		System.out.println(x + " " + y);
	}
}
