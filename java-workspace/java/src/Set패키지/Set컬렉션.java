package Set��Ű��;


import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

/*
 * Set	- �����ӵ�. �ܼ� ������ �������� �����Ҹ� ������ ó���� �ʿ���.(���ڱ⿡ ���ٰ� �����.)
 * 	����(X) : ���ڱ� ���¿� �������� �� �ִٴ°��� �ǹ�.(�迭 ���·� �����ְ� �� ���� �ƴ�.)
 * 	�ߺ�(X) : �ߺ��� ���� �ٽ� ���� ���е�.
 * ����Ŭ���� : HashSet , TreeSet
 */
public class Set�÷��� {
	public static void main(String[] args) {

//		TreeSet�� ���������� �����Ͱ� ���ĵǼ� ����.
//		Set<String> set = new TreeSet<>();	// ������ ����ȯ
//		�� �Ʒ� �ΰ��� ��� �� ����� �ᵵ ��� ����.(������ ����)
		Set<String> set = new HashSet<>();	// ������ ����ȯ
		
		// size() �Լ��� set�� ũ�� ��ȯ��.
		int size = set.size();
		System.out.println("�Է� �� �������� �� ���� : " + size + "��");
		System.out.println();
		
		// add() �Լ��� �������Է��� �������� ���θ� ��ȯ.(�ߺ��̸� �ź��ؼ� false)
		boolean bool = set.add("one");
		System.out.println("\"one\" ������ �Է� : " + (bool ? "����" : "����"));
		
		set.add("two");
		set.add("three");
		set.add("four");
		set.add("five");

		bool = set.add("one");	// �ߺ� ������� ����.
		System.out.println("\"one\" ������ �Է� : " + (bool ? "����" : "����") + "\n");
		
		size = set.size();
		System.out.println("�Է� �� �������� �� ���� : " + size + "�� \n");
		
		/**
		 * set�� �״�� ����ϸ� toArray() �Լ� ���·� ���µ�	- �迭����.
		 * �װ��� ��ü������ Arrays.toString() �� �̿��ؼ� ���ڿ��� �ٲ㼭 ��µ�.
		 * 
		 * Object[] arr = set.toArray(); // { , , , ...}���·� ��. 
		 * System.out.println(Arrays.toString(arr)); // �迭���¸� ���ڿ��� ��ȯ����.
		 */
		System.out.println("�׳� set ������ ��� \n (toArray() -> Arrays.toString(arr)");
		System.out.println(set + "\n");
		System.out.println(set.toArray());
		System.out.println(set.toString());
		System.out.println(set.hashCode());
		System.out.println(set.toArray().hashCode());
		

		/**
		 * set�� ��� ��ҵ��� ����ϴ� ���
		 */
		// 1. 1.5������ for��
		System.out.println("< 1.5������ for�� >");
		for(String s : set) { // ����Ÿ�� : �迭�̸�
			System.out.print(s + " ");
		}	// �ؽ��ڵ� ���·� ���� ����Ǽ� ������� ������� ����
		System.out.println("\n");

		// 2. iterator() �̿�
		System.out.println("< iterator() �̿� >");
		Iterator<String> ite = set.iterator(); // iterator�� �̿��ؼ� set�� ���� ������.
		while(ite.hasNext()) { // �������� ������ true.
			System.out.print(ite.next() + " "); // �������� return.
		}
		System.out.println("\n");

		// 3. toArray() �̿�
		System.out.println("< toArray() �̿� >");
		// (String[])set.toArray() �� �� �ȵǴ���?? �����غ��� --> ���������ȯ
		Object[] setArr = set.toArray(); // ���� set�� �迭�����ε�, toArray()�� ���� �ٸ����� �迭���·� �������.
		for(Object obj : setArr) {
			System.out.print((String)obj + " ");
		}
	}
}