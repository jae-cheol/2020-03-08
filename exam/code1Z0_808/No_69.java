package exam.code1Z0_808;

import java.util.ArrayList;
import java.util.List;

public class No_69 {
	public static void main(String[] args) {
		List<String> n = new ArrayList<>();
		n.add("Robb");
		n.add("Bran");
		n.add("Rick");
		n.add("Bran");
		
		if(n.remove("Bran")) {
			n.remove("Jon");
		}
		System.out.println(n);
	}
}
