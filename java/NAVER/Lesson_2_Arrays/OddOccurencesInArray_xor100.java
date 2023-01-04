package Lesson_2_Arrays;

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
public class OddOccurencesInArray_xor100 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] A = {9,3,9,3,9,7,9};

		int temp = 0;
		
		/**
		 * 같으면 패스
		 * 다르면 해당값
		 */
		for(int i= 0; i<A.length; ++i){
			System.out.println("temp : "+temp);
			System.out.println("A[i] : "+A[i]);
			temp = temp ^ A[i];
			System.out.println("xor : "+temp);
			System.out.println("--------------------");
		}

		System.out.println("temp : " + temp);
	}
}
