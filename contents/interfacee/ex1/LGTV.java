package contents.interfacee.ex1;

public class LGTV {
	private boolean power;
	private int 	channelNo;
	public LGTV() { System.out.println("LGTV�� �����Ͽ����ϴ�."); }
	
	public void powerOn() {
		power = true;
		System.out.println("TV������ �׽��ϴ�.");
	}
	public void powerOff() {
		power = false;
		System.out.println("TV������ �����ϴ�.");
	}
	
	public void channelUp() { System.out.println("ä�ι�ȣ�� �÷Ƚ��ϴ�."); }
	public void channelDown() { System.out.println("ä�ι�ȣ�� ���Ƚ��ϴ�."); }
	public void volumeUp() { System.out.println("������ ���Դϴ�."); }
	public void volumeDown() { System.out.println("������ �����ϴ�."); }
}