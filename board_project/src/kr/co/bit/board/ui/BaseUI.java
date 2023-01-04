package kr.co.bit.board.ui;

import java.util.Scanner;

import kr.co.bit.board.BoardServiceFactory;
import kr.co.bit.board.service.BoardService;

public abstract class BaseUI implements IBoardUI {
	// private Scanner sc = new Scanner(System.in);
    private Scanner sc;
    protected BoardService service;

    public BaseUI(){
    	sc = new Scanner(System.in);
    	service = BoardServiceFactory.getInstance();
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
// 무조건 스트링으로 받고 --> 정수로 바꿔줌
	/*
	 * String str = sc.nextLine();
	 * int num = Integer.parseInt(str);
	 * 		   = sc.valuable(str);
	 */
