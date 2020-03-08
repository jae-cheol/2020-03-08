package kr.co.bit.board.dao;

import java.util.ArrayList;
import java.util.List;

import kr.co.bit.board.vo.BoardVO;

public class BoardDAO2 {

	private List<BoardVO> list;
	
	public BoardDAO2() {
		list = new ArrayList<>();
	}

	/**
	 * 게시글을 등록하는 메소드
	 * @param 게시글VO
	 */
	public void insertBoard(BoardVO board)  {
		list.add(board);
		System.out.println("dao에서 게시글을 등록..." + list.size() + "개");
	}
	
	/**
	 * 전체게시물을 조회하는 메소드
	 */
	public List<BoardVO> selectBoard() {
		
		return list;
	}
	
}








