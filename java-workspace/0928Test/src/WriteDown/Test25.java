package WriteDown;

class Shape {
	int x, y;
	Shape(int x, int y) {
		this.x = x;
		this.y = y;
	}
	void info() {
		System.out.println("x : " + x + "y : " + y);
	}
}

class Rectangle extends Shape {
//	Rectangle() {}
	Rectangle(int x, int y) {
		super(x, y);
	}
	void getArea() {
//		Return x*y;
	}
}
public class Test25 {
	public void info(Shape s) {
		s.info();
//		s.getArea();
	}
	public static void main(String[] args) {
		Rectangle rec = new Rectangle(3, 7);
	}
}
