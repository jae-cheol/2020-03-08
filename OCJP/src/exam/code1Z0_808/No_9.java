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
		p.add(null);	// null�� ���ԵǼ� ������� ��޵�.
		System.out.println("size : " + p.size());

		// index....
		p.remove(2);	// index ����.
		p.remove(null);	// * index������ �ƴ� Object ����.
		System.out.println(p);
	}

}
