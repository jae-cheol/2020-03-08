package 자바입출력.Serializable과transient;

import java.io.Serializable;

public class UserInfo implements Serializable {	// 직렬화를 위해 필요한 implements

	private String 	name;
	private transient int 	age;	// transient 는 객체 직렬화에서 제외됨.
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
