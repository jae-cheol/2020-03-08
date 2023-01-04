//package com.tyn.edu;
//
//import java.util.HashSet;
//import java.util.LinkedHashSet;
//import java.util.TreeSet;
//
//import com.tyn.edu.util.RandomKeyUtil;
//
//public class SetRacingEx3 {
//	int LOOP_COUNT = 1000000;
//	
//	HashSet<String> hashSet = new HashSet<>();
//	TreeSet<String> treeSet = new TreeSet<>();
//	LinkedHashSet<String> linkedHashSet = new LinkedHashSet<>();
//	
//	String data = "abcdefghijklmnopqrstuvwxyz";
//	String[] keys;
//	
//	public void setUp() {
//		String tmp;
//		
//		for (int loop=0; loop<this.LOOP_COUNT; loop++) {
//			tmp = data + loop;
//			hashSet.add(tmp);
//			treeSet.add(tmp);
//			linkedHashSet.add(tmp);
//		}
//		
//		if (keys == null || keys.length != LOOP_COUNT) {
//			keys = RandomKeyUtil.generateRandomSetKeysSwap(hashSet);
//		}
//	}
//	
//	public void containsHashSet() {
//		for (String key : keys) {
//			hashSet.contains(key);
//		}
//	}
//	
//	public void containsTreeSet() {
//		for (String key : keys) {
//			treeSet.contains(key);
//		}
//	}
//	
//	public void containsLinkedHashSet() {
//		for (String key : keys) {
//			linkedHashSet.contains(key);
//		}
//		linkedHashSet.spliterator();
//	}
//	
//	public static void main(String[] args) {
//		
//		SetRacingEx3 racing = new SetRacingEx3();
//		
//		racing.setUp();
//		
//		Runtime rs = Runtime.getRuntime();
//		
//		long startNano;
//		long endNano;
//		double elapsedTime;
//		
//		rs.gc();
//		startNano = System.nanoTime();
//		racing.containsHashSet();
//		endNano = System.nanoTime();
//		
//		elapsedTime = (endNano - startNano) / 1000000.0;
//		System.out.println("HashSetTime : " + elapsedTime);
//		
//		rs.gc();
//		startNano = System.nanoTime();
//		racing.containsTreeSet();
//		endNano = System.nanoTime();
//		
//		elapsedTime = (endNano - startNano) / 1000000.0;
//		System.out.println("TreeSetTime : " + elapsedTime);
//		
//		rs.gc();
//		startNano = System.nanoTime();
//		racing.containsLinkedHashSet();
//		endNano = System.nanoTime();
//		
//		elapsedTime = (endNano - startNano) / 1000000.0;
//		System.out.println("LinkedHashSetTime : " + elapsedTime);
//	}
//}
