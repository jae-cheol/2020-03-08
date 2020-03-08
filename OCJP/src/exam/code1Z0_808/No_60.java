package exam.code1Z0_808;

class Rectangle {
	private double length;
	private double height;
	private double area;

	public void setLength(double length) {
		this.length = length;
	}
	public void setHeight(double height) {
		this.height = height;
	}
	public void setArea(double area) {
		area = length*height;
	}
}
public class No_60 {

	public static void main(String[] args) {
		Rectangle r = new Rectangle();
		r.setLength(3);
		r.setHeight(4);
		r.setArea(12);
	}
}
