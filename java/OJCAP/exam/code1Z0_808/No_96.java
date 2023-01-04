package exam.code1Z0_808;

public class No_96 {
	public static void main(String[] args) {
		double discount = 0;
		int qty = Integer.parseInt(args[0]);
		discount = (qty >= 90) ? 0.5 : (qty > 80) ? 0.2 : 0;
		
		System.out.println(discount);
	}
}
