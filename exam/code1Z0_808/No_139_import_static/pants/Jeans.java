package exam.code1Z0_808.No_139_import_static.pants;
import static exam.code1Z0_808.No_139_import_static.Shirt.getColor;

public class Jeans {
	public void matchShirt() {
		String color = getColor();
//		String color = Shirt.getColor();
		if(color.equals("Green")) {
			System.out.println("Fit");
		}
	}
	public static void main(String[] args) {
		Jeans trouser = new Jeans();
		trouser.matchShirt();
	}
}
