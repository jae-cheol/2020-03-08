package contents.interfacee.ex2;

public class SamsungTV implements TV {
	private boolean muteToggle = false;
	private int volumeSize = 10;
	private int currentVoulumeSize;
	
	public SamsungTV() { System.out.println("�ＺTV�� �����Ͽ����ϴ�."); }
	@Override
	public void powerOn() { System.out.println("TV���� ON"); }
	@Override
	public void powerOff() { System.out.println("TV���� OFF"); }

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
			System.out.println("���Ұ� ����");
			volumeSize = currentVoulumeSize;
		} else {
			System.out.println("���Ұ���...");
			currentVoulumeSize = volumeSize;
			volumeSize = TV.MIN_VOLUME;		
		}
		muteToggle = !muteToggle;
	}
}