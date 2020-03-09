package member;

import member.service.MemberService;

public class MemberServiceFactory {

	private static MemberService service = null;	// static�̴� ��� �����Ǽ�
	
	public static MemberService getInstance() {
		
		if(service == null)
			service = new MemberService();
		
		return service;
	}	
}