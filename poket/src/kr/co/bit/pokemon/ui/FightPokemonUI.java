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
			/* intro ��� */
			String str = "�� ���ϸ����� ����� �غ���!!!!!\n";
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
			// ���ϸ� ���� ���

			UserInfoVO user = service.selectUserInfo();
			List<PokemonVO> monlist = service.selectMonsterInfo();

			// ����� ���ϸ�� �ο� ���� ���� ���ϸ� ��� ȣ��
			List<PokemonVO> userPokemonList = service.selectUserPokemonList();

			// UserInfoVO p1 = new UserInfoVO();
			PokemonVO mon1 = new PokemonVO();

			// ���� ���� ���ϸ� �� ���õ� ���ϸ� ������ ��ü ����
			PokemonVO selUserPokemon = new PokemonVO();

			System.out.println();
			System.out.println("���� ���ϸ� ��� : " + userPokemonList.size() + " ����");
			System.out.println("-------------------------------------------------------");
			System.out.println("�̸�\t���ݷ�\t����\t����\t��͵�\tü��");
			System.out.println("-------------------------------------------------------");
			for (PokemonVO p : userPokemonList) {
				System.out.println(p.getName() + "\t" + p.getOffensive() + "\t" + p.getDefensive() + "\t" + p.getPrice()
						+ "\t" + p.getRarity() + "\t" + p.getLife());
			}
			if (userPokemonList.isEmpty()) {
				System.out.println("��ȸ�� ���ϸ��� �����ϴ�.");
			}
			System.out.println("-------------------------------------------------------");

			// ���ϸ� ����

			// DB�� ���� �� �Է� �� ����� ��Ű�� ���� ����
			boolean bool = true;
			// ll:
			while (bool) {
				// String selPokemonName = scanString("\n�ο� ���ϸ��� ������ : ");

				// ������ ���ϸ� �̸��� DB ������ ��ġ�Ǵ��� üũ�ϴ� ����
				boolean check = true;

				for (PokemonVO selPokemon : userPokemonList) {

					// ������ ���ϸ� �̸��� DB ������ ��ġ�Ǹ� PokemonVO ��ü�� ������ ���ϸ� ������ ����
					if (selPokemon.getName().equals("��ũ����")) {
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
					System.out.println("�� ���ϸ��� �ƴմϴ�. �ٽ� ������.");
			}

			// System.out.println(monster_select);

			// for (UserInfoVO user : userlist) {
			// selUserPokemon.setStat(user.getId(), user.getOffensive()+30,
			// user.getDefensive(), user.getLife(), user.getMoney());
			// }
			// DB�� ���������� �����ͼ� selUserPokemon��ü�� �־ ���.

			mon1.setStat(monlist.get(monster_select).getName(), monlist.get(monster_select).getOffensive(),
					monlist.get(monster_select).getDefensive(), monlist.get(monster_select).getPrice(),
					monlist.get(monster_select).getRarity(), monlist.get(monster_select).getLife());
			// DB�� ���ϸ��� ����� ���ϸ��� ������ �����ͼ� mon1��ü�� �־ ���.

			System.out.println();
			System.out.println("����!!! " + mon1.getName() + " �߰�!!!");
			System.out.println(mon1.getName() + " �ο���!!");
			System.out.println();
			System.out.println("-----------------------------------------------------------");
			System.out.println(selUserPokemon.toString());
			System.out.println(mon1.toString());
			System.out.println("-----------------------------------------------------------");
			
			int battle_cnt = 0;
			// ������ ���� Ƚ��
			
			while (battle_cnt < 15) {
				battle_cnt++;

				selUserPokemon.Attack(mon1.getOffensive());
				mon1.Attack(selUserPokemon.getOffensive());
				// ���� 1�Ͼ� ����

				selUserPokemon.PrintHp(mon1.getName());
				mon1.PrintHp(selUserPokemon.getName());
				System.out.println();
				Thread.sleep(300);
				if (battle_cnt == 15) {
					System.out.println("�� �� ��� ���ƽ��ϴ�.");
					break;
				}

				if (selUserPokemon.getLife() <= 0 && mon1.getLife() <= 0) {
					System.out.println("�����ϴ�. " + mon1.getName() + "��(��) �������ϴ�.");
					break;
				}
				if (selUserPokemon.getLife() <= 0 && mon1.getLife() >= 0) {
					System.out.println("����... " + selUserPokemon.getName() + "��(��) ��������!!!");
					UserPokemonVO userPokemon = new UserPokemonVO(user.getId(), selUserPokemon.getName());
					service.sellPokemon(userPokemon);
					break;
				}
				if (selUserPokemon.getLife() >= 0 && mon1.getLife() <= 0) {
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
			}
			
			Thread.sleep(150);
		}
	}
}