package kr.co.bit.board.ui;

public class BoardUI extends BaseUI {

	@Override
	public void execute() throws Exception {
		while (true) {
			int type = menu();

			IBoardUI ui = null;
			switch (type) {
			case 1:
				ui = new SearchAllUI();
				break;
			case 2:
				ui = new SearchOneUI();
				break;
			case 3:
				ui = new AddUI();
				break;
			case 4:
				ui = new UpdateUI();
				break;
			case 5:
				ui= new DeleteUI();
				break;
			case 0:
				ui = new ExitUI();
				break;
			}
			if(ui != null)
				ui.execute();
			else
				System.out.println("�׸��� �߸������ϼ̽��ϴ�.");
		}
	}

	private int menu() {
		System.out.println("------------------------------------------");
		System.out.println("\t�Խ��� ���� ���α׷�");
		System.out.println("------------------------------------------");
		System.out.println("1. ��ü �Խñ� ��ȸ");
		System.out.println("2. �۹�ȣ ��ȸ");
		System.out.println("3. ���� ���");
		System.out.println("4. �Խñ� ����");
		System.out.println("5. �Խñ� ����");
		System.out.println("0. ����");
		System.out.println("------------------------------------------");
		int type = scanInt("�޴��� ���ϴ� �׸��� �����ϼ��� : ");
		
		return type;
	}
	
}
