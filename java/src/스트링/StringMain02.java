package ��Ʈ��;

import java.util.Arrays;
/*
 * substring(~)		: ~�κк��� ¥����.
 * substring(~,~)	: ~���� ~���� ¥����.
 * concat()			: ����
 * replace(~,~)		: ~�� ~�� ����
 * trim()			: �� �� ������ ����.
 * toUpperCase()	: �빮�ڷ� ����
 * toLowerCase()	: �ҹ��ڷ� ����
 * split()			: �ش� ���ڸ� �������� �ڸ�.
 */
public class StringMain02 {

	public static void main(String[] args) {
		
		String str = "Hello world";
		
//		String sub = str.substring(3, 7);
		// ����ǥ��
//		sub = str.substring(3, str.length());
		String sub = str.substring(2);
		System.out.println("substring() : " + sub);

//		str = str + "!!!";
		str = str.concat("!!!");
		System.out.println("concat() : " + str);


		String result = str.replace('o', 'p');
		System.out.println("replace() : " + result);
		result = str.replace("ll", "rrRRRRR");
		System.out.println("replace() : " + result);
		
//		str = "       hello       ";
		str = "       Hello World         ";
		System.out.println(str);
		System.out.println("trim�� str�� ���� : " + str.length());
		
		str = str.trim();
		System.out.println("trim()�� str : [" + str + "], ���� : " + str.length());
		
		System.out.println("str : " + str);
		System.out.println("toUpperCase() : " + str.toUpperCase());
		System.out.println("toLowerCase() : " + str.toLowerCase());
		System.out.println("str : " + str);
		
		str = "ȫ�浿��:���:�����ô�";
		String[] strArr = str.split(":");
		System.out.println("split() : " + Arrays.toString(strArr));

//		int idx = str.indexOf(':');
//		String title = str.substring(0, idx);
//		
//		int idx2 = str.indexOf(":", idx+1);
//		String author = str.substring(idx+1, idx2);
//		
//		String date = str.substring(idx2+1);
//		System.out.println(title + ", " + author + ", " + date);
		
		int num = 123;
		System.out.println(String.valueOf(num) + 100);
		
		char[] chars = {'A', 'B', 'C', 'D'};
		System.out.println(String.valueOf(chars));
	}
}