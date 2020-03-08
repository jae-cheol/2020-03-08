package kr.co.bit.board.service;

import java.util.List;

import kr.co.bit.board.dao.BoardDAO;
import kr.co.bit.board.vo.BoardVO;

public class BoardService {

	private BoardDAO dao;
	private static int no = 1;
	
	public BoardService() {
		dao = new BoardDAO();
	}

	public void insertBoard(BoardVO board) {
		// ����� �Խù� ��ȣ, ������� BoardVO��ü�� setting
		dao.insertBoard(board);
	}
	
	public List<BoardVO> selectBoard() throws Exception {

		List<BoardVO> list = dao.selectBoard();
		return list;
	}
	
	public BoardVO selectOneBoard(BoardVO board) {
		BoardVO result = dao.selectOneBoard(board);
		return result;
	}
}






