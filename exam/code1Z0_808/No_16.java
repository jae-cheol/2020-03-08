package exam.code1Z0_808;
/*
 * 업캐스팅은 형변환 필요없지만
 * 다운캐스팅은 형변환해야함.
 */
public class No_16 {

	public static void main(String[] args) {
		//Byte x = 1;
		//short x = 1;
		//String x = "1";	// x
		//Long x = 1;	// x
		//Double x = 1;	// x
		Integer x = new Integer("1");
		switch(x) {
			case 1:
				System.out.println("One");
				break;
			case 2:
				System.out.println("Two");
				break;
		}
	}

}
