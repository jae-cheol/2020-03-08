package kr.co.bit.board.ui;

import java.util.List;

import kr.co.bit.board.vo.BoardVO;

public class SearchAllUI extends BaseUI {

	@Override
	public void execute() throws Exception {

		List<BoardVO> list = service.selectBoard();

		System.out.println("게시물 목록 : " + list.size() + "개");
		System.out.println("-------------------------------------------------------");
		System.out.println("번호\t글쓴이\t등록일\t제목");
		System.out.println("-------------------------------------------------------");
		for(BoardVO board : list) {
			System.out.println(board.getNo() + "\t" + board.getWriter() + "\t"
					+ board.getRegDate() + "\t" + board.getTitle());
		}
		if(list.isEmpty()) {
			System.out.println("조회할 게시물이 없습니다.");
		}
		System.out.println("-------------------------------------------------------");
	}

	
}










