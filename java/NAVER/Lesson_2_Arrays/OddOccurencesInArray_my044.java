package Lesson_2_Arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.stream.Collectors;

/**
 * <배열(홀수발생배열) - 홀수 개의 요소에서 발생하는 값을 찾으십시오.>
 * 
 * array 를 list로 변환할 때 보통 다음과 같이 사용한다.
 * 이 변환은 non primitive 타입에 대해서만 가능한 변환이다.
 * String[] strings = new String[] {"a", "b", "c"};
 * List<string> stringList = Arrays.asList(strings);
 * 
 * 만약 primitive 타입인 int array를 Arrays.asList를 사용하면 반환값은 다음과 같다.
 * int[] ints = {1, 4, 3};
 * List<Integer> intList = Arrays.stream(ints).boxed().collect(Collectors.toList());
 * 
 * Arrays.asList() : 배열을 리스트처럼 사용하겠다는 함수.(non primitive 타입만 가능)
 * 
 * 정렬하고 연속된수 제거하는방식으로해볼까ㅣ??
 */
public class OddOccurencesInArray_my044 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] A = {9,3,9,3,9,7,9};
		int returnValue = 0;	// 결과값
		
		
		List<Integer> al = Arrays.stream(A).boxed().collect(Collectors.toList());
		List<Integer> copyAl = Arrays.stream(A).boxed().collect(Collectors.toList());
		System.out.println("copyAl : " + copyAl);
		System.out.println("al.size() : " + al.size());
		

		/**
		 * 중복 요소를 제거하는 방법
		 * 중복 데이터를 허용하지 않는 set을 이용하여 데이터를 다 집어 넣은 후, 다시 set의 데이터를 받아오면 중복이 제거된다.
		 */
		HashSet hs = new HashSet<>();
		hs.addAll(al);
		al.clear();
		al.addAll(hs);
		System.out.println("al : " + al);
		System.out.println("A : " + Arrays.toString(A));
				
		while(true) {
			for(int i=0; i<al.size(); i++) {
				int cnt = 0;
				for(int j=0; j<copyAl.size(); j++) {
					if(al.get(i) == copyAl.get(j)) {
						cnt++;
						if(cnt >= 2) {
							break;
						}
					}
				}
				System.out.println("cnt : " + cnt);
				System.out.println("al.get(i) : " + al.get(i));
				if(cnt == 1) {
					returnValue = al.get(i);
				}
			}
			break;
		}
		
		System.out.println("returnValue : " + returnValue);
		
//		for(int i=0; i<al.size(); i++) {
//			// (자바8이상) 배열에 특정값이 존재하는지 찾기.
//			int c = al.get(i);
//			System.out.println( IntStream.of(A).anyMatch(x -> x == c ));
//		}
		
//		for(int i=0; i<A.length; i++) {
//			for(int j=0; j<al.size(); j++) {
//				if(A[i] != al.get(j)) {
//					System.out.println(i+"-"+j+ " : " + A[i]);
//					break;
//				}
//			}
//		}
	}
}
