package contents.interfacee.ex1;

public class LGTV {
	private boolean power;
	private int 	channelNo;
	public LGTV() { System.out.println("LGTV를 구매하였습니다."); }
	
	public void powerOn() {
		power = true;
		System.out.println("TV전원을 켰습니다.");
	}
	public void powerOff() {
		power = false;
		System.out.println("TV전원을 껐습니다.");
	}
	
	public void channelUp() { System.out.println("채널번호를 올렸습니다."); }
	public void channelDown() { System.out.println("채널번호를 내렸습니다."); }
	public void volumeUp() { System.out.println("음량을 높입니다."); }
	public void volumeDown() { System.out.println("음량을 내립니다."); }
}