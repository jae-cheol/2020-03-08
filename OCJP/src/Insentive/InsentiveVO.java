package Insentive;

import java.io.Serializable;

public class InsentiveVO implements Serializable{
	private String name;
	private int price;
	
	public InsentiveVO() {
		super();
	}

	public InsentiveVO(String name, int price) {
		super();
		this.name = name;
		this.price = price;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}

	@Override
	public boolean equals(Object obj) {
		return super.equals(obj);
	}

	@Override
	public int hashCode() {
		return super.hashCode();
	}

	@Override
	public String toString() {
		return "성명 : "+this.name+"     금액 : " +this.price+ "원";
	}
}
