package Util;

import Interface.IService;
import ����.LoginService;
import ����.MemberService;

public class ServiceFactory {
	private static MemberService Memberservice = null;
	private static LoginService loginService = null;
	
	public static IService<?> getInstance(String className) {
		switch(className){
		case "MemberService" :
			if(Memberservice == null) Memberservice = new MemberService();
			return Memberservice;
		case "LoginService" : 
			if(loginService == null) loginService = new LoginService();
			return loginService;
		default : 
			return null;
		}
	}
}
