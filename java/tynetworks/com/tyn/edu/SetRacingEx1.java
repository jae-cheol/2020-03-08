package com.tyn.edu;

import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.TreeSet;

public class SetRacingEx1 {
	int LOOP_COUNT = 1000000;
	
	Set<String> set;
	
	String data = "abcdefghijklmnopqrstuvwxyz";
	
	public void addHashSet() {
		set = new HashSet<>();
		for (int loop=0; loop<this.LOOP_COUNT; loop++) {
			set.add(data + loop);
		}
	}
	
	public void addTreeSet() {
		set = new TreeSet<>();
		for (int loop=0; loop<this.LOOP_COUNT; loop++) {
			set.add(data + loop);
		}
	}
	
	public void addLinkedHashSet() {
		set = new LinkedHashSet<>();
		for (int loop=0; loop<this.LOOP_COUNT; loop++) {
			set.add(data + loop);
		}
	}
	
	public static void main(String[] args) {
		
		SetRacingEx1 racing = new SetRacingEx1();
		
		long startNano;
		long endNano;
		double elapsedTime;
		
		Runtime rs = Runtime.getRuntime();
		
		rs.gc();
		startNano = System.nanoTime();
		racing.addHashSet();
		endNano = System.nanoTime();
		
		elapsedTime = (endNano - startNano) / 1000000.0;
		System.out.println("HashSetTime : " + elapsedTime);
		
		rs.gc();
		startNano = System.nanoTime();
		racing.addTreeSet();
		endNano = System.nanoTime();
		
		elapsedTime = (endNano - startNano) / 1000000.0;
		System.out.println("TreeSetTime : " + elapsedTime);
		
		rs.gc();
		startNano = System.nanoTime();
		racing.addLinkedHashSet();
		endNano = System.nanoTime();
		
		elapsedTime = (endNano - startNano) / 1000000.0;
		System.out.println("LinkedHashSetTime : " + elapsedTime);
	}
}
