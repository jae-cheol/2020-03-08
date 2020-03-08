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
		// ���ϱ�
		return new Money(this.amount + money.amount);
	}

	public Money minus(Money money) {
		// ����
		return new Money(this.amount - money.amount);
	}

	public Money multiply(Money money) {
		// ���ϱ�
		return new Money(this.amount * money.amount);
	}

	public Money devide(Money money) {
		// ������
		return new Money(this.amount / money.amount);
	}
}
