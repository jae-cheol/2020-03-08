package Reflection;

/**
 * 위 예제를 보시면 String 타입으로 클래스를 탐색해서 선언하는 게 가능합니다.
 * 이것은 두가지 매력이 있습니다.
 * 첫번째는 String의 값은 컴파일 단계에서 체크를 하지 않습니다. 
 * 위 예제에서 toString을 재정의하는 것으로 캐스팅도 필요없이 toString으로 콘솔 출력을 했습니다.
 * 즉, Example2 클래스 내부에서는 Node 함수를 사용하는 것이 없으므로 컴파일할 때, Node 클래스를 만들지 않아도 생성이 가능합니다. 
 * 즉, 실행할 때만 Node클래스가 있으면 되지 동적 바인딩이 가능하다는 뜻입니다.
 * 
 * 위처럼 Example 클래스만 만들고 Node 클래스는 만들지 않았습니다. 컴파일은 문제없이 잘됩니다.
 * 실행을 하면 Node 클래스가 없다고 하네요.
 * 
 * Node 클래스를 만들고 Node 클래스만 컴파일하고 Example를 실행하겠습니다.
 * 
 * 동적 바인딩이 되는 것을 확인할 수 있습니다. 이 뜻은 기동 중인 프로그램에서 재실행이 필요없이 소스 교체가 가능하다는 것입니다.
 * 이론은 그렇습니다. 그러나 실무에서는 예기치 못하는 다른 에러가 발생할 수 있기 때문에 가령 Node 소스를 바꾸는데 프로그램에서 이미 Node를 메모리에 할당했다.
 * 그런데 소스가 바뀌어 있다.. 등등의 문제가 발생할 수 있습니다. 때문에 사용하지 않습니다.
 */
import java.lang.reflect.Constructor;

public class Example2 {
	// 실행 함수
	public static void main(String... args) {
		try {
			// Class.forName의 함수를 사용해서 문자열로 Class<?> 타입을 취득해 올 수 있다.
			Class<?> clz = Class.forName("Node");
			// String으로 취득한 클래스 타입으로 생성자를 취득합니다.
			Constructor<?> constructor = clz.getConstructor();
			// 생성자를 통해 newInstance 함수를 호출하여 Node 인스턴스를 생성한다.
			Object node = constructor.newInstance();
			// node 인스턴스의 toString 함수를 실행한다.
			node.toString();
		} catch (Throwable e) {
			e.printStackTrace();
		}
	}
}
