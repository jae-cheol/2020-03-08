package contents.interfacee.ex2;

public class UserMain {

	public static void main(String[] args) {
		
		TV tv = new LGTV();
		tv.powerOn();
		tv.channelUp();
		tv.volumeDown();
		tv.mute();
		tv.volumeUp();
		tv.volumeUp();
		tv.channelDown();
		tv.powerOff();
		tv.copyright();
		System.out.println();
		
		tv = new SamsungTV();
		tv.powerOn();
		tv.channelUp();
		tv.volumeDown();
		tv.mute();
		tv.volumeUp();
		tv.volumeUp();
		tv.channelDown();
		tv.powerOff();
		System.out.println();
	}
}