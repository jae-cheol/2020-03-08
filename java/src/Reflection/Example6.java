package Reflection;

import java.lang.reflect.Constructor;
import java.util.ArrayList;
import java.util.List;

/**
 * 그럼 저 탐색 부분을 빼보겠습니다.
 * 
 * 그래도 Reflection이 느리기는 합니다. 그러나 이 정도 차이면 어느 정도 감수할 만한 수치입니다.
 * 그러나 여기서 문제는 저 Class<?> clz와 Constructor<?> constructor 데이터입니다.
 * 성능의 차를 줄이기 위해서는 할당할 때마다 따른 변수에 보관해야 합니다.
 * 즉, 이래저래 성능에 영향을 미치는 건 마찬가지이네요.
 */
/**
 * 두번째는 에러가 컴파일에 걸리지 않습니다.
 * 우리가 Node 생성자의 파라미터가 String 타입인데 int형을 넣으면 바로 컴파일할 때 에러가 발생합니다.
 * 그런데 Reflection은 실행하지 않는 이상 에러를 잡아 낼 수가 없습니다.
 * 즉, 확실하게 검증되는 소스가 아니라면, 또 빈번하게 수정되는 소스라면 매우 불편한 기능입니다.
 * Reflection 기능은 보통 Unit 테스트 환경이나 Framework를 만들 때,
 * 의존성 주입을 설계할 때 많이 사용되는 기능입니다.
 */
public class Example6 {
	public static void main(String... args) {
		try {
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
			// Class.forName의 함수를 사용해서 문자열로 Class<?> 타입을 취득해 올 수 있다.
			Class<?> clz = Class.forName("Node");
			// String으로 취득한 클래스 타입으로 생성자를 취득합니다.
			Constructor<?> constructor = clz.getConstructor(String.class);
			// 시작
			startTime = System.currentTimeMillis();
			// 루프
			for (int i = 0; i < count; i++) {
				// 할당하면서 리스트에 삽입
				list.add(constructor.newInstance(Integer.toString(i)));
			}
			// 끝
			endTime = System.currentTimeMillis();
			// 시간 측정
			System.out.println(endTime - startTime);
		} catch (Throwable e) {
			e.printStackTrace();
		}
	}
}
