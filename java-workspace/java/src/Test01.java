
public class Test01 {
	public static void main(String[] args) {
		 // 처음에 나온 문자의 형태에 따라 그 다음 값이 결정됨.
		System.out.println('A'+'B'+""+null);
		System.out.println("A"+'B'+""+null);
		
		int i=1, j=0;
		switch(i) {
		case 2:
			j += 6;
		case 4:
			j += 1;
		default:
			j += 2;
		case 0:
			j += 4;
		}
		System.out.println("j = " + j);
		
		System.out.println(5%589); // 더 큰 나머지 연산은 무조건 작은값이 나옴.
		
	}
}
