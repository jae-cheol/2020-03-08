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
	 * �Խñ��� ����ϴ� �޼ҵ�
	 * @param �Խñ�VO
	 */
	public void insertBoard(BoardVO board)  {
		list.add(board);
		System.out.println("dao���� �Խñ��� ���..." + list.size() + "��");
	}
	
	/**
	 * ��ü�Խù��� ��ȸ�ϴ� �޼ҵ�
	 */
	public List<BoardVO> selectBoard() {
		
		return list;
	}
	
}








