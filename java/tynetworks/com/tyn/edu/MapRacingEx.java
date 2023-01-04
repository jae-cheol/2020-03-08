//package com.tyn.edu;
//
//import java.util.HashMap;
//import java.util.Hashtable;
//import java.util.LinkedHashMap;
//import java.util.Map;
//import java.util.TreeMap;
//
//import com.tyn.edu.util.RandomKeyUtil;
//
//public class MapRacingEx {
//	int LOOP_COUNT = 100000;
//	
//	Map<Integer, String> hashMap;
//	Map<Integer, String> hashtable;
//	Map<Integer, String> treeMap;
//	Map<Integer, String> linkedHashMap;
//	
//	Integer keys[];
//	
//	public void setUp() {
//		
//		if (keys==null || keys.length != LOOP_COUNT) {
//
//			hashMap = new HashMap<>();
//			hashtable = new Hashtable<>();
//			treeMap = new TreeMap<>();
//			linkedHashMap = new LinkedHashMap<>();
//			
//			String data = "abcdefghijklmnopqrstuvwxyz";
//			
//			for (int loop=0; loop<this.LOOP_COUNT; loop++) {
//				String tmpData = data + loop;
//				hashMap.put(loop, tmpData);
//				hashtable.put(loop, tmpData);
//				treeMap.put(loop, tmpData);
//				linkedHashMap.put(loop, tmpData);
//			}
//			
//			// 섞기
//			keys = RandomKeyUtil.generateRandomSetKeysSwap(LOOP_COUNT);
//		}
//	}
//	
//	public void getSeqHashMap() {
//		for (int loop=0; loop<this.LOOP_COUNT; loop++) {
//			hashMap.get(loop);
//		}
//	}
//	
//	public void getSeqHashtable() {
//		for (int loop=0; loop<this.LOOP_COUNT; loop++) {
//			hashtable.get(loop);
//		}
//	}
//	
//	public void getSeqTreeMap() {
//		for (int loop=0; loop<this.LOOP_COUNT; loop++) {
//			treeMap.get(loop);
//		}
//	}
//	
//	public void getSeqLinkedHashMap() {
//		for (int loop=0; loop<this.LOOP_COUNT; loop++) {
//			linkedHashMap.get(loop);
//		}
//	}
//	
//	public void getRandomHashMap() {
//		for (int loop=0; loop<this.LOOP_COUNT; loop++) {
//			hashMap.get(keys[loop]);
//		}
//	}
//
//	public void getRandomHashtable() {
//		for (int loop=0; loop<this.LOOP_COUNT; loop++) {
//			hashtable.get(keys[loop]);
//		}
//	}
//
//	public void getRandomTreeMap() {
//		for (int loop=0; loop<this.LOOP_COUNT; loop++) {
//			treeMap.get(keys[loop]);
//		}
//	}
//
//	public void getRandomLinkedHashMap() {
//		for (int loop=0; loop<this.LOOP_COUNT; loop++) {
//			linkedHashMap.get(keys[loop]);
//		}
//	}
//	
//	public static void main(String[] args) {
//		
//		MapRacingEx racing = new MapRacingEx();
//		racing.setUp();
//		
//		long startNano;
//		long endNano;
//		double elapsedTime;
//		
//		Runtime rs = Runtime.getRuntime();
//		
//		System.out.println("=== [순차 접근] ===");
//		
//		rs.gc();
//		startNano = System.nanoTime();
//		racing.getSeqHashMap();
//		endNano = System.nanoTime();
//		
//		elapsedTime = (endNano - startNano) / 1000000.0;
//		System.out.println("getSeqHashMapTime : " + elapsedTime);
//		
//		rs.gc();
//		startNano = System.nanoTime();
//		racing.getSeqHashtable();
//		endNano = System.nanoTime();
//		
//		elapsedTime = (endNano - startNano) / 1000000.0;
//		System.out.println("getSeqHashtableTime : " + elapsedTime);
//		
//		rs.gc();
//		startNano = System.nanoTime();
//		racing.getSeqTreeMap();
//		endNano = System.nanoTime();
//		
//		elapsedTime = (endNano - startNano) / 1000000.0;
//		System.out.println("getSeqTreeMapTime : " + elapsedTime);
//
//		rs.gc();
//		startNano = System.nanoTime();
//		racing.getSeqLinkedHashMap();
//		endNano = System.nanoTime();
//		
//		elapsedTime = (endNano - startNano) / 1000000.0;
//		System.out.println("getSeqLinkedHashMap : " + elapsedTime);
//		
//		
//		System.out.println("=== [임의] ===");
//
//		
//		rs.gc();
//		startNano = System.nanoTime();
//		racing.getRandomHashMap();
//		endNano = System.nanoTime();
//		
//		elapsedTime = (endNano - startNano) / 1000000.0;
//		System.out.println("getRandomHashMapTime : " + elapsedTime);
//
//		rs.gc();
//		startNano = System.nanoTime();
//		racing.getRandomHashtable();
//		endNano = System.nanoTime();
//		
//		elapsedTime = (endNano - startNano) / 1000000.0;
//		System.out.println("getRandomHashtableTime : " + elapsedTime);
//
//		rs.gc();
//		startNano = System.nanoTime();
//		racing.getRandomTreeMap();
//		endNano = System.nanoTime();
//		
//		elapsedTime = (endNano - startNano) / 1000000.0;
//		System.out.println("getRandomTreeMapTime : " + elapsedTime);
//
//		rs.gc();
//		startNano = System.nanoTime();
//		racing.getRandomLinkedHashMap();
//		endNano = System.nanoTime();
//		
//		elapsedTime = (endNano - startNano) / 1000000.0;
//		System.out.println("getRandomLinkedHashMapTime : " + elapsedTime);
//		
//		
//	}
//}
