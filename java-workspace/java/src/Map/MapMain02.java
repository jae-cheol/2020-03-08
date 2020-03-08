package Map;

import java.util.HashMap;
import java.util.Map;

class Member {
	private String name;
	private String phone;
	public Member(String name, String phone) {this.name = name;   this.phone = phone;}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + ((phone == null) ? 0 : phone.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj){ // 현재 실행중인 객체와 넘어오는 객체가 가르키는 주소값이 같으면 true.
			return true;}
		if (obj == null){ // 넘어오는 주소값이 null이면 비교조차도 할거없음.
			return false;}
		if (getClass() != obj.getClass()){ // 실행중인클래스 != obj의 실행중인 클래스
			return false;}
		
		Member other = (Member) obj;
		if (name == null) { // 현재 실행중인 Member.name
			if (other.name != null){ // 들어온 Member.name
				return false;}
		} else if (!name.equals(other.name)){ // String 같은지 비교할때는 equals()
			return false;}
		if (phone == null) {
			if (other.phone != null){return false;}
		} else if (!phone.equals(other.phone)){return false;}
		
		return true; // 위에서 안걸리고 넘어왔으면 true
	}

//	@Override
//	public boolean equals(Object obj) {
//		if(this.name.equals(((Member)obj).name) 
//				&& this.phone.equals(((Member)obj).phone))
//			return true;
//		return false;
//	}
	
}

class Car {
	private String modelName;
	private String number;
	public Car(String modelName, String number) {this.modelName = modelName;   this.number = number;}
}

public class MapMain02 {
	public static void main(String[] args) {
		Map<Member, Car> member = new HashMap<>();
		
		member.put(new Member("홍길동", "010-1111-2222"), new Car("소나타", "32소 1234")); // 4번째께 들어오면서 이게 덮어씌워짐.
		member.put(new Member("고길동", "010-2222-3333"), new Car("모닝", "25거 5278"));
		member.put(new Member("홍길동", "010-4444-5555"), new Car("에쿠스", "23나 3567"));
		member.put(new Member("홍길동", "010-1111-2222"), new Car("벤츠", "45도 5234")); // 반환값을 받지 않으니 그 자체로 덮어씌워짐.
		
		System.out.println("등록대수 : " + member.size());
		
		String str = new String("hello");
		String str2 = new String("hello");
		
		// hashCode() - 두 객체가 같은 객체인지?(동일성)
		System.out.println(str.hashCode());
		System.out.println(str2.hashCode());
		System.out.println((new Member("홍길동", "010-1111-3333")).hashCode());
		System.out.println((new Member("홍길동", "010-1111-2222")).hashCode());
		
//		Set<Member> members = new HashSet<>();
//		Member m = new Member("홍길동", "010-1111-333");
//		Member m2 = new Member("홍길동", "010-1111-2222");
//		
//		if(m.equals(m2)) {
//			System.out.println("m == m2");
//		} else {
//			System.out.println("m != m2");
//		}
//		
//		System.out.println(members.add(new Member("홍길동", "010-1111-3333")));
//		System.out.println(members.add(new Member("홍길동", "010-1111-2222")));
	}
}