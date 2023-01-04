package exam.code1Z0_808;
/*
 * protected : 타패키지의 서브클래스까지 사용가능.
 */
interface Exportable {
	// 동일 : 인터페이스의 특징 - 모든 메소드는 public이다.
//	public abstract void export();
	void export();
}

class Tool implements Exportable {
	// 접근제어자가 축소될수 없음.(위 인터페이스에는 public이 생략되어있음.)
//	protected void export() {
//		System.out.println("Tool::export");
//	}
	public void export() {
		System.out.println("Tool::export");
	}
}

public class No_3 extends Tool implements Exportable {

	public void export() {
		System.out.println("RTool::export");
	}
	
	public static void main(String[] args) {
		// 업캐스팅 : 서브클래스 객체가 슈퍼클래스 타입으로 변환되는 것.
		Tool aTool = new No_3();
		Tool bTool = new Tool();
		callExport(aTool);
		callExport(bTool);
	}

	public static void callExport(Exportable ex) {
		ex.export();
	}
}
