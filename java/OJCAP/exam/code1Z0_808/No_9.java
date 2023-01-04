package exam.code1Z0_808;

import java.util.ArrayList;

public class No_9 {

	public static void main(String[] args) {
		ArrayList<Integer> p = new ArrayList<>();
		
		// value...
		p.add(1);
		p.add(2);
		p.add(3);
		p.add(4);
		p.add(null);	// null도 삽입되서 사이즈로 취급됨.
		System.out.println("size : " + p.size());

		// index....
		p.remove(2);	// index 삭제.
		p.remove(null);	// * index삭제가 아닌 Object 삭제.
		System.out.println(p);
	}

}
