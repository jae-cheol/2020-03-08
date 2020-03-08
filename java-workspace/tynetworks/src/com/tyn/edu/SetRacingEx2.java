package com.tyn.edu;

import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.TreeSet;

public class SetRacingEx2 {
	int LOOP_COUNT = 1000000;
	
	HashSet<String> hashSet = new HashSet<>();
	TreeSet<String> treeSet = new TreeSet<>();
	LinkedHashSet<String> linkedHashSet = new LinkedHashSet<>();
	
	String data = "abcdefghijklmnopqrstuvwxyz";
	
	public void setUp() {
		String tmp;
		
		for (int loop=0; loop<this.LOOP_COUNT; loop++) {
			tmp = data + loop;
			hashSet.add(tmp);
			treeSet.add(tmp);
			linkedHashSet.add(tmp);
		}
	}
	
	public void iterateHashSet() {
		Iterator<String> iter = hashSet.iterator();
		while (iter.hasNext()) {
			iter.next();
		}
	}
	
	public void iterateTreeSet() {
		Iterator<String> iter = treeSet.iterator();
		while (iter.hasNext()) {
			iter.next();
		}
	}
	
	public void iterateLinkedHashSet() {
		Iterator<String> iter = linkedHashSet.iterator();
		while (iter.hasNext()) {
			iter.next();
		}
	}
	
	public static void main(String[] args) {
		
		SetRacingEx2 racing = new SetRacingEx2();
		
		racing.setUp();
		
		Runtime rs = Runtime.getRuntime();
		
		long startNano;
		long endNano;
		double elapsedTime;
		
		rs.gc();
		startNano = System.nanoTime();
		racing.iterateHashSet();
		endNano = System.nanoTime();
		
		elapsedTime = (endNano - startNano) / 1000000.0;
		System.out.println("HashSetTime : " + elapsedTime);
		
		rs.gc();
		startNano = System.nanoTime();
		racing.iterateTreeSet();
		endNano = System.nanoTime();
		
		elapsedTime = (endNano - startNano) / 1000000.0;
		System.out.println("TreeSetTime : " + elapsedTime);
		
		rs.gc();
		startNano = System.nanoTime();
		racing.iterateLinkedHashSet();
		endNano = System.nanoTime();
		
		elapsedTime = (endNano - startNano) / 1000000.0;
		System.out.println("LinkedHashSetTime : " + elapsedTime);
	}
}