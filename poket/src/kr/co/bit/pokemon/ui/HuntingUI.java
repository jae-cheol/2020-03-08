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
			/* intro ��� */
			String str = "����� ��������!!!!!\n";
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
			// ���ϸ� ���� ���

			UserInfoVO user = service.selectUserInfo();
			List<PokemonVO> monlist = service.selectMonsterInfo();

			// UserInfoVO user = new UserInfoVO();
			PokemonVO mon1 = new PokemonVO();

			// System.out.println(monster_select);

			// for (UserInfoVO user : userlist) {
			// user.setStat(user.getId(), user.getOffensive()+30,
			// user.getDefensive(), user.getLife(), user.getMoney());
			// }
			// DB�� ���������� �����ͼ� user��ü�� �־ ���.

			mon1.setStat(monlist.get(monster_select).getName(), monlist.get(monster_select).getOffensive(),
					monlist.get(monster_select).getDefensive(), monlist.get(monster_select).getPrice(),
					monlist.get(monster_select).getRarity(), monlist.get(monster_select).getLife());
			// DB�� ���ϸ��� ����� ���ϸ��� ������ �����ͼ� mon1��ü�� �־ ���.

			System.out.println();
			System.out.println("����!!! " + mon1.getName() + " �߰�!!!");
			System.out.println(mon1.getName() + " �ο���!!");
			System.out.println();
			System.out.println("-----------------------------------------------------------");
			System.out.println(user.toString());
			System.out.println(mon1.toString());
			System.out.println("-----------------------------------------------------------");

			int battle_cnt = 0;
			// ������ ���� Ƚ��

			while (battle_cnt < 15) {
				battle_cnt++;

				user.Attack(mon1.getOffensive());
				mon1.Attack(user.getOffensive());
				// ���� 1�Ͼ� ����

				user.PrintHp(mon1.getName());
				mon1.PrintHp(user.getId());
				System.out.println();
				Thread.sleep(300);
				if (battle_cnt == 15) {
					System.out.println("�Ѵ� ��� ���ƽ��ϴ�.");
					break;
				}

				if (user.getLife() <= 0 && mon1.getLife() <= 0) {
					System.out.println("�����ϴ�. ���Ͱ� �������ϴ�.");
					break;
				}
				if (user.getLife() <= 0 && mon1.getLife() >= 0) {
					System.out.println("����...��������!!!");
					break;
				}
				if (user.getLife() >= 0 && mon1.getLife() <= 0) {
					// �ʱⰪ�� 1�̶� ó���� ������ ȹ���ϰ�, �����ϱ��� 0���� ������ֱ� ������ 0���� �ؾ� ��Ҵٴ�
					// �޽���
					// ���.
					UserPokemonVO userPokemon = new UserPokemonVO(user.getId(), mon1.getName());
					if (service.insertPokemon(userPokemon) == 1) {
						System.out.println(mon1.getName() + "!!! �� ������!!");
						System.out.println(mon1.getName() + "�� ��ҽ��ϴ�. �ڼ��� ������ ���� ���ϸ� ����� Ȯ�����ּ���.");
					} else {
						if (service.own1Pokemon(userPokemon) == 1) {
							System.out.println(mon1.getName() + "!!! �� ������!!");
							System.out.println(mon1.getName() + "�� ��ҽ��ϴ�. �ڼ��� ������ ���� ���ϸ� ����� Ȯ�����ּ���.");
						} else
							System.out.println("�̹� ���� ���� ���ϸ��� �־� ���ֵ��� �ϰڽ��ϴ�.");
					}
					break;
				}
//			}
		}
	}
}
