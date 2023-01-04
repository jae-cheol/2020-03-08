package kr.co.bit.pokemon.ui;

import java.util.List;

import kr.co.bit.pokemon.vo.PokemonVO;
import kr.co.bit.pokemon.vo.UserInfoVO;
import kr.co.bit.pokemon.vo.UserPokemonVO;
import kr.co.bit.util.Rand;

public class FightPokemonUI extends BaseUI {

	@Override
	public void execute() throws Exception {

		while (true) {
			/* intro 출력 */
			String str = "내 포켓몬으로 사냥을 해보자!!!!!\n";
			System.out.println(str);
			char[] intro = str.toCharArray();

			for (char s : intro) {
				System.out.print(s);
				try {
					Thread.sleep(100);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}

			Rand rand = new Rand();
			int monster_select = rand.rarity_Rand();
			// 포켓몬 랜덤 출몰

			UserInfoVO user = service.selectUserInfo();
			List<PokemonVO> monlist = service.selectMonsterInfo();

			// 사냥할 포켓몬과 싸울 유저 소유 포켓몬 목록 호출
			List<PokemonVO> userPokemonList = service.selectUserPokemonList();

			// UserInfoVO p1 = new UserInfoVO();
			PokemonVO mon1 = new PokemonVO();

			// 유저 소유 포켓몬 중 선택된 포켓몬 저장할 객체 생성
			PokemonVO selUserPokemon = new PokemonVO();

			System.out.println();
			System.out.println("소유 포켓몬 목록 : " + userPokemonList.size() + " 마리");
			System.out.println("-------------------------------------------------------");
			System.out.println("이름\t공격력\t방어력\t가격\t희귀도\t체력");
			System.out.println("-------------------------------------------------------");
			for (PokemonVO p : userPokemonList) {
				System.out.println(p.getName() + "\t" + p.getOffensive() + "\t" + p.getDefensive() + "\t" + p.getPrice()
						+ "\t" + p.getRarity() + "\t" + p.getLife());
			}
			if (userPokemonList.isEmpty()) {
				System.out.println("조회할 포켓몬이 없습니다.");
			}
			System.out.println("-------------------------------------------------------");

			// 포켓몬 선택

			// DB에 없는 값 입력 시 재실행 시키기 위한 변수
			boolean bool = true;
			// ll:
			while (bool) {
				// String selPokemonName = scanString("\n싸울 포켓몬을 고르세요 : ");

				// 선택한 포켓몬 이름과 DB 데이터 매치되는지 체크하는 변수
				boolean check = true;

				for (PokemonVO selPokemon : userPokemonList) {

					// 선택한 포켓몬 이름과 DB 데이터 매치되면 PokemonVO 객체에 선택한 포켓몬 데이터 저장
					if (selPokemon.getName().equals("다크라이")) {
						selUserPokemon.setStat(selPokemon.getName(), selPokemon.getOffensive(),
								selPokemon.getDefensive(), selPokemon.getPrice(), selPokemon.getRarity(),
								selPokemon.getLife());
						bool = false;
						// break ll;
					} else {
						check = false;
					}
				}
				if (!check)
					System.out.println("내 포켓몬이 아닙니다. 다시 고르세요.");
			}

			// System.out.println(monster_select);

			// for (UserInfoVO user : userlist) {
			// selUserPokemon.setStat(user.getId(), user.getOffensive()+30,
			// user.getDefensive(), user.getLife(), user.getMoney());
			// }
			// DB의 유저정보를 가져와서 selUserPokemon객체에 넣어서 사용.

			mon1.setStat(monlist.get(monster_select).getName(), monlist.get(monster_select).getOffensive(),
					monlist.get(monster_select).getDefensive(), monlist.get(monster_select).getPrice(),
					monlist.get(monster_select).getRarity(), monlist.get(monster_select).getLife());
			// DB의 포켓몬중 출몰한 포켓몬의 정보를 가져와서 mon1객체에 넣어서 사용.

			System.out.println();
			System.out.println("좋아!!! " + mon1.getName() + " 발견!!!");
			System.out.println(mon1.getName() + " 싸우자!!");
			System.out.println();
			System.out.println("-----------------------------------------------------------");
			System.out.println(selUserPokemon.toString());
			System.out.println(mon1.toString());
			System.out.println("-----------------------------------------------------------");
			
			int battle_cnt = 0;
			// 전투의 루프 횟수
			
			while (battle_cnt < 15) {
				battle_cnt++;

				selUserPokemon.Attack(mon1.getOffensive());
				mon1.Attack(selUserPokemon.getOffensive());
				// 서로 1턴씩 공격

				selUserPokemon.PrintHp(mon1.getName());
				mon1.PrintHp(selUserPokemon.getName());
				System.out.println();
				Thread.sleep(300);
				if (battle_cnt == 15) {
					System.out.println("둘 다 모두 지쳤습니다.");
					break;
				}

				if (selUserPokemon.getLife() <= 0 && mon1.getLife() <= 0) {
					System.out.println("비겼습니다. " + mon1.getName() + "이(가) 도망갑니다.");
					break;
				}
				if (selUserPokemon.getLife() <= 0 && mon1.getLife() >= 0) {
					System.out.println("졌다... " + selUserPokemon.getName() + "이(가) 도망간다!!!");
					UserPokemonVO userPokemon = new UserPokemonVO(user.getId(), selUserPokemon.getName());
					service.sellPokemon(userPokemon);
					break;
				}
				if (selUserPokemon.getLife() >= 0 && mon1.getLife() <= 0) {
					// 초기값이 1이라서 처음엔 무조건 획득하고, 리턴하기전 0으로 만들어주기 때문에 0으로 해야 잡았다는
					// 메시지
					// 출력.
					UserPokemonVO userPokemon = new UserPokemonVO(user.getId(), mon1.getName());

					if (service.insertPokemon(userPokemon) == 1) {
						System.out.println(mon1.getName() + "!!! 넌 내꺼야!!");
						System.out.println(mon1.getName() + "를 잡았습니다. 자세한 정보는 소유 포켓몬 목록을 확인해주세요.");
					} else {
						if (service.own1Pokemon(userPokemon) == 1) {
							System.out.println(mon1.getName() + "!!! 넌 내꺼야!!");
							System.out.println(mon1.getName() + "를 잡았습니다. 자세한 정보는 소유 포켓몬 목록을 확인해주세요.");
						} else
							System.out.println("이미 같은 종류 포켓몬이 있어 놔주도록 하겠습니다.");
					}

					break;
				}
			}
			
			Thread.sleep(150);
		}
	}
}
