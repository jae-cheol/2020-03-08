package 스트링;
/*
 * equalsIgnoreCase()	: 대소문자 상관없이 같은지 비교.
 * startsWith(~) 		: ~로 시작하는거 찾을때.
 * endsWith(~)			: ~로 끝나는거 찾을때.
 * indexOf(~)			: 해당 문자가 들어있는 위치를 알려 줍니다.(문자가 없으면 -1 반환)
 * 	예) "abcde".indexOf("e")에는 4가 읽어 집니다. 0부터 시작하기 때문입니다.
 * contains(~)			: ~가 포함된거 찾을때.
 */
public class 파일검색 {

	public static void main(String[] args) {

		String[] strArr = {"hello.txt", "hello2.txt", "hellotxt3.jpg", "good-bye.png"};
		
		// "hello.txt"의 존재여부 판단
		for(String s : strArr) {
			if(s.equalsIgnoreCase("hello.txt")) {
				System.out.println("배열에 해당하는 String이 존재합니다.");
			}
		}
		System.out.println();

		System.out.println("< he로 시작되는 파일 검색 >");
		for(String s : strArr) {
			if(s.startsWith("he")) {
				System.out.print(s + " ");
			}
		}
		System.out.println("\n");
		
		System.out.println("< 확장자가 txt인 파일 검색 >");
		for(String s : strArr) {
			if(s.endsWith("txt")) {
				System.out.print(s + " // ");
			}
		}
		System.out.println("\n");
		
		System.out.println("< txt가 포함된 파일 검색 >");
		for(String s : strArr) {
			System.out.println(s.indexOf("txt"));
			if(s.indexOf("txt") != -1) {
//			if(s.contains("txt")) {
				System.out.print(s + " // ");
			}
		}
	}
}