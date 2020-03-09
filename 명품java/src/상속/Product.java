package 상속;

import java.util.Scanner;

public class Product {
	private int id;
	private String explain;
	private String productor;
	private int price;
	
	public Product() {super();}
	public Product(int id, String explain, String productor, int price) {
		super();
		this.id = id;
		this.explain = explain;
		this.productor = productor;
		this.price = price;
	}
	
	public void write() {
		this.explain = Util.inputStr("상품 설명>>");
		this.productor = Util.inputStr("생산자>>");
		this.price = Util.inputInt("가격>>");
	}
	
	public void info() {
		System.out.println("상품ID>>" + id);
		System.out.println("상품 설명>>" + explain);
		System.out.println("생산자>>" + productor);
		System.out.println("가격>>" + price);
	}
	
	public int getId() { return id; }
	public void setId(int id) {this.id = id;}
	public String getExplain() {return explain;}
	public void setExplain(String explain) {this.explain = explain;}
	public String getProductor() {return productor;}
	public void setProductor(String productor) {this.productor = productor;}
	public int getPrice() {return price;}
	public void setPrice(int price) {this.price = price;}
}