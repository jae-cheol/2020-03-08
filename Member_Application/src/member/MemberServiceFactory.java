package member;

import member.service.MemberService;

public class MemberServiceFactory {

	private static MemberService service = null;	// static이니 계속 덮어쓰기되서
	
	public static MemberService getInstance() {
		
		if(service == null)
			service = new MemberService();
		
		return service;
	}	
}
