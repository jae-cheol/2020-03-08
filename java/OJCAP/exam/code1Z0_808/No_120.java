package exam.code1Z0_808;
/*
 * 상속하면서 가시성이 감소할 순 없다.
 */
abstract class Planet {
	protected void revolve() {}
	abstract void rotate();
}

public class No_120 extends Planet{
//	void revolve() {}
	protected void rotate() {}
	public static void main(String[] args) {
	}
}
