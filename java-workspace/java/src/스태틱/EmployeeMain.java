package ����ƽ;

/*
 * �� �����ؾ� �ϴ°͸� static�� �����.
 * �̸����� ���� �����ϴ� ���� �ƴϱ� ������ static�� ���� �ȵ�.
 */
class Employee {
	String name;	// �����
	static int empCount;	// �ѻ����
	// ������
	Employee(String name) {
		this.name = name;
		Employee.empCount++;	// this.empCount++; �� ������ ������, static�̶�°��� �����ֱ� ���� �̷��� �ؾߵ�.
	}
	void info() {
		System.out.println("����� : " + name);
//		System.out.println("���ݱ��� �Ի��� ����� : " + Employee.empCount + "��");
		Employee.empCountInfo();
	}
	// static �޼ҵ� �ȿ��� non_static������ ��� �Ұ�
	static void empCountInfo() {
		System.out.println("�ѻ���� : " + Employee.empCount + "��");
	}
}

public class EmployeeMain {
	public static void main(String[] args) {
		Employee e = new Employee("ȫ�浿");
		e.info();
		Employee e2 = new Employee("��浿");
		e2.info();
		Employee e3 = new Employee("�ڱ浿");
		e3.info();
		Employee e4 = new Employee("�ֱ浿");		
		e4.info();
		
	}
}
