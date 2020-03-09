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
		// ����� �Խù� ��ȣ, ������� BoardVO��ü�� setting
		board.setRegDate(new SimpleDateFormat("yyyy-MM-dd").format(new Date()));
		board.setNo(no++);
		dao.insertBoard(board);
	}
	
	public List<BoardVO> selectBoard() throws Exception {

		List<BoardVO> list = dao.selectBoard();
		return list;
	}
}






