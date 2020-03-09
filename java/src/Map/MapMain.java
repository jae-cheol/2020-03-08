package Map;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Scanner;
import java.util.Set;

/*
 * Map(k, v) , set --> 순서(x), 중복(x)
 * 
 * 순서가 없다	: 인덱스로 위치를 찾을 수 없다. 마구잡이로 저장되어있다.
 * 중복이 없다	: 중복을 허용하지 않는다. 똑같은 키로 저장되면 덮어씌우고, put()으로 들어가면 Value에 해당하는 반환값이 나옴.
 * 
 * Map : Key, Value를 한쌍으로 데이터 저장.  순서(X), 중복(X)
 * 구현클래스 : HashMap, TreeMap
 * 
 * 주요메소드
 * - size()			: 요소 개수를 반환.
 * - put(K k,V v)	: 데이터 입력
 * - putAll(Map m)	: Map의 모든데이터를 입력
 * - get(K k)		: key에 해당하는 데이터 추출
 * - remove(K k)	: key에 해당하는 데이터 삭제
 * - containsKey(K)	: 해당 key가 존재여부 판단
 * - entrySet()		: Map의 모든 데이터를 Map.Entry객체집합으로 반환		
 */

public class MapMain {
	public static void main(String[] args) {
		/*
		 * Map<String, String> map = new HashMap<>();
		 * 같음 - 선언할때는 (사용자 정의)자료형이 필요하지만, 생성할때는 (사용자 정의)자료형 생략 가능.
		 * Map<String, String> map = new HashMap<String, String>();
		 */
		Map<String, String> map = new HashMap<>();
		
		map.put("aaa", "1111");
		map.put("bbb", "2222");
		map.put("ccc", "3333");
		map.put("ddd", "4444");

		// 아이디가 "aaa"인 회원의 패스워드를 "1234" 변경
		Scanner sc = new Scanner(System.in);
		System.out.println("패스워드 변경서비스입니다.");
		System.out.print("아이디를 입력하세요 : ");
		String id = sc.nextLine();
		
		if(!map.containsKey(id)) { // 키에 해당하는 값을 포함하고 있는지?
			System.out.println("입력하신 ID[" + id + "]는 존재하지 않습니다.");
			System.out.println("서비스를 종료합니다.");
			System.exit(0);
//			return;
		} 
		
		System.out.print("현재 패스워드를 입력하세요 : ");
		String password = sc.nextLine();
		
		if(!map.get(id).equals(password)) { // Key에 해당하는 Value와 같은지?
			System.out.println("입력하신 패스워드는 올바르지 않습니다.");
			System.out.println("서비스를 종료합니다.");
			return;
		}
		
		System.out.print("변경할 패스워드를 입력하세요 : ");
		String newPassword = sc.nextLine();
		
		map.put(id, newPassword); // 해당 Key에 대한 Value를 새로운 값으로해서 다시 집어넣음(중복된 Key일 경우 새로운 값으로 Value가 대체됨.)
		
		System.out.println("패스워드를 수정하였습니다.");
		
		System.out.println("< 전체 회원정보 출력 >");
		
		Set<Entry<String, String>> set = map.entrySet(); // map에 들어있는값이 set형태로 넘어옴.
		
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