package member.ui;

public class ExitUI extends BaseUI {
	
	@Override
	public void execute() throws Exception {

		System.out.println();
		System.out.println("\t게시판 프로그램을 종료합니다.");
		System.exit(0);
	}
}