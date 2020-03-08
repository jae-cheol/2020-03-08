package com.tyn.edu;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.TreeSet;
import java.util.Vector;

public class ListRacingEx1 {
	int LOOP_COUNT = 1000000;
	
	ArrayList<Integer> arrayList;
	Vector<Integer> vector;
	LinkedList<Integer> linkedList;
	
	public void addArrayList() {
		arrayList = new ArrayList<>();
		for (int loop=0; loop<this.LOOP_COUNT; loop++) {
			arrayList.add(loop);
		}
	}
	
	public void addVector() {
		vector = new Vector<>();
		for (int loop=0; loop<this.LOOP_COUNT; loop++) {
			vector.add(loop);
		}
	}
	
	public void addLinkedList() {
		linkedList = new LinkedList<>();
		for (int loop=0; loop<this.LOOP_COUNT; loop++) {
			linkedList.add(loop);
		}
	}
	
	public static void main(String[] args) throws InterruptedException {
		
		ListRacingEx1 racing = new ListRacingEx1();
		
		long startNano;
		long endNano;
		double elapsedTime;
		
		Runtime rs = Runtime.getRuntime();
		
		rs.gc();
		startNano = System.nanoTime();
		racing.addArrayList();
		endNano = System.nanoTime();
		
		elapsedTime = (endNano - startNano) / 1000000.0;
		System.out.println("arrayListTime : " + elapsedTime);
		
		rs.gc();
		startNano = System.nanoTime();
		racing.addVector();
		endNano = System.nanoTime();
		
		elapsedTime = (endNano - startNano) / 1000000.0;
		System.out.println("VectorTime : " + elapsedTime);
		
		rs.gc();
		startNano = System.nanoTime();
		racing.addLinkedList();
		endNano = System.nanoTime();
		
		elapsedTime = (endNano - startNano) / 1000000.0;
		System.out.println("LinkedListTime : " + elapsedTime);
	}
}