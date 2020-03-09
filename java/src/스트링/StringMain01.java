package ��Ʈ��;

import java.util.Arrays;
/*
 * int = char + char
 * substring()					: ã�°��� ��ġ���� ¥��.
 * str1.equals(str2)			: str1, str2�� ��ҹ��ڱ��� ���� �� �� �Ȱ����� ��.
 *     .equalsIgnoreCase(str2)	: 			  ��ҹ��ڸ� �����ϰ� ��.
 * str3.lastIndexOf('u')		: str3���� �ڿ������� 'u'�� ã�Ƽ� ã�°��� ��ġ�� int������ ������.(ù�ڸ� 0���� ����), ã�°��� ������ -1 ����.
 *     .indexOf()				:
 *     .indexOf('l', 4)			:        �տ������� 'l'�� ã�µ� 4��°��ġ���� ã��.
 */
public class StringMain01 {
	public static void main(String[] args) {
		
		// char���� �����ϸ� �ڵ����� int�� ��. 
		char ch = 'd';
		System.out.print(ch + " ");
		char ch2 = 'a';
		System.out.print(ch2 + " ");
		char d1 = (char)(ch+ch2);	// char�� ������ ���.
		System.out.print(d1 + " ");
		int d2 = ch+ch2;	// char�� ������ int���� ��.
		System.out.println(d2);

		// �� �Ȱ��� ���
		String str = new String("ABCDE");
		str = new String(new char[] {'A', 'B', 'C', 'D', 'E'});
		str = new String(new byte[] {65, 66, 67, 68, 69});

		char[] temp = {'a','b', 'c', 'A', 'B', 'C', 'D', 'E', 'F'};
		str = new String(temp, 2, 5); // temp���� 0,1,2��°���� ~ 5�� , cABCD

		char[] chars = new char[str.length()]; // str�� ���̸�ŭ(5��¥��) char�迭 ����.
		// ���ڿ��� char�迭�� ����
		str.getChars(1, 4, chars, 2); // str�� 0,1��°���� ~ 4��°������(ABCD) chars�� 0,1,2��°���ٰ� �ִ´�. �ڿ��� ©����.
		System.out.println("chars : " + Arrays.toString(chars));
		
		///////////////////////////////////////////////////////////////////
		
		String str1 = new String("Hello");
		String str2 = new String("hello");
		if(str1 == str2) { System.out.println("�ּҺ� : ����"); }
		else { System.out.println("�ּҺ� : �ٸ���(����� ���� �ٸ��� ������ �ּҵ� �ٸ�.)"); }
		if(str1.equalsIgnoreCase(str2)) { System.out.println("���ڿ��� : ����"); }
		else { System.out.println("���ڿ��� : �ٸ���"); }
		
		///////////////////////////////////////////////////////////////////
		
		String str3 = "hello world";
		int searchIdx = str3.lastIndexOf('u');
		System.out.println("searchIdx(ã�°��� ������ -1) : " + searchIdx);
		searchIdx = str3.indexOf('l', 4);
		System.out.println("4�������� searchIdx : " + searchIdx + "\n");
		
		// ���ڿ� �ȿ��� �ϳ��� ���� ��ġ�� ���� Ž��.
		System.out.println("< " + str3 + "���� l�� ��ġ Ž�� >");
//		int idx = str3.indexOf("l");
//		while(idx != -1) {
//			System.out.println(idx);
//			idx = str3.indexOf("l", idx+1);
//		}
		int idx = -1;
		while((idx = str3.indexOf("l", idx+1)) != -1)  
			System.out.print(idx + " // ");
	}
}