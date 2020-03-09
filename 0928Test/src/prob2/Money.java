package prob2;

public class Money {
	private int amount;
	
	public Money(int amount) {
		this.amount = amount;
	}

	public int getAmount() {
		return amount;
	}

	@Override
	public boolean equals(Object obj) {
		Money m;
		if(obj instanceof Money) {
			m = (Money)obj;
			return this.amount == m.amount;
		}else return false;
	
	}

	// public int add(int num) {
	// this.amount += num;
	// return this.amount;
	// }
	public Money add(Money money) {
		// 더하기
		return new Money(this.amount + money.amount);
	}

	public Money minus(Money money) {
		// 빼기
		return new Money(this.amount - money.amount);
	}

	public Money multiply(Money money) {
		// 곱하기
		return new Money(this.amount * money.amount);
	}

	public Money devide(Money money) {
		// 나누기
		return new Money(this.amount / money.amount);
	}
}
