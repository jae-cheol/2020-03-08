package HW11;

import java.util.List;

/*
 * {name: "홍길동", id : "hong", phone: "010-1111-2222"}
 * 
 * // 실행결과
이름 : 홍길동
id : hong
전화번호 : 010-1111-2222
 */

public class HW11 {

	public static void main(String[] args) {
		 Member m = Member.jsonParse("json.txt");
		 System.out.println("이름 : " + m.getName());
		 System.out.println("ID : " + m.getId());
		 System.out.println("Phone : " + m.getPhone());
//		jsonParse(); // v1.7 이후 try() 구문 -- finally 없어진 구문.
		// writeObject();
		 List<Member> list = (List<Member>) Member.jsonParseArray("json2.txt");
	     for(Member m1 : list) {
	    	 System.out.println("이름 : " + m1.getName());
			 System.out.println("ID : " + m1.getId());
			 System.out.println("Phone : " + m1.getPhone());
	     }
	}
}
