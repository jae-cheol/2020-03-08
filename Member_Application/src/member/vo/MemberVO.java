package member.vo;
/*
create table t_client (
  id  varchar2(30)
  , pw  varchar2(10) not null
  , name varchar2(20) not null
  , nick varchar2(20) not null
  , reg_date date default sysdate
  , constraint pk_t_client_id primary key(id)
);

 * 게시물 정보 클래스
 * VO : Value Object
 * DB에 대한 정보들 저장...
 * 
 */
public class MemberVO {
	private String id;
	private String pw;
	private String name;
	private String nick;
	private String regDate;
	public MemberVO() {}
	public MemberVO(String id, String pw, String name, String nick, String regDate) {
		super();
		this.id = id;
		this.pw = pw;
		this.name = name;
		this.nick = nick;
		this.regDate = regDate;
	}
	@Override
	public String toString() {
		return "MemberVO [id=" + id + ", pw=" + pw + ", name=" + name + ", nick=" + nick + ", regDate=" + regDate + "]";
	}
	public String getId() {return id;}
	public void setId(String id) {this.id = id;}
	public String getPw() {return pw;}
	public void setPw(String pw) {this.pw = pw;}
	public String getName() {return name;}
	public void setName(String name) {this.name = name;}
	public String getNick() {return nick;}
	public void setNick(String nick) {this.nick = nick;}
	public String getRegDate() {return regDate;}
	public void setRegDate(String regDate) {this.regDate = regDate;}
}
