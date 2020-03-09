package HW12;

import java.util.Random;

/*
 * 3. 홍길동의 계좌에서 홍길동, 어머니, 아버지가 각각 출금, 입금, 출금, 입금을 한다고 했을때의 다음의 결과를 보이는 코드를 작성하시오.

class Account {
   private String name;
   private int money;
}

class User {
  String name;
  Account account;
}

public static void main(String[] args) {
  Account ac = new Account("홍길동", 10000);
  new User("홍길동", ac);
  new User("어머니", ac);
  new User("아버지", ac);
 */
class Account {
	private String name;
	private int money;

	public void deposit(String name, int money) { // 입금
		System.out.println(name + "고객님이 " + money + "원을 입금하셨습니다.");
		this.money += money;
		System.out.println("현재 잔액은 " + this.money + "원입니다.");
	}

	public synchronized void withdraw(String name, int money) {
		System.out.println("출금금액 : " + money + "원");
		if (this.money >= money) {
			this.money -= money;
			System.out.println("현재 잔액은 " + this.money + "원입니다.");
		} else {
			System.out.println("= > 잔액이 부족하여 출금을 할 수 없습니다.");
			System.out.println("현재 잔액은 " + this.money + "원입니다.");
		}
	}

	public int Ran() {
		Random r = new Random();
		int num = (r.nextInt(10) + 1) * 1000;
		return num;
	}

	public synchronized void my() {
		deposit("홍길동", Ran());
		withdraw("홍길동", Ran());
		deposit("홍길동", Ran());
		withdraw("홍길동", Ran());
	}

	public synchronized void father() {
		deposit("아버지", Ran());
		deposit("아버지", Ran());
		withdraw("아버지", Ran());
		withdraw("아버지", Ran());
	}

	public synchronized void mother() {
		deposit("어머니", Ran());
		deposit("어머니", Ran());
		withdraw("어머니", Ran());
		withdraw("어머니", Ran());
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
		Account ac = new Account("홍길동", 10000);
//		new User("홍길동", ac);
//		new User("어머니", ac);
//		new User("아버지", ac);
		new User(ac, 1).start();
		new User(ac, 2).start();
		new User(ac, 3).start();
	}
}
