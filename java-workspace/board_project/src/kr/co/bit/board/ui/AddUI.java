package kr.co.bit.board.ui;

import kr.co.bit.board.vo.BoardVO;

public class AddUI extends BaseUI {

	@Override
	public void execute() throws Exception {

		String title = scanStr("����� ������ �Է��ϼ��� : ");
		String writer = scanStr("����� �۾��̸� �Է��ϼ��� : ");
		
		BoardVO board = new BoardVO();
		board.setTitle(title);
		board.setWriter(writer);
		
		service.insertBoard(board);
		
		System.out.println("�Խ��� ����� �Ϸ��Ͽ����ϴ�.");
	}

	
}
