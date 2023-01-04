package 코딩테스트.Part1.Ch07_링크드리스트;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class 연습해보기 {

	public static void main(String[] args) {
		List<String> l = new LinkedList<>();
//		Collections.sor
		SingleLinkedList<String> sll = null;

	}
	
	public class SingleLinkedList<T> {
		List<T> l;
		
		SingleLinkedList() {
			l = new ArrayList<>();
		}
		
		public void add(T t) {
			l.add(t);
		}
	}

}