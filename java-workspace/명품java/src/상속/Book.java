package 惑加;

public class Book extends Product {
	private int iSBN;
	private String author;
	private String bookTitle;

	public Book() {super();}
	public Book(int id, String explain, String productor, int price) {
		super(id, explain, productor, price);
	}
	
	public Book(int iSBN, String author, String bookTitle) {
		super();
		this.iSBN = iSBN;
		this.author = author;
		this.bookTitle = bookTitle;
	}
	
	public void write() {
		super.write();
		this.bookTitle = Util.inputStr("氓 力格>>");
		this.author = Util.inputStr("历磊>>");
		this.iSBN = Util.inputInt("ISBN>>");
	}
	
	public void info() {
		super.info();
		System.out.println("ISBN>>" + iSBN);
		System.out.println("历磊>>" + author);
		System.out.println("氓 力格>>" + bookTitle);
	}
	
	public int getiSBN() { return iSBN; }
	public void setiSBN(int iSBN) { this.iSBN = iSBN; }
	public String getAuthor() { return author; }
	public void setAuthor(String author) { this.author = author; }
	public String getBookTitle() { return bookTitle; }
	public void setBookTitle(String bookTitle) { this.bookTitle = bookTitle; }
}