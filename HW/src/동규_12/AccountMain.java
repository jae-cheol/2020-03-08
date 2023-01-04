package 동규_12;

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
		System.out.println("현재 잔액은 " + this.money + "원 입니다.");
	}
	public synchronized void withdraw(int money){
		if(this.money - money < 0){
			System.out.println("출금 금액 : " + money + "==> 잔액이 부족하여 출금을 할 수 없습니다.");
			System.out.println("현재 잔액 : " + this.money);
			return;
		}
		this.money -= money;
		System.out.println("현재 잔액은 " + this.money + "원 입니다.");
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
				System.out.println(name + "고객님이 " + money + " 원을 입금 하셨습니다.");
				account.deposit(money);
				break;
			case Constants.WITHDRAW :
				System.out.println(name + "고객님이 " + money + " 출금 하셨습니다.");
				account.withdraw(money);
			break;
			}
		}
	}
}

public class AccountMain {
	public static void main(String[] args) {
		  Account ac = new Account("홍길동", 10000);
		  new User("홍길동", ac).start();
		  new User("어머니", ac).start();
		  new User("아버지", ac).start();
	}
}
