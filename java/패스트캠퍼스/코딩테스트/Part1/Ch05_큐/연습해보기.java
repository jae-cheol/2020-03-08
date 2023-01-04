package 코딩테스트.Part1.Ch05_큐;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

// [2022-02-06 김재철] 실제로 큐를 구현해봄.
public class 연습해보기 {
	
	public static void main(String[] args) {
		Qu<String> q = new Qu<>();
		
		q.enqueue("1");
		
		System.out.println("q : " + q.dequeue());
		
		Queue<String> qq = new LinkedList<String>();
		List<String> l = new ArrayList<>();
		
	}
}

class Qu<E> {
	List<E> l = new ArrayList<>();
	
	public void enqueue(E e) {
		this.l.add(e);
	}
	
	public E dequeue() {
		if(this.l.size() > 0) {
			return this.l.remove(0);
		} else {
			return null;
		}
	}
}