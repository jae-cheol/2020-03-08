package 코딩테스트.Part1.Ch06_스택;

import java.util.ArrayList;
import java.util.List;

public class 연습해보기 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Stack2<String> s2 = new Stack2<>();
		s2.push("1");
		s2.push("2");
		
		s2.print();
		
		s2.pop();
		s2.print();
		
		s2.pop();
		s2.print();
		
		s2.pop();
		s2.print();
	}

}

class Stack2<T> {
	List<T> l = new ArrayList<>();

	public void push(T t) {
		this.l.add(t);
	}

	public T pop() {
		if (l.size() > 0) {
			return this.l.remove(l.size() - 1);
		} else {
			return null;
		}
	}
	
	public void print() {
		System.out.println(l);
	}
}
