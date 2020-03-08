package ��Ʈ��;
/*
 * equalsIgnoreCase()	: ��ҹ��� ������� ������ ��.
 * startsWith(~) 		: ~�� �����ϴ°� ã����.
 * endsWith(~)			: ~�� �����°� ã����.
 * indexOf(~)			: �ش� ���ڰ� ����ִ� ��ġ�� �˷� �ݴϴ�.(���ڰ� ������ -1 ��ȯ)
 * 	��) "abcde".indexOf("e")���� 4�� �о� ���ϴ�. 0���� �����ϱ� �����Դϴ�.
 * contains(~)			: ~�� ���ԵȰ� ã����.
 */
public class ���ϰ˻� {

	public static void main(String[] args) {

		String[] strArr = {"hello.txt", "hello2.txt", "hellotxt3.jpg", "good-bye.png"};
		
		// "hello.txt"�� ���翩�� �Ǵ�
		for(String s : strArr) {
			if(s.equalsIgnoreCase("hello.txt")) {
				System.out.println("�迭�� �ش��ϴ� String�� �����մϴ�.");
			}
		}
		System.out.println();

		System.out.println("< he�� ���۵Ǵ� ���� �˻� >");
		for(String s : strArr) {
			if(s.startsWith("he")) {
				System.out.print(s + " ");
			}
		}
		System.out.println("\n");
		
		System.out.println("< Ȯ���ڰ� txt�� ���� �˻� >");
		for(String s : strArr) {
			if(s.endsWith("txt")) {
				System.out.print(s + " // ");
			}
		}
		System.out.println("\n");
		
		System.out.println("< txt�� ���Ե� ���� �˻� >");
		for(String s : strArr) {
			System.out.println(s.indexOf("txt"));
			if(s.indexOf("txt") != -1) {
//			if(s.contains("txt")) {
				System.out.print(s + " // ");
			}
		}
	}
}