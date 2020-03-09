package Serializable��transient;

import java.io.Serializable;

public class UserInfo implements Serializable {	// ����ȭ�� ���� �ʿ��� implements

	private String 	name;
	private transient int 	age;	// transient �� ��ü ����ȭ���� ���ܵ�.
	private String 	addr;
	
	public UserInfo() {
		super();
	}

	public UserInfo(String name, int age, String addr) {
		super();
		this.name = name;
		this.age = age;
		this.addr = addr;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getAddr() {
		return addr;
	}

	public void setAddr(String addr) {
		this.addr = addr;
	}

	@Override
	public String toString() {
		return "UserInfo [name=" + name + ", age=" + age + ", addr=" + addr + "]";
	}

}
