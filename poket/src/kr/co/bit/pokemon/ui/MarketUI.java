package kr.co.bit.pokemon.ui;

import java.util.List;
import java.util.Scanner;

import kr.co.bit.pokemon.vo.PokemonVO;
import kr.co.bit.pokemon.vo.UserInfoVO;
import kr.co.bit.pokemon.vo.UserPokemonVO;

public class MarketUI extends BaseUI {

	@Override
	public void execute() throws Exception {

		List<PokemonVO> list = service.selectAllPokemonList();

		System.out.println("포켓몬 상점 목록 : " + list.size() + "개");
		System.out.println("-------------------------------------------------------");
		System.out.println("이름\t공격력\t방어력\t가격\t희귀도\t체력");
		System.out.println("-------------------------------------------------------");
		for (PokemonVO p : list) {
			System.out.println(p.getName() + "\t" + p.getOffensive() + "\t" + p.getDefensive() + "\t" + p.getPrice()
					+ "\t" + p.getRarity() + "\t" + p.getLife());
		}
		if (list.isEmpty()) {
			System.out.println("조회할 포켓몬이 없습니다.");
		}
		System.out.println("-------------------------------------------------------");

		UserInfoVO ui = service.money();
		System.out.println("현재 자금 :" + ui.getMoney());
		System.out.println("1.구매하기\t2.판매하기\t3.나가기");
		Scanner sc = new Scanner(System.in);
		int a = sc.nextInt();

		switch (a) {
		case 1: {
			boolean buyOK = true;

			while (buyOK) {
				buyOK = false;

				String name = scanString("구매할 포켓몬을 입력하세요 : ");

				UserPokemonVO userPokemon = new UserPokemonVO();
				List<PokemonVO> PokemonList = service.selectAllPokemonList();

				for (PokemonVO p : PokemonList) {
					buyOK ^= p.getName().equals(name);
					// 구매할 포켓몬 이름이 리스트에 있는건지 검사
					// false에서 하나라도 true가 있다면 마지막 결과는 true
				}
				if (buyOK == false) {
					System.out.println(name + " 해당  포켓몬 은 보유하고 있지 않습니다.");
					buyOK = true;
					continue;
				}

				userPokemon.setId("량");
				userPokemon.setName(name);
				PokemonVO pm = service.pmoney(name);

				if (ui.getMoney() < pm.getPrice()) {
					System.out.println("자금이 부족합니다.");
					break;
				} else if (service.insertPokemon(userPokemon) == 1) {
					service.UpdateMoney(pm.getPrice());
					System.out.println("구매 완료!");
					ui = service.money();
					System.out.println("현재 자금 :" + ui.getMoney());
				} else {
					 if (service.own1Pokemon(userPokemon) == 1) {
							System.out.println("구매 완료!");
							
						}else
					System.out.println("이미 가지고 있는 포켓몬입니다.");
				}
				buyOK = false;
			}
		}

			break;

		case 2:
			UserPokemonUI x = new UserPokemonUI();
			boolean sellOK = true;

			while (sellOK) {
				sellOK = false;
				x.execute();
				String name = scanString("판매할 포켓몬을 입력해주세요 : ");

				UserPokemonVO userPokemon = new UserPokemonVO();

				List<PokemonVO> userPokemonList = service.selectUserPokemonList();
				for (PokemonVO p : userPokemonList) {
					sellOK ^= p.getName().equals(name);
					// 보유 포켓몬 중에서 판매할 포켓몬이 있는지 검사
					// false에서 하나라도 true가 있다면 마지막 결과는 true
				}
				if (sellOK == false) {
					System.out.println(name + " 해당  포켓몬 은 보유하고 있지 않습니다.");
					sellOK = true;
					continue;
				}

				userPokemon.setName(name);
				PokemonVO pm = service.pmoney(name);
				int price = -pm.getPrice();
				service.UpdateMoney(price);
				service.sellPokemon(userPokemon);
				System.out.println("판매 완료!");
				ui = service.money();
				System.out.println("현재 자금 :" + ui.getMoney());

				sellOK = false;
				// 판매가 되었으면 루프 탈출
			}

			break;
		case 3:
			break;
		default:
			System.out.println("잘못된 입력입니다.");
		}

	}

}
