package kr.co.bit.board.service;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import kr.co.bit.board.dao.BoardDAO;
import kr.co.bit.board.vo.BoardVO;

public class BoardService2 {

	private BoardDAO dao;
	private static int no = 1;
	
	public BoardService2() {
		dao = new BoardDAO();
	}

	public void insertBoard(BoardVO board) {
		// 등록할 게시물 번호, 등록일을 BoardVO객체에 setting
		board.setRegDate(new SimpleDateFormat("yyyy-MM-dd").format(new Date()));
		board.setNo(no++);
		dao.insertBoard(board);
	}
	
	public List<BoardVO> selectBoard() throws Exception {

		List<BoardVO> list = dao.selectBoard();
		return list;
	}
}






