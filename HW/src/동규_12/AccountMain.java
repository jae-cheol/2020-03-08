package ����_12;

class Account {
	private String name;
	private int money;
	public Account(String name, int money) {
		super();
		this.name = name;
		this.money = money;
	}
	@Override
	public String toString() { return "Account [name=" + name + ", money=" + money + "]"; }
	public String getName() {
		return name;
	}
	public synchronized void deposit(int money){
		this.money += money;
		System.out.println("���� �ܾ��� " + this.money + "�� �Դϴ�.");
	}
	public synchronized void withdraw(int money){
		if(this.money - money < 0){
			System.out.println("��� �ݾ� : " + money + "==> �ܾ��� �����Ͽ� ����� �� �� �����ϴ�.");
			System.out.println("���� �ܾ� : " + this.money);
			return;
		}
		this.money -= money;
		System.out.println("���� �ܾ��� " + this.money + "�� �Դϴ�.");
	}
}

class User extends Thread{
	String name;
	Account account;
	public User(String name, Account account) {
		this.name = name;
		this.account = account;
	}
	@Override
	public String toString() { return "User [name=" + name + ", account=" + account + "]"; }
	
	@Override
	public void run() {
		for(int i=0;i<5;i++){
			int money = Util.ran.nextInt(Constants.MAX_MONEY-Constants.MIN_MONEY+1) + Constants.MIN_MONEY;
			int flag = Util.ran.nextInt(2);
			switch(flag){
			case Constants.DEPOSIT :
				System.out.println(name + "������ " + money + " ���� �Ա� �ϼ̽��ϴ�.");
				account.deposit(money);
				break;
			case Constants.WITHDRAW :
				System.out.println(name + "������ " + money + " ��� �ϼ̽��ϴ�.");
				account.withdraw(money);
			break;
			}
		}
	}
}

public class AccountMain {
	public static void main(String[] args) {
		  Account ac = new Account("ȫ�浿", 10000);
		  new User("ȫ�浿", ac).start();
		  new User("��Ӵ�", ac).start();
		  new User("�ƹ���", ac).start();
	}
}
