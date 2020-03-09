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
		if (this == obj){ // ���� �������� ��ü�� �Ѿ���� ��ü�� ����Ű�� �ּҰ��� ������ true.
			return true;}
		if (obj == null){ // �Ѿ���� �ּҰ��� null�̸� �������� �Ұž���.
			return false;}
		if (getClass() != obj.getClass()){ // ��������Ŭ���� != obj�� �������� Ŭ����
			return false;}
		
		Member other = (Member) obj;
		if (name == null) { // ���� �������� Member.name
			if (other.name != null){ // ���� Member.name
				return false;}
		} else if (!name.equals(other.name)){ // String ������ ���Ҷ��� equals()
			return false;}
		if (phone == null) {
			if (other.phone != null){return false;}
		} else if (!phone.equals(other.phone)){return false;}
		
		return true; // ������ �Ȱɸ��� �Ѿ������ true
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
		
		member.put(new Member("ȫ�浿", "010-1111-2222"), new Car("�ҳ�Ÿ", "32�� 1234")); // 4��°�� �����鼭 �̰� �������.
		member.put(new Member("��浿", "010-2222-3333"), new Car("���", "25�� 5278"));
		member.put(new Member("ȫ�浿", "010-4444-5555"), new Car("����", "23�� 3567"));
		member.put(new Member("ȫ�浿", "010-1111-2222"), new Car("����", "45�� 5234")); // ��ȯ���� ���� ������ �� ��ü�� �������.
		
		System.out.println("��ϴ�� : " + member.size());
		
		String str = new String("hello");
		String str2 = new String("hello");
		
		// hashCode() - �� ��ü�� ���� ��ü����?(���ϼ�)
		System.out.println(str.hashCode());
		System.out.println(str2.hashCode());
		System.out.println((new Member("ȫ�浿", "010-1111-3333")).hashCode());
		System.out.println((new Member("ȫ�浿", "010-1111-2222")).hashCode());
		
//		Set<Member> members = new HashSet<>();
//		Member m = new Member("ȫ�浿", "010-1111-333");
//		Member m2 = new Member("ȫ�浿", "010-1111-2222");
//		
//		if(m.equals(m2)) {
//			System.out.println("m == m2");
//		} else {
//			System.out.println("m != m2");
//		}
//		
//		System.out.println(members.add(new Member("ȫ�浿", "010-1111-3333")));
//		System.out.println(members.add(new Member("ȫ�浿", "010-1111-2222")));
	}
}