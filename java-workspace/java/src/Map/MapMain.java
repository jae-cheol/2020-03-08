package Map;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Scanner;
import java.util.Set;

/*
 * Map(k, v) , set --> ����(x), �ߺ�(x)
 * 
 * ������ ����	: �ε����� ��ġ�� ã�� �� ����. �������̷� ����Ǿ��ִ�.
 * �ߺ��� ����	: �ߺ��� ������� �ʴ´�. �Ȱ��� Ű�� ����Ǹ� ������, put()���� ���� Value�� �ش��ϴ� ��ȯ���� ����.
 * 
 * Map : Key, Value�� �ѽ����� ������ ����.  ����(X), �ߺ�(X)
 * ����Ŭ���� : HashMap, TreeMap
 * 
 * �ֿ�޼ҵ�
 * - size()			: ��� ������ ��ȯ.
 * - put(K k,V v)	: ������ �Է�
 * - putAll(Map m)	: Map�� ��絥���͸� �Է�
 * - get(K k)		: key�� �ش��ϴ� ������ ����
 * - remove(K k)	: key�� �ش��ϴ� ������ ����
 * - containsKey(K)	: �ش� key�� ���翩�� �Ǵ�
 * - entrySet()		: Map�� ��� �����͸� Map.Entry��ü�������� ��ȯ		
 */

public class MapMain {
	public static void main(String[] args) {
		/*
		 * Map<String, String> map = new HashMap<>();
		 * ���� - �����Ҷ��� (����� ����)�ڷ����� �ʿ�������, �����Ҷ��� (����� ����)�ڷ��� ���� ����.
		 * Map<String, String> map = new HashMap<String, String>();
		 */
		Map<String, String> map = new HashMap<>();
		
		map.put("aaa", "1111");
		map.put("bbb", "2222");
		map.put("ccc", "3333");
		map.put("ddd", "4444");

		// ���̵� "aaa"�� ȸ���� �н����带 "1234" ����
		Scanner sc = new Scanner(System.in);
		System.out.println("�н����� ���漭���Դϴ�.");
		System.out.print("���̵� �Է��ϼ��� : ");
		String id = sc.nextLine();
		
		if(!map.containsKey(id)) { // Ű�� �ش��ϴ� ���� �����ϰ� �ִ���?
			System.out.println("�Է��Ͻ� ID[" + id + "]�� �������� �ʽ��ϴ�.");
			System.out.println("���񽺸� �����մϴ�.");
			System.exit(0);
//			return;
		} 
		
		System.out.print("���� �н����带 �Է��ϼ��� : ");
		String password = sc.nextLine();
		
		if(!map.get(id).equals(password)) { // Key�� �ش��ϴ� Value�� ������?
			System.out.println("�Է��Ͻ� �н������ �ùٸ��� �ʽ��ϴ�.");
			System.out.println("���񽺸� �����մϴ�.");
			return;
		}
		
		System.out.print("������ �н����带 �Է��ϼ��� : ");
		String newPassword = sc.nextLine();
		
		map.put(id, newPassword); // �ش� Key�� ���� Value�� ���ο� �������ؼ� �ٽ� �������(�ߺ��� Key�� ��� ���ο� ������ Value�� ��ü��.)
		
		System.out.println("�н����带 �����Ͽ����ϴ�.");
		
		System.out.println("< ��ü ȸ������ ��� >");
		
		Set<Entry<String, String>> set = map.entrySet(); // map�� ����ִ°��� set���·� �Ѿ��.
		
		for(Entry<String, String> entry : set) {
			System.out.println("key : " + entry.getKey() + ", value : " + entry.getValue());
		}
		
//		Iterator<Entry<String, String>> ite = set.iterator();
//		while(ite.hasNext()) {
//			Entry<String, String> entry = ite.next();
//			System.out.println("key : " + entry.getKey() + ", value : " + entry.getValue());
//		}
		
//		Set<String> keys = map.keySet();
//		for(String key : keys) {
//			String value = map.get(key);
//			System.out.println("key : " + key + ", value : " + value);
//		}
		
		
		List<LoginVO> list = new ArrayList<>();
		list.add(new LoginVO("aaa", "1111"));
		list.add(new LoginVO("bbb", "2222"));
		list.add(new LoginVO("ccc", "3333"));
		list.add(new LoginVO("ddd", "4444"));
	}
}

class LoginVO {
	private String id;
	private String password;
	
	public LoginVO(String id, String password) {
		this.id = id;
		this.password = password;
	}
}