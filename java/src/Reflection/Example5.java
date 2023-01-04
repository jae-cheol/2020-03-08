package Reflection;

import java.lang.reflect.Constructor;
import java.util.ArrayList;
import java.util.List;

/**
 * 이 Reflection은 이렇다고 만능은 아닙니다. 문제는 성능입니다.
 * 
 * 예제로 변수가 하나있는 class를 100만개 할당해 봤습니다. 차이가 5배 차이가 나네요.
 * 아마 변수가 많고 생성할 인스턴스가 많아지면 더더욱 느려질 것입니다.
 * 여기서 이렇게 큰 차이가 나는 것은 아마 저 Class.forName과 getConstructor 때문입니다.
 * 왜냐하면 탐색을 하는 시간이 들기 때문입니다.
 */
public class Example5 {
	// 클래스 취득 함수
	private static Object getClass(String name, String param) {
		try {
			// Class.forName의 함수를 사용해서 문자열로 Class<?> 타입을 취득해 올 수 있다.
			Class<?> clz = Class.forName(name);
			// String으로 취득한 클래스 타입으로 생성자를 취득합니다.
			Constructor<?> constructor = clz.getConstructor(String.class);
			// 생성자를 통해 newInstance 함수를 호출하여 Node 인스턴스를 생성한다.
			return constructor.newInstance(param);
		} catch (Throwable e) {
			return null;
		}
	}

	// 실행 함수
	public static void main(String... args) {
		// 예제로 100만개 인스턴스 만들어 보자
		int count = 1000000;
		// 인스턴스를 저장할 리스트
		List<Object> list = new ArrayList<>(count);
		// 시작
		long startTime = System.currentTimeMillis();
		// 루프
		for (int i = 0; i < count; i++) {
			// 할당하면서 리스트에 삽입
			list.add(new Node(Integer.toString(i)));
		}
		// 끝
		long endTime = System.currentTimeMillis();
		// 시간 측정
		System.out.println(endTime - startTime);
		// 리스트 비우고
		list.clear();
		// 시작
		startTime = System.currentTimeMillis();
		// 루프
		for (int i = 0; i < count; i++) {
			// 할당하면서 리스트에 삽입
			list.add(getClass("Node", Integer.toString(i)));
		}
		// 끝
		endTime = System.currentTimeMillis();
		// 시간 측정
		System.out.println(endTime - startTime);
	}
}
