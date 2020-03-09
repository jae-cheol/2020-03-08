package 상속;

public class ConversationBook extends Book {
	private String language;

	public ConversationBook() {super();}
	public ConversationBook(int iSBN, String author, String bookTitle) {
		super(iSBN, author, bookTitle);
	}
	public ConversationBook(int id, String explain, String productor, int price) {
		super(id, explain, productor, price);
	}

	public ConversationBook(String language) {
		super();
		this.language = language;
	}

	public void write() {
		super.write();
		this.language = Util.inputStr("언어>>");
	}
	
	public void info() {
		super.info();
		System.out.println("언어>>" + language);
	}
	
	public String getLanguage() {return language;}
	public void setLanguage(String language) {this.language = language;}
}