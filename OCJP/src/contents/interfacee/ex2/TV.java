package contents.interfacee.ex2;
/*
 * �������̽� ���� �Լ��� public abstract ���� ����.(2���߿� �Ѱ��� �����ص� ��.) - �߻�޼ҵ常 ���尡��.
 * 		      ��������� public static final ���� ����.(3���߿� ��� �����ص� ��.) - ��������� ���尡��.
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

	// ���������� default �� �ƴ�.
	default public void copyright() { 
		System.out.println("��� ���۱��� TVȸ�翡 �ͼӵ˴ϴ�.");
	}
}