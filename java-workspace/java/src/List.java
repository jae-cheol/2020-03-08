import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedList;

/*
 * 원하는 데이터가 뒤쪽에 있으면 속도가 문제가 됨.
 * 
 * List 특징 : 순서(O) , 중복(O)
 * 				순서가 있고, 중복을 허용함(배열과 유사) 	// 가변적인 배열
 * 					 내부적으로 배열을 이용하여 데이터 관리
 * 
 * 구현클래스 : ArrayList , LinkedList
 * 
 * List 주요메소드
 * - add(E e)		: 데이터 입력
 * - addAll(List l)	: 리스트의 전체데이터를 추가
 * - get(int i)		: 해당 인덱스의 데이터 추출
 * - E remove(int i)	: 해당 인텍스의 데이터 삭제
 * - boolean remove(E e)	: 해당 데이터를 가진 원소 삭제
 * - clear()		: 리스트의 전체원소 삭제
 * - contains(E e)	: 해당 데이터를 가진 원소의 존재여부 판단
 * - size()			: 리스트의 전체원소개수			--> length() 리턴해서 만든 메소드
 * - isEmpty()		: 리스트가 비어있는지 판단
 * - iterator()		: Iterator객체 반환
 */

public class List {
	
	public static void main(String[] args) {
		
		// 모든 객체를 상관없이 다 받을 수 있지만, 빼낼때 다 형변환 해줘야 하는 번거로움이 있음.
//		ArrayList list = new ArrayList();	// 1.5버전 전 모델
		
		// 원하는 형태만 받도록 해줌. 대신 다른형태를 넣을때는 다 따로 만들어줘야함.
//		ArrayList<String> list = new ArrayList<String>();	// 1.7버전 이전

		// List는 인터페이스
//		List<String> list = new ArrayList<>(); // 1.7버전 이후 , 자동으로 생략해도 상관없음.

		// Array <--> Linked 상호호완
		LinkedList<String> list = new LinkedList<>();

		int size = list.size();	// List는 갯수/크기를 size() 메소드로 받음.
		System.out.println("입력전 배열의 원소개수 : " + size + "개");
		
		// List에 데이터를 add 이용해서 하나씩 넣음.
		list.add("one");
		list.add("two");
		list.add("three");
		list.add("four");
		list.add("five");
		list.add("one");
		
		size = list.size();
		System.out.println("입력후 배열의 원소개수 : " + size + "개");
		
		 
		/**
		 * list 전체데이터 출력방식
		 */
		// 1. index를 활용한 get() 메소드 
		System.out.println();
		System.out.println("< get() 메소드를 이용한 전체 출력 >");
		for(int i=0; i<list.size(); i++) {
			// List의 get() 메소드를 이용해서 데이터를 하나씩 추출함.
			System.out.print(list.get(i) + " ");
		}
		System.out.println();
		System.out.println();
		
		// 2. 1.5버전의 for문
		System.out.println("< 1.5버전의 for문을 이용한 전체 출력 >");
		// List의 값들의 타입은 String이므로 String으로 for문을 돌림.
		for(String str : list) { 
			System.out.print(str + " ");
		}
		System.out.println();
		System.out.println();
		
		// 3. toArray() 메소드
		System.out.println("< toArray() 메소드를 이용한 전체 출력");
		// toArray() 메소드는 컬렉션 형태를 배열로 리턴해주는 함수.
		Object[] arr = list.toArray();	// { , , , ...}형태로 들어감. 
		System.out.println(Arrays.toString(arr));	// 배열형태를 문자열로 반환해줌.
		System.out.println();
		
		/**
		 * Iterator(순환자) 인터페이스의 주요메소드
		 * - hasNext() : 다음데이터의 존재여부 판단
		 * - next()    : 데이터 추출
		 */
		// 4. iterator() 메소드
		System.out.println("< iterator() 메소드를 이용한 전체 출력 >");
		Iterator<String> ite = list.iterator();
		while(ite.hasNext()) { // 데이터가 있다면...
			System.out.print(ite.next() + " "); // 데이터 출력...
		}
		System.out.println();
		System.out.println();
		
		/**
		 * "one" 삭제
		 * 
		 * remove("봄") : 들어있는 것 중 봄은 다 삭제.
		 */
		// 첫번째 "one" 삭제  ,  one이라는 String이 있으면 삭제하고 뒤에께 땡겨짐.
		boolean bool = list.remove("one");
		System.out.println("\"one\"문자열의 삭제여부 : " + bool);
		
		// 마지막 "one" 삭제
		bool = list.remove("one");
		System.out.println("\"one\"문자열의 삭제여부 : " + bool);
		
		// "one" 이 다 지워져서 삭제할게 없음.
		bool = list.remove("one");
		System.out.println("\"one\"문자열의 삭제여부 : " + bool);
		System.out.println();
		System.out.println("0번지에 위치한 문자열 : " + list.get(0));
		System.out.println("0번지에 위치한 문자열 삭제 : " + list.remove(0));
		System.out.println("삭제 후 데이터 개수 : " + list.size() + "개");
		System.out.println();

		// contains() 함수는 특정 데이터가 존재하는지 체크함. (boolean형태)
		if(list.contains("two")) {
			System.out.println("\"two\" 문자열이 존재합니다.");
		} else {
			System.out.println("\"two\" 문자열이 존재하지 않습니다.");
		}
		System.out.println();
		
		ArrayList<String> sub = new ArrayList<>();
		sub.add("1");
		sub.add("2");
		sub.add("3");
		sub.add("4");
		sub.add("5");
		sub.add("나는 김재철이다 안녕?");
		
		// addAll() 함수는 LinkedList에 ArrayList 콜렉션의 데이터를 추가
		list.addAll(sub);
		System.out.println("addAll() 호출 후 데이터의 개수 : " + list.size() + "개");
		System.out.println();
		
		// isEmpty() 함수는 데이터가 존재하는지를 체크하는 함수.
		if(list.isEmpty()) {
			System.out.println("배열에 데이터가 없습니다.");
		} else {
			System.out.println("배열에 데이터가 있습니다.");
		}
		
		// clear()는 모든 데이터를 삭제하는 함수.
		list.clear();
		
		if(list.isEmpty()) {
			System.out.println("배열에 데이터가 없습니다.");
		} else {
			System.out.println("배열에 데이터가 있습니다.");
		}
	}
}
