package ��Ʈ��;
import java.util.Scanner;
/*
 * 18.05.27
 * �Է°� ��... ����
3
config.sys
configures
config.inf

3
config.sys
configures
config.ins

2
aa
ba

3
aaa
aba
aca

1
a

3
aaa
bab
bbb

2
aaaaa
ababa
 */
public class Sb_1032 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int num = sc.nextInt();		// �Է��� ���� ����.
		String[] aString = new String[num];
		for(int i=0; i<num; i++) {
			aString[i] = sc.next();	// �Է��� ���ڵ�.
		}
		
		int nlength = aString[0].length();	// �Է��� ���� ����.
		
		StringBuilder s = new StringBuilder(aString[0]);// �Է±��̿� �´� �ӽù��ڿ�. 
		
		String[][] aStr = new String[num][nlength];	// �Է� �޴� String ������ ��.
		
		for(int i=0; i<num; i++) {
			for(int j=0; j<nlength; j++) {
				aStr[i][j] = String.valueOf(aString[i].charAt(j));
			}
		}
		
		for(int i=1; i<num; i++) {
			for(int j=0; j<nlength; j++) {
//				System.out.println("i : " + i);
//				System.out.println("j : " + j);
//				System.out.println("aStr[0][j] : " + aStr[0][j]);
//				System.out.println("aStr[i][j] : " + aStr[i][j]);
				if( !aStr[0][j].equals(aStr[i][j]) ) {	// ������ ù��° �Է��� ���ڿ�.
					s.replace(j, j+1, "?");
//					System.out.println(s);
				}
			}
		}
		System.out.println(s);
	}
}