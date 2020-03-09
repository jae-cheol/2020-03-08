package member;

import member.ui.MemberUI;

/*
create table t_client (
  id  varchar2(30)
  , pw  varchar2(10) not null
  , name varchar2(20) not null
  , nick varchar2(20) not null
  , reg_date date default sysdate
  , constraint pk_t_client_id primary key(id)
);
 */
public class ApplicationMain {
	public static void main(String[] args) {
		try {
    		new MemberUI().execute();
		} catch (Exception e) {
			e.printStackTrace();
		}
    }
}
