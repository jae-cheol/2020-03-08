package LambdaExpressions;
/*
 * �ڹ�8���� ����.(�Լ��� ���α׷����� ����)
 * ���ٽ� "�ĺ��ھ��� ���డ���� �Լ�"
 * �Լ��ε� �Լ��� ���� ������ �ʰ� �ڵ����ٿ� �Լ��� �Ἥ �װ��� ȣ���ϴ� ���
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
