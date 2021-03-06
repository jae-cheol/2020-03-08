package contents.interfacee.ex2;
/*
 * 인터페이스 안의 함수는 public abstract 생략 가능.(2개중에 한개만 생략해도 됨.) - 추상메소드만 저장가능.
 * 		      멤버변수는 public static final 생략 가능.(3개중에 몇개만 생략해도 됨.) - 상수변수만 저장가능.
 */
public interface TV {
	public static final int MIN_VOLUME = 0;
	/*public static final*/ int MAX_VOLUME = 70;
	
	/*public abstract*/ void powerOn();
	void powerOff();
	void volumeUp();
	void volumeDown();
	void channelUp();
	void channelDown();
	void mute();

	// 접근제한자 default 가 아님.
	default public void copyright() { 
		System.out.println("모든 저작권은 TV회사에 귀속됩니다.");
	}
}