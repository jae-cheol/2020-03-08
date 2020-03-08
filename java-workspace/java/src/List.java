import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedList;

/*
 * ���ϴ� �����Ͱ� ���ʿ� ������ �ӵ��� ������ ��.
 * 
 * List Ư¡ : ����(O) , �ߺ�(O)
 * 				������ �ְ�, �ߺ��� �����(�迭�� ����) 	// �������� �迭
 * 					 ���������� �迭�� �̿��Ͽ� ������ ����
 * 
 * ����Ŭ���� : ArrayList , LinkedList
 * 
 * List �ֿ�޼ҵ�
 * - add(E e)		: ������ �Է�
 * - addAll(List l)	: ����Ʈ�� ��ü�����͸� �߰�
 * - get(int i)		: �ش� �ε����� ������ ����
 * - E remove(int i)	: �ش� ���ؽ��� ������ ����
 * - boolean remove(E e)	: �ش� �����͸� ���� ���� ����
 * - clear()		: ����Ʈ�� ��ü���� ����
 * - contains(E e)	: �ش� �����͸� ���� ������ ���翩�� �Ǵ�
 * - size()			: ����Ʈ�� ��ü���Ұ���			--> length() �����ؼ� ���� �޼ҵ�
 * - isEmpty()		: ����Ʈ�� ����ִ��� �Ǵ�
 * - iterator()		: Iterator��ü ��ȯ
 */

public class List {
	
	public static void main(String[] args) {
		
		// ��� ��ü�� ������� �� ���� �� ������, ������ �� ����ȯ ����� �ϴ� ���ŷο��� ����.
//		ArrayList list = new ArrayList();	// 1.5���� �� ��
		
		// ���ϴ� ���¸� �޵��� ����. ��� �ٸ����¸� �������� �� ���� ����������.
//		ArrayList<String> list = new ArrayList<String>();	// 1.7���� ����

		// List�� �������̽�
//		List<String> list = new ArrayList<>(); // 1.7���� ���� , �ڵ����� �����ص� �������.

		// Array <--> Linked ��ȣȣ��
		LinkedList<String> list = new LinkedList<>();

		int size = list.size();	// List�� ����/ũ�⸦ size() �޼ҵ�� ����.
		System.out.println("�Է��� �迭�� ���Ұ��� : " + size + "��");
		
		// List�� �����͸� add �̿��ؼ� �ϳ��� ����.
		list.add("one");
		list.add("two");
		list.add("three");
		list.add("four");
		list.add("five");
		list.add("one");
		
		size = list.size();
		System.out.println("�Է��� �迭�� ���Ұ��� : " + size + "��");
		
		 
		/**
		 * list ��ü������ ��¹��
		 */
		// 1. index�� Ȱ���� get() �޼ҵ� 
		System.out.println();
		System.out.println("< get() �޼ҵ带 �̿��� ��ü ��� >");
		for(int i=0; i<list.size(); i++) {
			// List�� get() �޼ҵ带 �̿��ؼ� �����͸� �ϳ��� ������.
			System.out.print(list.get(i) + " ");
		}
		System.out.println();
		System.out.println();
		
		// 2. 1.5������ for��
		System.out.println("< 1.5������ for���� �̿��� ��ü ��� >");
		// List�� ������ Ÿ���� String�̹Ƿ� String���� for���� ����.
		for(String str : list) { 
			System.out.print(str + " ");
		}
		System.out.println();
		System.out.println();
		
		// 3. toArray() �޼ҵ�
		System.out.println("< toArray() �޼ҵ带 �̿��� ��ü ���");
		// toArray() �޼ҵ�� �÷��� ���¸� �迭�� �������ִ� �Լ�.
		Object[] arr = list.toArray();	// { , , , ...}���·� ��. 
		System.out.println(Arrays.toString(arr));	// �迭���¸� ���ڿ��� ��ȯ����.
		System.out.println();
		
		/**
		 * Iterator(��ȯ��) �������̽��� �ֿ�޼ҵ�
		 * - hasNext() : ������������ ���翩�� �Ǵ�
		 * - next()    : ������ ����
		 */
		// 4. iterator() �޼ҵ�
		System.out.println("< iterator() �޼ҵ带 �̿��� ��ü ��� >");
		Iterator<String> ite = list.iterator();
		while(ite.hasNext()) { // �����Ͱ� �ִٸ�...
			System.out.print(ite.next() + " "); // ������ ���...
		}
		System.out.println();
		System.out.println();
		
		/**
		 * "one" ����
		 * 
		 * remove("��") : ����ִ� �� �� ���� �� ����.
		 */
		// ù��° "one" ����  ,  one�̶�� String�� ������ �����ϰ� �ڿ��� ������.
		boolean bool = list.remove("one");
		System.out.println("\"one\"���ڿ��� �������� : " + bool);
		
		// ������ "one" ����
		bool = list.remove("one");
		System.out.println("\"one\"���ڿ��� �������� : " + bool);
		
		// "one" �� �� �������� �����Ұ� ����.
		bool = list.remove("one");
		System.out.println("\"one\"���ڿ��� �������� : " + bool);
		System.out.println();
		System.out.println("0������ ��ġ�� ���ڿ� : " + list.get(0));
		System.out.println("0������ ��ġ�� ���ڿ� ���� : " + list.remove(0));
		System.out.println("���� �� ������ ���� : " + list.size() + "��");
		System.out.println();

		// contains() �Լ��� Ư�� �����Ͱ� �����ϴ��� üũ��. (boolean����)
		if(list.contains("two")) {
			System.out.println("\"two\" ���ڿ��� �����մϴ�.");
		} else {
			System.out.println("\"two\" ���ڿ��� �������� �ʽ��ϴ�.");
		}
		System.out.println();
		
		ArrayList<String> sub = new ArrayList<>();
		sub.add("1");
		sub.add("2");
		sub.add("3");
		sub.add("4");
		sub.add("5");
		sub.add("���� ����ö�̴� �ȳ�?");
		
		// addAll() �Լ��� LinkedList�� ArrayList �ݷ����� �����͸� �߰�
		list.addAll(sub);
		System.out.println("addAll() ȣ�� �� �������� ���� : " + list.size() + "��");
		System.out.println();
		
		// isEmpty() �Լ��� �����Ͱ� �����ϴ����� üũ�ϴ� �Լ�.
		if(list.isEmpty()) {
			System.out.println("�迭�� �����Ͱ� �����ϴ�.");
		} else {
			System.out.println("�迭�� �����Ͱ� �ֽ��ϴ�.");
		}
		
		// clear()�� ��� �����͸� �����ϴ� �Լ�.
		list.clear();
		
		if(list.isEmpty()) {
			System.out.println("�迭�� �����Ͱ� �����ϴ�.");
		} else {
			System.out.println("�迭�� �����Ͱ� �ֽ��ϴ�.");
		}
	}
}
