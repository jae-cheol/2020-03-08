package 惑加;

public class CompactDisc extends Product {
	private String albumTitle;
	private String singer;
	
	public CompactDisc() {super();}
	public CompactDisc(int id, String explain, String productor, int price) {
		super(id, explain, productor, price);
	}
	public CompactDisc(String albumTitle, String singer) {
		super();
		this.albumTitle = albumTitle;
		this.singer = singer;
	}
	
	public void write() {
		super.write();
		this.albumTitle = Util.inputStr("举裹 力格>>");
		this.singer = Util.inputStr("啊荐>>");
	}
	
	public void info() {
		super.info();
		System.out.println("举裹 力格>>" + albumTitle);
		System.out.println("啊荐>>" + singer);
	}
	
	public String getAlbumTitle() {return albumTitle;}
	public void setAlbumTitle(String albumTitle) {this.albumTitle = albumTitle;}
	public String getSinger() {return singer;}
	public void setSinger(String singer) {this.singer = singer;}
}