package member.ui;

import java.util.Scanner;

import member.MemberServiceFactory;
import member.service.MemberService;


public abstract class BaseUI implements IBoardUI {
	// private Scanner sc = new Scanner(System.in);
    private Scanner sc;
    protected MemberService service;

    public BaseUI(){
    	sc = new Scanner(System.in);
    	service = MemberServiceFactory.getInstance();
    }

    protected String scanStr(String msg){
        System.out.print(msg);
        return sc.nextLine();
    }

    protected int scanInt(String msg){
    	System.out.print(msg);
        return Integer.parseInt(sc.nextLine());
    }

}
