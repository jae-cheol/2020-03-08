package Reflection;
/**
 * 결과를 보시면 node.print를 호출해서 콘솔에 Hello world의 결과가 출력되었습니다.
 * 위 예제에서 어디에도 new Node라는 것은 없습니다만, Reflection의 기능을 통해서 Node의 인스턴스를 생성한 것입니다.
 */
import java.lang.reflect.Constructor;

public class Example1 {
	// 실행 함수
	public static void main(String... args) {
		try {
			// Node 클래스의 타입을 선언한다.
			Class<?> cls = Node.class;
			// Node 클래스의 생성자를 취득한다.
			Constructor<?> constructor = cls.getConstructor();
			// 생성자를 통해 newInstance 함수를 호출하여 Node 인스턴스를 생성한다.
			Node node = (Node) constructor.newInstance();
			// node 인스턴스의 print 함수를 실행한다.
			node.print();
		} catch (Throwable e) {
			e.printStackTrace();
		}
	}
}
