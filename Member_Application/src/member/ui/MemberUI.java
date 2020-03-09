package member.ui;

public class MemberUI extends BaseUI {

	@Override
	public void execute() throws Exception {
		while (true) {
			int type = menu();

			IBoardUI ui = null;
			switch (type) {
			case 1:
				ui = new ApplicationUI();
				break;
//			case 2:
//				ui = new LoginUI();
//				break;
			case 0:
				ui = new ExitUI();
				break;
			}
			if (ui != null)
				ui.execute();
			else
				System.out.println("�׸��� �߸������ϼ̽��ϴ�.");
		}
	}

	private int menu() {
		System.out.println("------------------------------------------");
		System.out.println("\tä�� ���α׷�");
		System.out.println("------------------------------------------");
		System.out.println("1. ȸ������");
		System.out.println("2. �α���");
		System.out.println("0. ����");
		System.out.println("------------------------------------------");
		int type = scanInt("�޴��� ���ϴ� �׸��� �����ϼ��� : ");

		return type;
	}

}