package com.tyn.edu;

public class Account {
	int balance = 1000;
	
	public void withdraw(int money) {
		if (balance >= money) {
			try {
				Thread.sleep(1000);
			} catch(Exception e) {}
			balance -= money;
		}
	} // withdraw
}

class RunnalbeEx24 implements Runnable {
	Account acc = new Account();
	
	public void run() {
		while(acc.balance > 0) {
			// 100, 200, 300 중의 한 값을 임의로 선택해서 출금
			int money = (int)(Math.random() * 3 + 1) * 100;
			acc.withdraw(money);
			System.out.println("balance : " + acc.balance);
		}
	} // run()
}
