package ���;

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
		this.bookTitle = Util.inputStr("å ����>>");
		this.author = Util.inputStr("����>>");
		this.iSBN = Util.inputInt("ISBN>>");
	}
	
	public void info() {
		super.info();
		System.out.println("ISBN>>" + iSBN);
		System.out.println("����>>" + author);
		System.out.println("å ����>>" + bookTitle);
	}
	
	public int getiSBN() { return iSBN; }
	public void setiSBN(int iSBN) { this.iSBN = iSBN; }
	public String getAuthor() { return author; }
	public void setAuthor(String author) { this.author = author; }
	public String getBookTitle() { return bookTitle; }
	public void setBookTitle(String bookTitle) { this.bookTitle = bookTitle; }
}