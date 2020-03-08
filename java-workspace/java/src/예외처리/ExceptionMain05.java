package 예외처리;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Random;

public class ExceptionMain05 {
	public static void main(String[] args) {
		System.out.println("main start...");
		try {
			Random r = null;
			System.out.println(r.nextInt(100) + 1);
			String str = "abc";
			System.out.println(str.charAt(3));
			FileReader fr = new FileReader("a.txt");
		} catch(Exception e) {
			e.printStackTrace();
		}
			
//		} catch(FileNotFoundException 
//				| StringIndexOutOfBoundsException 
//				| NullPointerException e) {
//			e.printStackTrace();
//		}
//		} catch (FileNotFoundException fnfe) {
//			fnfe.printStackTrace();
//		} catch(StringIndexOutOfBoundsException se) {
//			se.printStackTrace();
//		} catch(NullPointerException ne) {
//			ne.printStackTrace();
//		}
		System.out.println("main end...");
	}
}
