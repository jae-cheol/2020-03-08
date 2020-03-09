package kr.co.bit.pokemon.ui;

public class PokemonUI extends BaseUI {

	@Override
	public void execute() throws Exception {
		while (true) {
			int type = menu();

			IPokemonUI ui = null;
			switch (type) {
			case 1:
				ui = new HuntingUI();
				break;
			case 2:
				ui = new MarketUI();
				break;
			case 3:
				ui = new UserPokemonUI();
				break;
			case 4:
				ui = new PokemonGuideBookUI();
				break;
			case 5:
				ui = new FightPokemonUI();
				break;
			case 0:
				ui = new ExitUI();
				break;
			default:
				System.out.println("�߸��� �Է��Դϴ�.");
			}
			if (ui != null) {
				ui.execute();
			}
		}
	}
	
	private int menu() {
		System.out.println("---------------------------------");
		System.out.println("\tPokemon GO");
		System.out.println("---------------------------------");
		System.out.println("1. ���");
		System.out.println("2. ����");
		System.out.println("3. ���� ���ϸ� ���");
		System.out.println("4. ���ϸ� ����");
		System.out.println("5. ���ϸ� VS ���ϸ�");
		System.out.println("0. ����");
		System.out.println("---------------------------------");
		int type = scanInt("�޴� �� ���ϴ� �׸��� �����ϼ��� : ");
		return type;
	
	}

}
