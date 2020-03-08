package contents.interfacee.ex2;

public class LGTV implements TV {
	private boolean power;
	private String  modelName;
	private int     volumeSize;
	private int     channelNo;
	
	public LGTV() {
		System.out.println("LGTV를 구매하였습니다.");
		power = false;
		modelName = "LGTV";
		volumeSize = 10;
		channelNo = 3;
	}
	
	@Override
	public void powerOn() { power = true;
		System.out.println("TV전원을 켰습니다.");
	}

	@Override
	public void powerOff() { power = false;
		System.out.println("TV전원을 껐습니다.");
	}

	@Override
	public void volumeUp() {
		System.out.println("음량을 올립니다.");
		if(volumeSize < TV.MAX_VOLUME)
			volumeSize++;
		info();
	}

	@Override
	public void volumeDown() {
		System.out.println("음량을 내립니다.");
		if(volumeSize > TV.MIN_VOLUME)
			volumeSize--;
		info();
	}

	@Override
	public void channelUp() {
		System.out.println("채널을 올립니다.");
		channelNo++;
//		channelNo = ++channelNo % 100;
		info();
	}

	@Override
	public void channelDown() {
		System.out.println("채널을 내립니다.");
		channelNo--;
		info();
	}

	@Override
	public void mute() { volumeSize = TV.MIN_VOLUME;
		info();
	}

	private void info() { 
		System.out.println("채널번호 : " + channelNo + ", 음량크기 : " + volumeSize);
	}
}