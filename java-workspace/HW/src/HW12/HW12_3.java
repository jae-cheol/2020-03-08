package HW12;

import java.util.Random;

/*
 * 3. ȫ�浿�� ���¿��� ȫ�浿, ��Ӵ�, �ƹ����� ���� ���, �Ա�, ���, �Ա��� �Ѵٰ� �������� ������ ����� ���̴� �ڵ带 �ۼ��Ͻÿ�.

class Account {
   private String name;
   private int money;
}

class User {
  String name;
  Account account;
}

public static void main(String[] args) {
  Account ac = new Account("ȫ�浿", 10000);
  new User("ȫ�浿", ac);
  new User("��Ӵ�", ac);
  new User("�ƹ���", ac);
 */
class Account {
	private String name;
	private int money;

	public void deposit(String name, int money) { // �Ա�
		System.out.println(name + "������ " + money + "���� �Ա��ϼ̽��ϴ�.");
		this.money += money;
		System.out.println("���� �ܾ��� " + this.money + "���Դϴ�.");
	}

	public synchronized void withdraw(String name, int money) {
		System.out.println("��ݱݾ� : " + money + "��");
		if (this.money >= money) {
			this.money -= money;
			System.out.println("���� �ܾ��� " + this.money + "���Դϴ�.");
		} else {
			System.out.println("= > �ܾ��� �����Ͽ� ����� �� �� �����ϴ�.");
			System.out.println("���� �ܾ��� " + this.money + "���Դϴ�.");
		}
	}

	public int Ran() {
		Random r = new Random();
		int num = (r.nextInt(10) + 1) * 1000;
		return num;
	}

	public synchronized void my() {
		deposit("ȫ�浿", Ran());
		withdraw("ȫ�浿", Ran());
		deposit("ȫ�浿", Ran());
		withdraw("ȫ�浿", Ran());
	}

	public synchronized void father() {
		deposit("�ƹ���", Ran());
		deposit("�ƹ���", Ran());
		withdraw("�ƹ���", Ran());
		withdraw("�ƹ���", Ran());
	}

	public synchronized void mother() {
		deposit("��Ӵ�", Ran());
		deposit("��Ӵ�", Ran());
		withdraw("��Ӵ�", Ran());
		withdraw("��Ӵ�", Ran());
	}

	public Account() {
	}

	public Account(String name, int money) {
		this.name = name;
		this.money = money;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getMoney() {
		return money;
	}

	public void setMoney(int money) {
		this.money = money;
	}

}

class User extends Thread {
	private Account account;
	private int type;

	public User(Account account, int type) {
		this.account = account;
		this.type = type;
	}

	@Override
	public void run() {
		switch (type) {
		case 1:
			account.my();
			break;
		case 2:
			account.father();
			break;
		case 3:
			account.mother();
			break;
		}
	}
}

public class HW12_3 {

	public static void main(String[] args) {
		Account ac = new Account("ȫ�浿", 10000);
//		new User("ȫ�浿", ac);
//		new User("��Ӵ�", ac);
//		new User("�ƹ���", ac);
		new User(ac, 1).start();
		new User(ac, 2).start();
		new User(ac, 3).start();
	}
}
