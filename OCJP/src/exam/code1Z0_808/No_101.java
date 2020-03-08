package exam.code1Z0_808;

import java.io.IOException;

class CheckingAccount {
	public int amount;
	public CheckingAccount(int amount) {
		this.amount = amount;
	}
	public int getAmount() {
		return amount;
	}
	public void changeAmount(int x) {
		amount += x;
	}
}

public class No_101 {
	public static void main(String[] args) {
		CheckingAccount acct = new CheckingAccount((int)(Math.random()*1000));
		//acct.amount = 0;
		//acct.changeAmount(-acct.amount);
		//acct.changeAmount(-acct.getAmount());
		System.out.println(acct.getAmount());
	}
}
