package contents.interfacee.ex2;

public class LGTV implements TV {
	private boolean power;
	private String  modelName;
	private int     volumeSize;
	private int     channelNo;
	
	public LGTV() {
		System.out.println("LGTV�� �����Ͽ����ϴ�.");
		power = false;
		modelName = "LGTV";
		volumeSize = 10;
		channelNo = 3;
	}
	
	@Override
	public void powerOn() { power = true;
		System.out.println("TV������ �׽��ϴ�.");
	}

	@Override
	public void powerOff() { power = false;
		System.out.println("TV������ �����ϴ�.");
	}

	@Override
	public void volumeUp() {
		System.out.println("������ �ø��ϴ�.");
		if(volumeSize < TV.MAX_VOLUME)
			volumeSize++;
		info();
	}

	@Override
	public void volumeDown() {
		System.out.println("������ �����ϴ�.");
		if(volumeSize > TV.MIN_VOLUME)
			volumeSize--;
		info();
	}

	@Override
	public void channelUp() {
		System.out.println("ä���� �ø��ϴ�.");
		channelNo++;
//		channelNo = ++channelNo % 100;
		info();
	}

	@Override
	public void channelDown() {
		System.out.println("ä���� �����ϴ�.");
		channelNo--;
		info();
	}

	@Override
	public void mute() { volumeSize = TV.MIN_VOLUME;
		info();
	}

	private void info() { 
		System.out.println("ä�ι�ȣ : " + channelNo + ", ����ũ�� : " + volumeSize);
	}
}