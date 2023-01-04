package exam.code1Z0_808;
/*
 * 지역변수, 전역변수 같은 변수명으로 선언가능.
 */
public class No_24 {

	String myStr = "7007";
	
	public void doStuff(String str) {
		int myNum = 0;
		
		try {
			String myStr = str;
			myNum = Integer.parseInt(myStr);
		} catch(NumberFormatException ne) {
			System.out.println("Error");
		}
		System.out.println("myStr: " + myStr + ", myNum: " + myNum);
	}
	public static void main(String[] args) {
		No_24 obj = new No_24();
		obj.doStuff("9009");
	}

}
