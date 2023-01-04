package Reflection;

/**
 * 위 소스를 보시면 제가 getClass 함수에서 Node1의 값을 넣어서 Node1클래스를 받아옵니다. 실제 이런식으로 작성 많이 합니다.
 * 그런데 여기에 들어가는 클래스가 사양에 따라 증가한다면 getClass의 if문은 점점 늘어날 것입니다.
 * 한 100개 정도로 생성되면 if else만 100개 만들어야 겠네요.
 */
public class Example3 {
	// 클래스 취득 함수
	private static Object getClass(String name) {
		// 파라미터 값이 Node1일 경우 Node1클래스를 반환
		if ("Node1".equals(name)) {
			return new Node2();
			// 파라미터 값이 Node2일 경우 Node2클래스를 반환
		} else if ("Node2".equals(name)) {
			return new Node2();
			// 파라미터 값이 Node3일 경우 Node3클래스를 반환
		} else if ("Node3".equals(name)) {
			return new Node3();
		}
		return null;
	}

	// 실행 함수
	public static void main(String... args) {
		// 클래스를 받아온다.
		Object instance = getClass("Node1");
		// 콘솔 출력
		System.out.println(instance.toString());
	}
}
