package kr.co.bit.board.ui;

import kr.co.bit.board.vo.BoardVO;

public class SearchOneUI extends BaseUI {

	@Override
	public void execute() throws Exception {

		int no = scanInt("��ȸ�� �۹�ȣ�� �Է��ϼ��� : ");
		
		BoardVO board = new BoardVO();
		board.setNo(no);
		board = service.selectOneBoard(board);
		
		System.out.println("-----------------------------------------------");
		if(board == null) {
			System.out.println("�۹�ȣ [" + no + "] �Խñ��� �������� �ʽ��ϴ�.");
			return;
		}
		System.out.println("\t��   ȣ : " + board.getNo());
		System.out.println("\t��   �� : " + board.getTitle());
		System.out.println("\t�۾��� : " + board.getWriter());
		System.out.println("\t����� : " + board.getRegDate());
		System.out.println("-----------------------------------------------");
		
		
	}

}
