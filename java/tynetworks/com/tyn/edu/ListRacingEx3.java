package com.tyn.edu;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Vector;

public class ListRacingEx3 {
	int LOOP_COUNT = 100000;
	
	ArrayList<Integer> arrayList;
	Vector<Integer> vector;
	LinkedList<Integer> linkedList;
	
	public void setUp() {
		arrayList = new ArrayList<>();
		vector = new Vector<>();
		linkedList = new LinkedList<>();
		
		for (int loop=0; loop<this.LOOP_COUNT; loop++) {
			arrayList.add(loop);
			vector.add(loop);
			linkedList.add(loop);
		}
	}
	
	public void removeArrayListFromFirst() {
		ArrayList<Integer> tmpList = new ArrayList<>(arrayList);
		for (int loop=0; loop<this.LOOP_COUNT; loop++) {
			tmpList.remove(0);
		}
	}

	public void removeLinkedListFromFirst() {
		LinkedList<Integer> tmpList = new LinkedList<>(linkedList);
		for (int loop=0; loop<this.LOOP_COUNT; loop++) {
			tmpList.removeFirst();
		}
	}
	
	public void removeArrayListFromLast() {
		List<Integer> tmpList = new ArrayList<>(arrayList);
		for (int loop=this.LOOP_COUNT-1; loop>=0; loop--) {
			tmpList.remove(loop);
		}
	}
	
	public void removeVectorFromLast() {
		List<Integer> tmpList = new Vector<>(vector);
		for (int loop=this.LOOP_COUNT-1; loop>=0; loop--) {
			tmpList.remove(loop);
		}
	}
	
	public void removeLinkedListFromLast() {
		List<Integer> tmpList = new LinkedList<>(linkedList);
		for (int loop=this.LOOP_COUNT-1; loop>=0; loop--) {
			tmpList.remove(loop);
		}
	}
	
	public void removeVectorFromFirst() {
		Vector<Integer> tmpList = new Vector<>(vector);
		for (int loop=0; loop<this.LOOP_COUNT; loop++) {
			tmpList.remove(0);
		}
	}
	
	
	public static void main(String[] args) throws InterruptedException {
		
		ListRacingEx3 racing = new ListRacingEx3();
		racing.setUp();
		
		long startNano;
		long endNano;
		double elapsedTime;
		
		Runtime rs = Runtime.getRuntime();
		
		System.out.println("=== [앞 부터 삭제] ===");
		
		rs.gc();
		startNano = System.nanoTime();
		racing.removeArrayListFromFirst();
		endNano = System.nanoTime();
		
		elapsedTime = (endNano - startNano) / 1000000.0;
		System.out.println("arrayListTime : " + elapsedTime);
		
		rs.gc();
		startNano = System.nanoTime();
		racing.removeVectorFromFirst();
		endNano = System.nanoTime();
		
		elapsedTime = (endNano - startNano) / 1000000.0;
		System.out.println("VectorTime : " + elapsedTime);
		
		rs.gc();
		startNano = System.nanoTime();
		racing.removeLinkedListFromFirst();
		endNano = System.nanoTime();
		
		elapsedTime = (endNano - startNano) / 1000000.0;
		System.out.println("LinkedListTime : " + elapsedTime);
		
		System.out.println("=== [뒤 부터 삭제] ===");

		rs.gc();
		startNano = System.nanoTime();
		racing.removeArrayListFromLast();
		endNano = System.nanoTime();
		
		elapsedTime = (endNano - startNano) / 1000000.0;
		System.out.println("arrayListTime : " + elapsedTime);
		
		rs.gc();
		startNano = System.nanoTime();
		racing.removeVectorFromLast();
		endNano = System.nanoTime();
		
		elapsedTime = (endNano - startNano) / 1000000.0;
		System.out.println("VectorTime : " + elapsedTime);
		
		rs.gc();
		startNano = System.nanoTime();
		racing.removeLinkedListFromLast();
		endNano = System.nanoTime();
		
		elapsedTime = (endNano - startNano) / 1000000.0;
		System.out.println("LinkedListTime : " + elapsedTime);
		
		
	}
}
