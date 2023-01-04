package Lesson_2_Arrays;

import java.util.HashSet;
import java.util.Set;

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
public class OddOccurencesInArray_set100 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] A = {9,3,9,3,9,7,9};

		/**
		 * Set은 집합적인 개념의 Collection으로 순서는 의미가 없지만
		 * Data를 중복해서 포함할 수 없는 특징을 가지고 있다.
		 */
		Set<Integer> set = new HashSet<>();
		System.out.println("set : " + set);
		
		for(int i : A){
			if(set.contains(i)){
				System.out.println("if : " + i);
				set.remove(i);
			}else{
				System.out.println("else : " + i);
				set.add(i);
			}
		}

		// 데이터 추출.
		System.out.println("result : " + set.iterator().next());
	}
}
