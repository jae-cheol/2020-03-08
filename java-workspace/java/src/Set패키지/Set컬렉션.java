package Set패키지;


import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

/*
 * Set	- 빠른속도. 단순 집합의 개념으로 정렬할면 별도의 처리가 필요함.(보자기에 들어간다고 보면됨.)
 * 	순서(X) : 보자기 형태에 무작위로 들어가 있다는것을 의미.(배열 형태로 순서있게 들어간 것이 아님.)
 * 	중복(X) : 중복된 값이 다시 들어가면 실패됨.
 * 구현클래스 : HashSet , TreeSet
 */
public class Set컬렉션 {
	public static void main(String[] args) {

//		TreeSet은 사전순으로 데이터가 정렬되서 나옴.
//		Set<String> set = new TreeSet<>();	// 묵시적 형변환
//		위 아래 두가지 경우 중 어느걸 써도 상관 없음.(정렬의 차이)
		Set<String> set = new HashSet<>();	// 묵시적 형변환
		
		// size() 함수는 set의 크기 반환함.
		int size = set.size();
		System.out.println("입력 전 데이터의 총 개수 : " + size + "개");
		System.out.println();
		
		// add() 함수는 데이터입력의 성공실패 여부를 반환.(중복이면 거부해서 false)
		boolean bool = set.add("one");
		System.out.println("\"one\" 데이터 입력 : " + (bool ? "성공" : "실패"));
		
		set.add("two");
		set.add("three");
		set.add("four");
		set.add("five");

		bool = set.add("one");	// 중복 허용하지 않음.
		System.out.println("\"one\" 데이터 입력 : " + (bool ? "성공" : "실패") + "\n");
		
		size = set.size();
		System.out.println("입력 전 데이터의 총 개수 : " + size + "개 \n");
		
		/**
		 * set을 그대로 출력하면 toArray() 함수 형태로 들어가는데	- 배열형태.
		 * 그것을 자체적으로 Arrays.toString() 을 이용해서 문자열로 바꿔서 출력됨.
		 * 
		 * Object[] arr = set.toArray(); // { , , , ...}형태로 들어감. 
		 * System.out.println(Arrays.toString(arr)); // 배열형태를 문자열로 반환해줌.
		 */
		System.out.println("그냥 set 변수를 출력 \n (toArray() -> Arrays.toString(arr)");
		System.out.println(set + "\n");
		System.out.println(set.toArray());
		System.out.println(set.toString());
		System.out.println(set.hashCode());
		System.out.println(set.toArray().hashCode());
		

		/**
		 * set의 모든 요소들을 출력하는 방법
		 */
		// 1. 1.5버전의 for문
		System.out.println("< 1.5버전의 for문 >");
		for(String s : set) { // 변수타입 : 배열이름
			System.out.print(s + " ");
		}	// 해쉬코드 형태로 값이 저장되서 순서대로 저장되진 않음
		System.out.println("\n");

		// 2. iterator() 이용
		System.out.println("< iterator() 이용 >");
		Iterator<String> ite = set.iterator(); // iterator를 이용해서 set의 값을 가져옴.
		while(ite.hasNext()) { // 다음값이 있으면 true.
			System.out.print(ite.next() + " "); // 다음값을 return.
		}
		System.out.println("\n");

		// 3. toArray() 이용
		System.out.println("< toArray() 이용 >");
		// (String[])set.toArray() 가 왜 안되는지?? 생각해보기 --> 명시적형변환
		Object[] setArr = set.toArray(); // 원래 set이 배열형태인데, toArray()를 통해 다른곳에 배열형태로 만들어줌.
		for(Object obj : setArr) {
			System.out.print((String)obj + " ");
		}
	}
}