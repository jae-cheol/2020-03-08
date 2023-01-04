package 동규_12;

import java.util.Random;

interface Constants{
	public static final int NUM_OF_CENTER = 5;
	public static final int NUM_OF_CALL = 10;
	public static final int MAX_MONEY = 10000;
	public static final int MIN_MONEY = 1000;
	public static final int DEPOSIT = 0;
	public static final int WITHDRAW = 1;
}

class Util{
	public static Random ran = new Random();
}

class Money{
	private int money;
	public synchronized void giveMoney(int money){
		this.money += money;
	}
	public Money(int money) {this.money = money;}
	public int getMoney() {return money;}
	public void setMoney(int money) {this.money = money;}
}

class CallCenter extends Thread{
	private int centerNum;
	private int total = 0;
	private Money money;
	public CallCenter(int centerNum, Money money) {

		this.centerNum = centerNum;
		this.money = money;
	}
	@Override
	public void run() {
		for(int i=0;i<Constants.NUM_OF_CALL;i++){
			int mon = Util.ran.nextInt(Constants.MAX_MONEY-Constants.MIN_MONEY+1) + Constants.MIN_MONEY;
			total += mon;
			System.out.println( centerNum + "번 콜센터 : " + mon + "원을 받았습니다.");
			money.giveMoney(mon);
		}
		System.out.println(centerNum + "콜센터 총 : " + total + "원을 받았습니다.");
	}
}

public class CallCenterMain {
	public static void main(String[] args){
		Money m = new Money(0);
		CallCenter[] calls = new CallCenter[Constants.NUM_OF_CENTER];
		for(int i=0;i<Constants.NUM_OF_CENTER;i++) calls[i] = new CallCenter(i+1, m);
		for(int i=0;i<Constants.NUM_OF_CENTER;i++) calls[i].start();
		for(int i=0;i<Constants.NUM_OF_CENTER;i++){
			try { calls[i].join(); } 
			catch (InterruptedException e) {
				System.out.println("센터 사고남");
				System.exit(0);
			}
		}
		System.out.println("국민들이 보내주신 성금 총액 : " + m.getMoney());
	}
}







