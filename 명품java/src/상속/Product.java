package ���;

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
		this.explain = Util.inputStr("��ǰ ����>>");
		this.productor = Util.inputStr("������>>");
		this.price = Util.inputInt("����>>");
	}
	
	public void info() {
		System.out.println("��ǰID>>" + id);
		System.out.println("��ǰ ����>>" + explain);
		System.out.println("������>>" + productor);
		System.out.println("����>>" + price);
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