package HW11;

import java.util.List;

/*
 * {name: "ȫ�浿", id : "hong", phone: "010-1111-2222"}
 * 
 * // ������
�̸� : ȫ�浿
id : hong
��ȭ��ȣ : 010-1111-2222
 */

public class HW11 {

	public static void main(String[] args) {
		 Member m = Member.jsonParse("json.txt");
		 System.out.println("�̸� : " + m.getName());
		 System.out.println("ID : " + m.getId());
		 System.out.println("Phone : " + m.getPhone());
//		jsonParse(); // v1.7 ���� try() ���� -- finally ������ ����.
		// writeObject();
		 List<Member> list = (List<Member>) Member.jsonParseArray("json2.txt");
	     for(Member m1 : list) {
	    	 System.out.println("�̸� : " + m1.getName());
			 System.out.println("ID : " + m1.getId());
			 System.out.println("Phone : " + m1.getPhone());
	     }
	}
}
