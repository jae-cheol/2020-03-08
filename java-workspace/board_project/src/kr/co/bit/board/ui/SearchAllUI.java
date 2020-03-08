package kr.co.bit.board.ui;

import java.util.List;

import kr.co.bit.board.vo.BoardVO;

public class SearchAllUI extends BaseUI {

	@Override
	public void execute() throws Exception {

		List<BoardVO> list = service.selectBoard();

		System.out.println("�Խù� ��� : " + list.size() + "��");
		System.out.println("-------------------------------------------------------");
		System.out.println("��ȣ\t�۾���\t�����\t����");
		System.out.println("-------------------------------------------------------");
		for(BoardVO board : list) {
			System.out.println(board.getNo() + "\t" + board.getWriter() + "\t"
					+ board.getRegDate() + "\t" + board.getTitle());
		}
		if(list.isEmpty()) {
			System.out.println("��ȸ�� �Խù��� �����ϴ�.");
		}
		System.out.println("-------------------------------------------------------");
	}

	
}










