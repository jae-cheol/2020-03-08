package kr.co.bit.pokemon.ui;

import java.util.List;

import kr.co.bit.pokemon.vo.PokemonVO;
import kr.co.bit.pokemon.vo.UserInfoVO;
import kr.co.bit.pokemon.vo.UserPokemonVO;
import kr.co.bit.util.Rand;

public class HuntingUI extends BaseUI {

	@Override
	public void execute() throws Exception {
//		while (true) {
			/* intro 출력 */
			String str = "사냥을 떠나볼까!!!!!\n";
			System.out.println(str);
			// char[] intro = str.toCharArray();
			//
			// for (char s : intro) {
			// System.out.print(s);
			// try {
			// Thread.sleep(150);
			// } catch (InterruptedException e) {
			// e.printStackTrace();
			// }
			// }

			Rand rand = new Rand();
			int monster_select = rand.rarity_Rand();
			// 포켓몬 랜덤 출몰

			UserInfoVO user = service.selectUserInfo();
			List<PokemonVO> monlist = service.selectMonsterInfo();

			// UserInfoVO user = new UserInfoVO();
			PokemonVO mon1 = new PokemonVO();

			// System.out.println(monster_select);

			// for (UserInfoVO user : userlist) {
			// user.setStat(user.getId(), user.getOffensive()+30,
			// user.getDefensive(), user.getLife(), user.getMoney());
			// }
			// DB의 유저정보를 가져와서 user객체에 넣어서 사용.

			mon1.setStat(monlist.get(monster_select).getName(), monlist.get(monster_select).getOffensive(),
					monlist.get(monster_select).getDefensive(), monlist.get(monster_select).getPrice(),
					monlist.get(monster_select).getRarity(), monlist.get(monster_select).getLife());
			// DB의 포켓몬중 출몰한 포켓몬의 정보를 가져와서 mon1객체에 넣어서 사용.

			System.out.println();
			System.out.println("좋아!!! " + mon1.getName() + " 발견!!!");
			System.out.println(mon1.getName() + " 싸우자!!");
			System.out.println();
			System.out.println("-----------------------------------------------------------");
			System.out.println(user.toString());
			System.out.println(mon1.toString());
			System.out.println("-----------------------------------------------------------");

			int battle_cnt = 0;
			// 전투의 루프 횟수

			while (battle_cnt < 15) {
				battle_cnt++;

				user.Attack(mon1.getOffensive());
				mon1.Attack(user.getOffensive());
				// 서로 1턴씩 공격

				user.PrintHp(mon1.getName());
				mon1.PrintHp(user.getId());
				System.out.println();
				Thread.sleep(300);
				if (battle_cnt == 15) {
					System.out.println("둘다 모두 지쳤습니다.");
					break;
				}

				if (user.getLife() <= 0 && mon1.getLife() <= 0) {
					System.out.println("비겼습니다. 몬스터가 도망갑니다.");
					break;
				}
				if (user.getLife() <= 0 && mon1.getLife() >= 0) {
					System.out.println("졌다...도망가자!!!");
					break;
				}
				if (user.getLife() >= 0 && mon1.getLife() <= 0) {
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
//			}
		}
	}
}
