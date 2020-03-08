package LambdaExpressions;
/*
 * 자바8부터 지원.(함수적 프로그래밍을 위해)
 * 람다식 "식별자없이 실행가능한 함수"
 * 함수인데 함수를 따로 만들지 않고 코드한줄에 함수를 써서 그것을 호출하는 방식
 */
interface Compare{
	public int compareTo(int a, int b);
}
public class sum {

	public static void exec(Compare com) {
		int k = 10;
		int m = 20;
		int value = com.compareTo(k, m);
		System.out.println(value);
	}
	public static void main(String[] args) {
		exec((i,j) -> {
			return i+j;
		});
	}

}
