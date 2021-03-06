package contents.interfacee.ex2;

public class SamsungTV implements TV {
	private boolean muteToggle = false;
	private int volumeSize = 10;
	private int currentVoulumeSize;
	
	public SamsungTV() { System.out.println("삼성TV를 구매하였습니다."); }
	@Override
	public void powerOn() { System.out.println("TV전원 ON"); }
	@Override
	public void powerOff() { System.out.println("TV전원 OFF"); }

	@Override
	public void volumeUp() {
		System.out.println("VOLUME UP");
		if(muteToggle) {
			muteToggle = false;
			volumeSize = currentVoulumeSize;
		}
		volumeSize++;
	}

	@Override
	public void volumeDown() { System.out.println("VOLUME DOWN"); }
	@Override
	public void channelUp() { System.out.println("CHANNEL UP"); }
	@Override
	public void channelDown() { System.out.println("CHANNEL DOWN"); }

	@Override
	public void mute() {
		if(muteToggle) {
			System.out.println("음소거 해제");
			volumeSize = currentVoulumeSize;
		} else {
			System.out.println("음소거중...");
			currentVoulumeSize = volumeSize;
			volumeSize = TV.MIN_VOLUME;		
		}
		muteToggle = !muteToggle;
	}
}