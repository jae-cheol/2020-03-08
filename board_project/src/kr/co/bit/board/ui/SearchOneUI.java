package kr.co.bit.board.ui;

import kr.co.bit.board.vo.BoardVO;

public class SearchOneUI extends BaseUI {

	@Override
	public void execute() throws Exception {

		int no = scanInt("조회할 글번호를 입력하세요 : ");
		
		BoardVO board = new BoardVO();
		board.setNo(no);
		board = service.selectOneBoard(board);
		
		System.out.println("-----------------------------------------------");
		if(board == null) {
			System.out.println("글번호 [" + no + "] 게시글은 존재하지 않습니다.");
			return;
		}
		System.out.println("\t번   호 : " + board.getNo());
		System.out.println("\t제   목 : " + board.getTitle());
		System.out.println("\t글쓴이 : " + board.getWriter());
		System.out.println("\t등록일 : " + board.getRegDate());
		System.out.println("-----------------------------------------------");
		
		
	}

}
