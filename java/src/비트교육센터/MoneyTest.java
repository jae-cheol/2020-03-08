package 비트교육센터;

public class MoneyTest {

	public static void main(String[] args) {
		Money five  = new Money( 5 );
        Money two   = new Money( 2 );
        Money three = new Money( 3 );
        Money ten   = new Money( 10 );
        System.out.println(five.getAmount());
        System.out.println(two.getAmount());
        System.out.println(three.getAmount());
        System.out.println(ten.getAmount());
        System.out.println(ten.add(three));
        if(    five.equals( two.add( three ) )
            && three.equals( five.minus( two ) )
            && ten.equals( five.multiply( two ) )
            && two.equals( ten.devide( five ) ) )  {
            System.out.println( "Money Class 구현을 완료 하였습니다." );
        }
	}
}

class Money {
	private int amount;

	Money() {
		
	}
	
	Money(int amount) {
		this.amount = amount; 
	}
	
	public int getAmount() {
		return this.amount;
	}
	public void setAmount(int amount) {
		this.amount = amount;
	}
	
	// 자신의 금액(amount)과 인자로 넘어온 Money 객체의 금액(amount)을 계산하고, 계산된 금액으로 새로운 Money 객체로 생성하여 리턴한다. 
	public Money add(Money money) {
		int res = this.amount + money.getAmount();
		return new Money(res);
	} 
	public Money minus(Money money) {
		int res = this.amount - money.getAmount();
		return new Money(res);
	} 
	public Money multiply(Money money) {
		int res = this.amount * money.getAmount();
		return new Money(res);
	} 
	public Money devide(Money money) {
		int res = this.amount / money.getAmount();
		return new Money(res);
	}

	public boolean equals(Object money) {
		if(money instanceof Money) {
			if(this.amount == ((Money) money).getAmount()) {
				return true;
			}
		}
			
		return false;
	}
}