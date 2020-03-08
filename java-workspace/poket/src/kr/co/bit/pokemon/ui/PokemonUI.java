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
				System.out.println("잘못된 입력입니다.");
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
		System.out.println("1. 사냥");
		System.out.println("2. 마켓");
		System.out.println("3. 소유 포켓몬 목록");
		System.out.println("4. 포켓몬 도감");
		System.out.println("5. 포켓몬 VS 포켓몬");
		System.out.println("0. 종료");
		System.out.println("---------------------------------");
		int type = scanInt("메뉴 중 원하는 항목을 선택하세요 : ");
		return type;
	
	}

}
