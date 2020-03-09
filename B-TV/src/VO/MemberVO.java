package VO;

public class MemberVO {
	private String id;
	private String pass;
	private String name;
	private String nick;
	private String regDate;
	@Override
	public String toString() {
		return "LoginVO [id=" + id + ", pass=" + pass + ", name=" + name + ", nick=" + nick + ", regDate=" + regDate
				+ "]";
	}
	public MemberVO(String id, String pass, String name, String nick, String regDate) {
		super();
		this.id = id;
		this.pass = pass;
		this.name = name;
		this.nick = nick;
		this.regDate = regDate;
	}
	public MemberVO(String id, String pass, String name, String nick) {this(id, pass, name, nick, "");}
	public MemberVO() {super();}
	public String getId() {return id;}
	public void setId(String id) {this.id = id;}
	public String getPass() {return pass;}
	public void setPass(String pass) {this.pass = pass;}
	public String getName() {return name;}
	public void setName(String name) {this.name = name;}
	public String getNick() {return nick;}
	public void setNick(String nick) {this.nick = nick;}
	public String getRegDate() {return regDate;}
	public void setRegDate(String regDate) {this.regDate = regDate;}
}
