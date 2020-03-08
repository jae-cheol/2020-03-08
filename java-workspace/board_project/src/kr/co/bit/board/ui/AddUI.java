package kr.co.bit.board.ui;

import kr.co.bit.board.vo.BoardVO;

public class AddUI extends BaseUI {

	@Override
	public void execute() throws Exception {

		String title = scanStr("등록할 제목을 입력하세요 : ");
		String writer = scanStr("등록할 글쓴이를 입력하세요 : ");
		
		BoardVO board = new BoardVO();
		board.setTitle(title);
		board.setWriter(writer);
		
		service.insertBoard(board);
		
		System.out.println("게시판 등록을 완료하였습니다.");
	}

	
}
