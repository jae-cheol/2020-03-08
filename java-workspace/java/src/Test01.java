
public class Test01 {
	public static void main(String[] args) {
		 // ó���� ���� ������ ���¿� ���� �� ���� ���� ������.
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
		
		System.out.println(5%589); // �� ū ������ ������ ������ �������� ����.
		
	}
}
