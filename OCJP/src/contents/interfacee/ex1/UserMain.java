package contents.interfacee.ex1;

public class UserMain {
	public static void main(String[] args) {
		LGTV lg = new LGTV();
		lg.powerOn();
		lg.channelDown();
		lg.channelUp();
		lg.channelUp();
		lg.volumeDown();
		lg.volumeUp();
		lg.powerOff();
		
		SamsungTV sam = new SamsungTV();
		sam.turnOn();
		sam.soundUp();
		sam.soundDown();
		sam.channelUp();
		sam.channelDown();
		sam.turnOff();
	}
}