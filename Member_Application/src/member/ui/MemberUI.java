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
				System.out.println("항목을 잘못선택하셨습니다.");
		}
	}

	private int menu() {
		System.out.println("------------------------------------------");
		System.out.println("\t채팅 프로그램");
		System.out.println("------------------------------------------");
		System.out.println("1. 회원가입");
		System.out.println("2. 로그인");
		System.out.println("0. 종료");
		System.out.println("------------------------------------------");
		int type = scanInt("메뉴중 원하는 항목을 선택하세요 : ");

		return type;
	}

}
