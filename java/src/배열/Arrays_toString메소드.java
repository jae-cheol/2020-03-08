package �迭;

import java.util.Arrays;

public class Arrays_toString�޼ҵ� {
	public static void main(String[] args) {

		// String[] strArr = {"�ڹ�", "��&�����", "����"};
		String[] strArr = new String[] { "�ڹ�", "��&�����", "����" };

		System.out.println("< Arrays.toString() �޼ҵ带 �̿��� ��� >");
		System.out.println(Arrays.toString(strArr)); // ������ �ִ°�.
		System.out.println(arraysToString(strArr)); // ���� ����.
	}

	static String arraysToString(String[] strArr) { // ���ڷ� �Ѿ�� �迭
		String str = "[";
		for (int i = 0; i < strArr.length; i++) {
			str += strArr[i];
			if (i != strArr.length - 1)
				str += ", ";
		}
		str += "]";

		return str; // String Ÿ�� �Լ��̹Ƿ� ���ϵ� String���¸� �Ѱ���.
	}
}
