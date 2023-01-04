package Reflection;

import java.lang.reflect.Constructor;

/**
 * 그런데 이런 Reflection을 이용하면 소스가 간단해 집니다.
 * 
 * 위 소스는 Class가 100개가 늘어나도 getClass는 수정이 없을 것입니다.
 * 
 * 이 Reflection은 이렇다고 만능은 아닙니다. 문제는 성능입니다.
 */
public class Example4 {
	// 클래스 취득 함수
	private static Object getClass(String name) {
		try {
			// Class.forName의 함수를 사용해서 문자열로 Class<?> 타입을 취득해 올 수 있다.
			Class<?> clz = Class.forName(name);
			// String으로 취득한 클래스 타입으로 생성자를 취득합니다.
			Constructor<?> constructor = clz.getConstructor();
			// 생성자를 통해 newInstance 함수를 호출하여 Node 인스턴스를 생성한다.
			return constructor.newInstance();
		} catch (Throwable e) {
			return null;
		}
	}

	// 실행 함수
	public static void main(String... args) {
		// 클래스를 받아온다.
		Object instance = getClass("Node1");
		// 콘솔 출력
		System.out.println(instance.toString());
	}
}
