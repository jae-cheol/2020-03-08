package kr.co.bit.board;

import kr.co.bit.board.service.BoardService;

public class BoardServiceFactory {

	private static BoardService service = null;	// static이니 계속 덮어쓰기되서
	
	public static BoardService getInstance() {
		
		if(service == null)
			service = new BoardService();
		
		return service;
	}	
}
