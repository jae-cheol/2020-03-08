package kr.co.bit.board;

import kr.co.bit.board.service.BoardService;

public class BoardServiceFactory {

	private static BoardService service = null;	// static�̴� ��� �����Ǽ�
	
	public static BoardService getInstance() {
		
		if(service == null)
			service = new BoardService();
		
		return service;
	}	
}