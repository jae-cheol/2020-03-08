package �迭;

import java.util.Arrays;

public class �⺻�迭 {
	public static void main(String[] args) {
		//		String[] strArr = {"�ڹ�", "��&�����", "����"};
		String[] strArr = new String[] {"�ڹ�", "��&�����", "����"};
		
		System.out.println("< index�� �̿��� �迭 ��� >");
		for(int i = 0; i < strArr.length; i++) {
			System.out.print(strArr[i] + " ");
		}
		
		System.out.println("\n\n< 1.5������ for���� �̿��� ��� >");
		for(String str : strArr) {
			System.out.print(str + " ");
		}
		
		System.out.println("\n\n< Arrays.toString() �޼ҵ带 �̿��� ��� >");
		System.out.println(Arrays.toString(strArr)); // ������ �ִ°�.
	}
}