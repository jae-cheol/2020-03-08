package exam.code1Z0_808;

import java.util.ArrayList;
import java.util.List;

class Patient {
	String name;
	public Patient(String name) {
		this.name = name;
	}
}
public class No_138 {
	public static void main(String[] args) {
		List ps = new ArrayList<>();
		Patient p2 = new Patient("Mike");
		ps.add(p2);
		
		int f = ps.indexOf(p2);
		
//		Patient p = new Patient("Mike");
//		int f = ps.indexOf(p);
		System.out.println(f);
		
		if(f >= 0) {
			System.out.println("Mike Found");
		}
	}
}
