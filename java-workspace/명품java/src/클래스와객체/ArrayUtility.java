package Ŭ�����Ͱ�ü;

public class ArrayUtility {
	static double[] intToDouble(int[] source) {
		double d[] = new double[source.length];	// ���ڷ� �Ѿ�� ������ �迭�� ������ ũ���� ������ �Ǽ��� �迭 ����
		for (int i=0; i<source.length; i++)
			d[i] = source[i]; // �������� �Ǽ��� ��ȯ�Ͽ� �迭�� ����
		return d;
	}
	
	static int[] doubleToInt(double[] source) {
		int i[] = new int[source.length];	// ���ڷ� �Ѿ�� ������ �Ǽ��� �迭�� ������ ũ���� ������ �迭 ����
		for (int j=0; j<source.length; j++)
			i[j] = (int) source[j]; // ������ �Ǽ����� ������ ��ȯ�Ͽ� �迭�� ����
		return i;		
	}
	
	public static void main (String args[])  {
		double d[] = {1.1, 2.2, 3.3, 4.4, 5.5, 6.6, 7.7, 8.8, 9.9, 10.10};
		int i[] = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
		
		double tmp_double[] = intToDouble(i);
		for (int j=0; j<tmp_double.length; j++) System.out.println(tmp_double[j]);
		
		int tmp_int[] = doubleToInt(d);
		for (int j=0; j<tmp_int.length; j++) System.out.println(tmp_int[j]);
	}
}
