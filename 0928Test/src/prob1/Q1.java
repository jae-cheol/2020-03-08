package prob1;

public class Q1 {
	public static void main(String[] args) {
		for(int i=1; i<=99; i++) {
			if(i%3 == 0) {
				System.out.println(i + " ¦");
			}
		}
	}
}

/*
 * String ���� �Լ����� ���� �˾ƾ� ��.
 * 
 * ���� ���ڿ��� �ٷ�� ����
 * String number = String.valueOf(369);
 * 
 * ���ڿ��� ���̸� ���ϱ� ����
 * int length = number.length();
 * 
 * ī��Ʈ�� ���� ����
 * char o = number.charAt(i);
 * 
 */