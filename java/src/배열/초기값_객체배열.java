package �迭;

import java.util.Arrays;

class Hotdog {
	String name;
	int price;
}

public class �ʱⰪ_��ü�迭 {
	public static void main(String[] args) {
		String str = null;
		String str2 = null;
		System.out.println("str  : " + str);
		System.out.println("str2 : " + str2);
		str = new String();
		str2 = new String();
		System.out.println("str  : " + str);
		System.out.println("str2 : " + str2 + "\n");
		
		String[] strArr = new String[2];
		System.out.println("strArr : " + Arrays.toString(strArr));
		for(int i = 0; i < strArr.length; i++) {
			strArr[i] = new String();
		}
		System.out.println("strArr : " + Arrays.toString(strArr) + "\n");
		
		
		Hotdog[] hotArr = new Hotdog[3]; // ��ü �迭�� �����ϸ� �ʱ�� null��.
		System.out.println("hotArr : " + Arrays.toString(hotArr));
		
		for(int i = 0; i < hotArr.length; i++) {
			hotArr[i] = new Hotdog(); // ��ü�� �ּҸ� ����Ŵ.
		}
		
		System.out.println("hotArr : " + Arrays.toString(hotArr));
		//  return getClass().getName() + "@" + Integer.toHexString(hashCode());
	}
}